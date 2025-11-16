package com.yeahhjj.movie_review.controller;

import com.yeahhjj.movie_review.service.Service;
import com.yeahhjj.movie_review.view.MenuInputView;
import com.yeahhjj.movie_review.view.MenuOutputView;
import com.yeahhjj.movie_review.view.MovieInputView;
import com.yeahhjj.movie_review.view.MovieOutputView;
import com.yeahhjj.movie_review.view.ReviewInputView;
import com.yeahhjj.movie_review.view.ReviewOutputView;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private final Service service = new Service();
    private final Map<String, Runnable> menuHandlers = new HashMap<>();

    public Controller() {
        menuHandlers.put("1", this::registerMovie);
        menuHandlers.put("2", this::registerReview);
        menuHandlers.put("3", this::showReviews);
        menuHandlers.put("4", this::exitProgram);
    }

    public void run() {
        MenuOutputView.printMainMenu();
        String menu = MenuInputView.inputMenuNum().trim();

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

    private void showReviews() {

    }

    private void exitProgram() {

    }
}
