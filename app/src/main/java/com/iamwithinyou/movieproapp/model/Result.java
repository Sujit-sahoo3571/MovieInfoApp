package com.iamwithinyou.movieproapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Result implements Parcelable {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<Movie> results = null;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;



    // Parcel creator
    public static final  Parcelable.Creator<Result> CREATOR  = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel source) {
            return new Result(source);
        }

        @Override
        public Result[] newArray(int i) {
            return new Result[i];
        }
    };

    //
    // constructor


    public Result() {
    }

    public Result(Parcel in) {
        this.page = ((Integer) in.readValue(Integer.class.getClassLoader()));
        this.totalResults = ((Integer) in.readValue(Integer.class.getClassLoader()));
        this.totalPages = ((Integer) in.readValue(Integer.class.getClassLoader()));
//        this.results = results;
        in.readList(this.results,
                com.iamwithinyou.movieproapp.model.Movie.class.getClassLoader());
    }

    //

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeValue(page);
        parcel.writeValue(totalPages);
        parcel.writeList(results);
        parcel.writeValue(totalResults);

    }
}