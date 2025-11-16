package com.yeahhjj.movie_review.controller;

import com.yeahhjj.movie_review.service.Service;
import com.yeahhjj.movie_review.view.MovieInputView;
import com.yeahhjj.movie_review.view.MovieOutputView;

public class Controller {
    private final Service service = new Service();

    public void run() {
        registerMovie();
    }

    private void registerMovie() {
        MovieOutputView.printRegisterMovieHeader();

        String title = MovieInputView.inputTitle();
        String director = MovieInputView.inputDirector();
        String genreId = MovieInputView.inputGenreId();

        service.registerMovie(title, genreId, director);

        MovieOutputView.printMovieRegistrationSuccess();
    }
}
