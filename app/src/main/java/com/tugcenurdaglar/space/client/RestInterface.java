package com.tugcenurdaglar.space.client;

import com.tugcenurdaglar.space.pojomodels.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInterface {

    @GET("v2/launches")
    Call<List<Repo>> getRepo();
}
