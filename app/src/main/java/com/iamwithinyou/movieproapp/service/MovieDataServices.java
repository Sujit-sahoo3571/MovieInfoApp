package com.iamwithinyou.movieproapp.service;

import com.iamwithinyou.movieproapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataServices {

    //Base Url
//    https://api.themoviedb.org/3/

//    End_Point url
    //    movie/popular?api_key=7942fa35459f7fe2d2a4540748f8f005

    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key")  String apiKey);
}
