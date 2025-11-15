package com.yeahhjj.movie_review.service;

import com.yeahhjj.movie_review.domain.Genre;
import com.yeahhjj.movie_review.domain.Movie;
import com.yeahhjj.movie_review.domain.Review;
import com.yeahhjj.movie_review.util.MovieParser;
import com.yeahhjj.movie_review.util.MovieValidator;
import com.yeahhjj.movie_review.util.ReviewParser;
import com.yeahhjj.movie_review.util.ReviewValidator;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private final List<Movie> movies = new ArrayList<>();
    private final List<Review> reviews = new ArrayList<>();

    public void registerMovie(String title, String genreId, String director) {
        MovieValidator.validateTitle(title, movies);
        int genre = MovieValidator.validateGenreId(genreId);
        MovieParser.isBlankDirector(director);

        movies.add(new Movie(title, Genre.getGenre(genre), director));
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void registerReview(String id, String ratingValue, String content) {
        int movieId = ReviewValidator.validateMovieId(id, movies);
        double rating = ReviewValidator.validateRating(ratingValue);
        ReviewParser.isBlankContent(content);

        reviews.add(new Review(movieId, rating, content));
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
