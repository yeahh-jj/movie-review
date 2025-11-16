package com.yeahhjj.movie_review.controller;

import com.yeahhjj.movie_review.service.Service;
import com.yeahhjj.movie_review.util.MovieParser;
import com.yeahhjj.movie_review.util.MovieValidator;
import com.yeahhjj.movie_review.util.ReviewParser;
import com.yeahhjj.movie_review.util.ReviewValidator;
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
    private boolean running = true;

    private final Map<String, Runnable> menuHandlers = new HashMap<>();

    public Controller() {
        menuHandlers.put("1", this::registerMovie);
        menuHandlers.put("2", this::registerReview);
        menuHandlers.put("3", this::showReviews);
        menuHandlers.put("4", this::exitProgram);
    }

    public void run() {
        while (running) {
            MenuOutputView.printMainMenu();
            String menu = MenuInputView.inputMenuNumber().trim();
            handleMenu(menu);
        }
    }

    private void handleMenu(String menu) {
        Runnable handler = menuHandlers.get(menu);
        if (handler == null) {
            System.out.println("[ERROR] 올바른 번호를 입력하세요.");
            return;
        }
        handler.run();
    }

    private void registerMovie() {
        MovieOutputView.printRegisterMovieHeader();

        String title;
        String director;
        int genreId;

        while (true) {
            title = MovieInputView.inputTitle();
            try {
                MovieValidator.validateTitle(title, service.getMovies());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            director = MovieInputView.inputDirector();
            try {
                MovieParser.isBlankDirector(director);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            String genre = MovieInputView.inputGenreId();
            try {
                genreId = MovieValidator.validateGenreId(genre);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        service.registerMovie(title, genreId, director);

        MovieOutputView.printMovieRegistrationSuccess();
    }


    private void registerReview() {
        ReviewOutputView.printRegisterReviewHeader();

        int id;
        double rating;
        String content;

        while (true) {
            String inputId = ReviewInputView.inputMovieId(service.getMovies());
            try {
                id = ReviewValidator.validateMovieId(inputId, service.getMovies());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            String inputRating = ReviewInputView.inputRating();
            try {
                rating = ReviewValidator.validateRating(inputRating);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            content = ReviewInputView.inputContent();
            try {
                ReviewParser.isBlankContent(content);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        service.registerReview(id, rating, content);

        ReviewOutputView.printReviewRegistrationSuccess();

    }

    private void showReviews() {
        ReviewOutputView.printReviews(service);
    }

    private void exitProgram() {
        System.out.println("프로그램을 종료합니다.");
        running = false;
    }
}
