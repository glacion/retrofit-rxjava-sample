package com.glacion.retro.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RepositorySearch {
  @SerializedName("total_count")
  private final int totalCount;

  @SerializedName("items")
  private final List<Repository> repositories;

  public RepositorySearch(int totalCount, List<Repository> repositories) {
    this.totalCount = totalCount;
    this.repositories = repositories;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public List<Repository> getRepositories() {
    return repositories;
  }
}
