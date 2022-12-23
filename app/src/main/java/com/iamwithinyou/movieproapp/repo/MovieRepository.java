package com.iamwithinyou.movieproapp.repo;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.iamwithinyou.movieproapp.R;
import com.iamwithinyou.movieproapp.model.Movie;
import com.iamwithinyou.movieproapp.model.Result;
import com.iamwithinyou.movieproapp.service.MovieDataServices;
import com.iamwithinyou.movieproapp.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData =
            new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        MovieDataServices movieDataServices = RetrofitInstance.getService();

        Call<Result> call =
                movieDataServices
                        .getPopularMovies(
                                application.getApplicationContext()
                                        .getString(R.string.api_key));

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call,
                                   Response<Result> response) {
                Result result = response.body();
                if (result != null && result.getResults() != null) {
                    movies = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
