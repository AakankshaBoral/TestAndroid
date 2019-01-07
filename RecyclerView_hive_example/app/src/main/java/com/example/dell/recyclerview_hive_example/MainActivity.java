package com.example.dell.recyclerview_hive_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movie movie = movieList.get(position);
                Toast.makeText(getApplicationContext(),movie.getTitle()+" Movie is Selected!",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        prepareMovieData();
    }

    private void prepareMovieData() {

         Movie movie = new Movie("The Circle","Science Fiction & Thriller","2017");
         movieList.add(movie);

         movie = new Movie("The Lion","Drama","2016");
         movieList.add(movie);

         movie = new Movie("La La Land","Drama","2016");
         movieList.add(movie);

         movie = new Movie("The Martian","Science Fiction & Fantasy","2015");
         movieList.add(movie);

         movie = new Movie("Inside Out","Animation, Kids & Family","2015");
         movieList.add(movie);

         movie = new Movie("Mad Max:Fury Road","Action & Adventure","2015");
         movieList.add(movie);

         movie = new Movie("Star Wars : Episode-VII The force Awakens","Action","2015");
         movieList.add(movie);

         movie = new Movie("Steve Jobs","Drama","2015");
         movieList.add(movie);

         movie = new Movie("Mission: Imposible Rouge Nation","Action","2015");
         movieList.add(movie);

         movie = new Movie("Gaurdians Of The Galaxy","Science Fiction & Fantasy","2014");
         movieList.add(movie);

         movie = new Movie("Die Hard : 5","Action & Thriller","2013");
         movieList.add(movie);

         movie = new Movie("Star Trek ","Science Fiction","2009");
         movieList.add(movie);

         movie = new Movie("Die Hard : 4","Action & Thriller","2009");
         movieList.add(movie);

         movie = new Movie("Eternal Sunshine Of The Spotless Mind","Science Fiction","2009");
         movieList.add(movie);

         movie = new Movie("Letters To Juliet","Drama","2009");
         movieList.add(movie);

         movie = new Movie("Pirates Of Carribean","Action & Thriller","2009");
         movieList.add(movie);

         movie = new Movie("Iron Man","Action & Adventure","2008");
         movieList.add(movie);

         movie = new Movie("Titanic","Drama","2002");
         movieList.add(movie);

         movie = new Movie("Pirates Of Silicon Valley","Drama","2002");
         movieList.add(movie);

         mAdapter.notifyDataSetChanged();
    }
}
