package com.glacion.retro.model;

import com.google.gson.annotations.SerializedName;

public class Repository {
  @SerializedName("full_name")
  private final String name;

  @SerializedName("html_url")
  private final String url;

  private final String description;
  private final String language;
  private final int forks;
  private final int stars;

  public Repository(
    String name, String url, String description, String language, int forks, int stars) {
    this.name = name;
    this.url = url;
    this.description = description;
    this.language = language;
    this.forks = forks;
    this.stars = stars;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }

  public String getDescription() {
    return description;
  }

  public String getLanguage() {
    return language;
  }

  public int getForks() {
    return forks;
  }

  public int getStars() {
    return stars;
  }
}
