package com.iamwithinyou.movieproapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.iamwithinyou.movieproapp.R;
import com.iamwithinyou.movieproapp.databinding.MovieItemListBinding;
import com.iamwithinyou.movieproapp.model.Movie;
import com.iamwithinyou.movieproapp.view.MovieActivity;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Context context;
    private ArrayList<Movie> movieList ;

    public MovieAdapter(Context context, ArrayList<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                               int viewType) {
        MovieItemListBinding movieItemListBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                        R.layout.movie_item_list, parent, false) ;

        return new MovieViewHolder(movieItemListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder,
                                 int position) {
        Movie movie = movieList.get(position);
        holder.movieItemListBinding.setMovie(movie);

    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0: movieList.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private  MovieItemListBinding movieItemListBinding;

        public MovieViewHolder(
                                MovieItemListBinding movieItemListBinding) {
            super(movieItemListBinding.getRoot());
            this.movieItemListBinding = movieItemListBinding;

            movieItemListBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        Movie selectedMovie = movieList.get(position);

                        Intent i = new Intent(context, MovieActivity.class);
                        i.putExtra("movie", selectedMovie);
                        context.startActivity(i);
                    }
                }
            });
        }

    }
}
