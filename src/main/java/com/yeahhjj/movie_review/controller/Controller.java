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
import java.util.function.Function;
import java.util.function.Supplier;

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

        String title = getValidatedInput(
                MovieInputView::inputTitle,
                t -> {
                    MovieValidator.validateTitle(t, service.getMovies());
                    return t;
                }
        );

        String director = getValidatedInput(
                MovieInputView::inputDirector,
                d -> {
                    MovieParser.isBlankDirector(d);
                    return d;
                }
        );

        int genreId = getValidatedInput(
                MovieInputView::inputGenreId,
                g -> MovieValidator.validateGenreId(g)
        );

        service.registerMovie(title, genreId, director);

        MovieOutputView.printMovieRegistrationSuccess();
    }


    private void registerReview() {
        ReviewOutputView.printRegisterReviewHeader();

        int id = getValidatedInput(
                () -> ReviewInputView.inputMovieId(service.getMovies()),
                idStr -> ReviewValidator.validateMovieId(idStr, service.getMovies())
        );

        double rating = getValidatedInput(
                ReviewInputView::inputRating,
                r -> ReviewValidator.validateRating(r)
        );

        String content = getValidatedInput(
                ReviewInputView::inputContent,
                c -> {
                    ReviewParser.isBlankContent(c);
                    return c;
                }
        );

        service.registerReview(id, rating, content);

        ReviewOutputView.printReviewRegistrationSuccess();

    }

    private <T, R> R getValidatedInput(Supplier<T> inputSupplier, Function<T, R> validator) {
        while (true) {
            T input = inputSupplier.get();
            try {
                return validator.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void showReviews() {
        ReviewOutputView.printReviews(service);
    }

    private void exitProgram() {
        System.out.println("프로그램을 종료합니다.");
        running = false;
    }
}
