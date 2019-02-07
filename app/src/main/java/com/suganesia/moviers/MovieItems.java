package com.suganesia.moviers;

import android.os.Debug;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONObject;

import java.text.DecimalFormat;

public class MovieItems {
    private int id;
    private String title;
    private String overview;
    private String rating;
    private String releaseDate;
    private String imgUrl;
    private String language;

    public  MovieItems(JSONObject object){
        try {
            int id = object.getInt("id");
            String title = object.getString("title");
            String overview = object.getString("overview");
            String rating = object.getString("vote_average");
            String releaseDate = object.getString("release_date");
            String imgUrl = "https://image.tmdb.org/t/p/w185" +
                    object.getString("poster_path");
            String language = object.getString("original_language");

            this.id = id;
            this.title = title;
            this.overview = overview;
            this.rating = rating;
            this.releaseDate = releaseDate;
            this.imgUrl = imgUrl;
            this.language = language;

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
}
