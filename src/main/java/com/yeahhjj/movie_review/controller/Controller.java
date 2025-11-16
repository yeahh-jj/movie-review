package com.yeahhjj.movie_review.controller;

import com.yeahhjj.movie_review.service.Service;
import com.yeahhjj.movie_review.view.MovieInputView;
import com.yeahhjj.movie_review.view.MovieOutputView;
import com.yeahhjj.movie_review.view.ReviewInputView;
import com.yeahhjj.movie_review.view.ReviewOutputView;

public class Controller {
    private final Service service = new Service();

    public void run() {
        registerMovie();
        registerReview();
    }

    private void registerMovie() {
        MovieOutputView.printRegisterMovieHeader();

        String title = MovieInputView.inputTitle();
        String director = MovieInputView.inputDirector();
        String genreId = MovieInputView.inputGenreId();

        service.registerMovie(title, genreId, director);

        MovieOutputView.printMovieRegistrationSuccess();
    }

    private void registerReview() {
        ReviewOutputView.printRegisterReviewHeader();

        String movieId = ReviewInputView.inputMovieId(service.getMovies());
        String ratingValue = ReviewInputView.inputRating();
        String content = ReviewInputView.inputContent();

        service.registerReview(movieId, ratingValue, content);

        ReviewOutputView.printReviewRegistrationSuccess();
    }
}
