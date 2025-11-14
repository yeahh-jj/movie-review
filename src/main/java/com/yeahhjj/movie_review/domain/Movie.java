package com.yeahhjj.movie_review.domain;

public class Movie {
    private final String title;
    private final Genre genre;
    private final String director;

    public Movie(String title, Genre genre, String director) {
        this.title = title;
        this.genre = genre;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public Genre getGenre() {
        return genre;
    }
}
