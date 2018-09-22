package com.glacion.retro.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserSearch {
  @SerializedName("total_count")
  private final int totalCount;

  @SerializedName("items")
  private final List<User> users;

  public int getTotalCount() {
    return totalCount;
  }

  public List<User> getUsers() {
    return users;
  }

  public UserSearch(int totalCount, List<User> users) {
    this.totalCount = totalCount;
    this.users = users;
  }
}
