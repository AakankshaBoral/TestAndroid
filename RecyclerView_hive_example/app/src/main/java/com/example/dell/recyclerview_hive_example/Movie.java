package com.example.dell.recyclerview_hive_example;

/**
 * Created by dell on 19-08-2017.
 */

public class Movie {

    String title;
    String genre;
    String year;

    public Movie(String title,String genre,String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


}
