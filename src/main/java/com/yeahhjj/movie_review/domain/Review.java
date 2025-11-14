package com.yeahhjj.movie_review.domain;

public class Review {
    private final int movieId;
    private final double rating;
    private final String content;

    public Review(int movieId, double rating, String content) {
        this.movieId = movieId;
        this.rating = rating;
        this.content = content;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getContent() {
        return content;
    }

    public double getRating() {
        return rating;
    }
}
