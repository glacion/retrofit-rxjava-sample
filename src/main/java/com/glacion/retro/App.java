package com.glacion.retro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Scanner;

public class App {
  private final String url = "https://api.github.com";
  private final Gson gson = new GsonBuilder().setLenient().create();

  private final Retrofit retrofit =
      new Retrofit.Builder()
          .baseUrl(url)
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .build();

  private final API api = retrofit.create(API.class);

  private final Scanner scan = new Scanner(System.in);

  private final String horizontalLine = new String(new char[32]).replace("\0", "-");

  public static void main(String[] args) {
    final App app = new App();
    System.out.print("Query: ");
    final String name = app.scan.nextLine();
    System.out.println(app.horizontalLine + "Users" + app.horizontalLine);
    app.api
        // Make an API call
        .getUsers(name)
        // Use blocking subscription for program to not terminate while working on background.
        .blockingSubscribe(
            search ->
                search
                    .getUsers()
                    .forEach(
                        user ->
                            System.out.printf(
                                "%-20s %-40s %f %n%n",
                                user.getLogin(), user.getUrl(), user.getScore())));

    System.out.println(app.horizontalLine + "Repositories" + app.horizontalLine);

    app.api
        .getRepositories(name)
        .blockingSubscribe(
            repositorySearch ->
                repositorySearch
                    .getRepositories()
                    .forEach(
                        repository ->
                            System.out.printf(
                                "%-40s %-40s %n %-20s %26s %10s %n %s %n%n",
                                repository.getName(),
                                (repository.getDescription() == null)
                                    ? "No description provided"
                                    : repository.getDescription(),
                                (repository.getLanguage() == null)
                                    ? "No language"
                                    : repository.getLanguage(),
                                repository.getForks() + " forks",
                                repository.getStars() + " stars",
                                repository.getUrl())));
  }
}
