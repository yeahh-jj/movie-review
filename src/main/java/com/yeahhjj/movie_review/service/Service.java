package com.yeahhjj.movie_review.service;

import com.yeahhjj.movie_review.domain.Genre;
import com.yeahhjj.movie_review.domain.Movie;
import com.yeahhjj.movie_review.domain.Review;
import com.yeahhjj.movie_review.util.ReviewParser;
import com.yeahhjj.movie_review.util.ReviewValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private final List<Movie> movies = new ArrayList<>();
    private final List<Review> reviews = new ArrayList<>();

    private int movieId = 1;

    public void registerMovie(String title, int genreId, String director) {
        movies.add(new Movie(movieId++, title, Genre.getGenre(genreId), director));
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void registerReview(int id, double rating, String content) {
        reviews.add(new Review(movieId, rating, content));
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Review> findReviewsByMovieId(int movieId) {
        return reviews.stream()
                .filter(review -> review.getMovieId() == movieId)
                .collect(Collectors.toList());
    }

    public double averageRating(int movieId) {
        List<Review> reviewsForMovie = findReviewsByMovieId(movieId);

        return reviewsForMovie.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);
    }
}
