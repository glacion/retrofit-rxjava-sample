package com.glacion.retro;

import com.glacion.retro.model.RepositorySearch;
import com.glacion.retro.model.UserSearch;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
  @GET("/search/users")
  Observable<UserSearch> getUsers(@Query("q") String name);

  @GET("/search/repositories")
  Observable<RepositorySearch> getRepositories(@Query("q") String name);
}
