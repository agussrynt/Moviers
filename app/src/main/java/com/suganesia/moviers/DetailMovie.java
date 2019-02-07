package com.suganesia.moviers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailMovie extends AppCompatActivity {
    TextView tvTitle;
    TextView tvOverview;
    TextView tvRating;
    TextView tvRelease;
    TextView tvLanguage;
    ImageView ivIcon;

    public static final String TITLE = "title";
    public static final String OVERVIEW = "overview";
    public static final String URL = "url";
    public static final String RATING = "rating";
    public static final String RELEASE = "release";
    public static final String LANGUAGE = "language";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);
        tvRating = findViewById(R.id.tvRating);
        tvRelease = findViewById(R.id.tvRelease);
        tvLanguage = findViewById(R.id.tvLanguage);
        ivIcon = findViewById(R.id.detailIcon);

        String title = getIntent().getStringExtra(TITLE);
        String overview = getIntent().getStringExtra(OVERVIEW);
        String url = getIntent().getStringExtra(URL);
        String rating = getIntent().getStringExtra(RATING);
        String release = getIntent().getStringExtra(RELEASE);
        String language = getIntent().getStringExtra(LANGUAGE);

        //Log.i("CEK","woetot " + url);

        tvTitle.setText(title);
        tvOverview.setText(overview);
        tvRating.setText(rating+"/10");
        tvRelease.setText(release);
        tvLanguage.setText(language);
        Picasso.get().load(url).into(ivIcon);

    }
}
