package com.yeahhjj.movie_review.controller;

import com.yeahhjj.movie_review.view.MovieInputView;
import com.yeahhjj.movie_review.view.MovieOutputView;

public class Controller {
    public void run() {
        registerMovie();
    }

    private void registerMovie() {
        MovieOutputView.printRegisterMovieHeader();

        MovieInputView.inputTitle();
        MovieInputView.inputDirector();
        MovieInputView.inputGenreId();

        MovieOutputView.printMovieRegistrationSuccess();
    }
}
