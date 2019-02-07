package com.suganesia.moviers;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<MovieItems>>{
    ListView listView ;
    MovieAdapter adapter;
    EditText cariMovie;
    Button buttonCari;
    ProgressBar pgBar;


    static final String EXTRAS_MOVIE = "EXTRAS_MOVIE";
    private static final int MAX_COUNT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        adapter.notifyDataSetChanged();
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        cariMovie = findViewById(R.id.cari_movie);
        buttonCari = findViewById(R.id.btn_cari);

        pgBar = findViewById(R.id.pgBar);

        buttonCari.setOnClickListener(myListener);
        listView.setOnItemClickListener(lvListener);

        String movie = cariMovie.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRAS_MOVIE,movie);

        getLoaderManager().initLoader(0, bundle, this);
    }

    @Override
    public Loader<ArrayList<MovieItems>> onCreateLoader(int id, Bundle args) {
        String movie = "";

        if (args != null){
            movie = args.getString(EXTRAS_MOVIE);
        }

        return new MyAsyncTaskLoader(this,movie);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<MovieItems>> loader, ArrayList<MovieItems> data) {
        adapter.setData(data);
        pgBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<MovieItems>> loader) {
        adapter.setData(null);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String movie = cariMovie.getText().toString();

            if (TextUtils.isEmpty(movie))return;

            pgBar.setVisibility(View.VISIBLE);
            Bundle bundle = new Bundle();
            bundle.putString(EXTRAS_MOVIE,movie);
            getLoaderManager().restartLoader(0,bundle,MainActivity.this);
        }
    };

    AdapterView.OnItemClickListener lvListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent mIntent = new Intent(getApplicationContext(),DetailMovie.class);
            mIntent.putExtra(DetailMovie.TITLE,adapter.getItem(position).getTitle());
            mIntent.putExtra(DetailMovie.OVERVIEW,adapter.getItem(position).getOverview());
            mIntent.putExtra(DetailMovie.URL,adapter.getItem(position).getImgUrl());
            mIntent.putExtra(DetailMovie.RATING,adapter.getItem(position).getRating());
            mIntent.putExtra(DetailMovie.RELEASE,adapter.getItem(position).getReleaseDate());
            mIntent.putExtra(DetailMovie.LANGUAGE,adapter.getItem(position).getLanguage());

            startActivity(mIntent);
        }
    };
}
