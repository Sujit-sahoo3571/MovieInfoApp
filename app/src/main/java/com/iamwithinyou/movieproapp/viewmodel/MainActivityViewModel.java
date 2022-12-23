package com.iamwithinyou.movieproapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.iamwithinyou.movieproapp.model.Movie;
import com.iamwithinyou.movieproapp.repo.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository(application);
    }

    //Live Data
    public LiveData<List<Movie>> getAllMovies(){
        return  movieRepository.getMutableLiveData();
    }
}
