package com.glacion.retro.model;

import com.google.gson.annotations.SerializedName;

public class User {
  @SerializedName("html_url")
  private final String url;

  private final String login;
  private final float score;

  public User(String url, String login, float score) {
    this.url = url;
    this.login = login;
    this.score = score;
  }

  public String getUrl() {
    return url;
  }

  public String getLogin() {
    return login;
  }

  public float getScore() {
    return score;
  }
}
