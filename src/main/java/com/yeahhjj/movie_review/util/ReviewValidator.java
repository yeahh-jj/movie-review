package com.yeahhjj.movie_review.util;

import com.yeahhjj.movie_review.domain.Movie;
import java.util.List;

public class ReviewValidator {
    private final static double MIN = 0.0;
    private final static double MAX = 5.0;

    public static int validateMovieId(String movieId, List<Movie> movies) {
        int inputMovieId = ReviewParser.checkMovieId(movieId);

        return movies.stream()
                .filter(m -> m.getId() == inputMovieId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 ID의 영화가 존재하지 않습니다."))
                .getId();
    }

    public static double validateRating(String rating) {
        double reviewRating = ReviewParser.checkRating(rating);

        System.out.println("[DEBUG] reviewRating = " + reviewRating);

        rangeOfRating(reviewRating);
        halfRating(reviewRating);
        return reviewRating;
    }

    private static void rangeOfRating(double rating) {
        if (rating < MIN || rating > MAX) {
            throw new IllegalArgumentException("[ERROR] 평점은 0.0~5.0 범위여야 합니다.");
        }
    }

    private static void halfRating(double rating) {
        if (rating * 10 % 5 != 0) {
            throw new IllegalArgumentException("[ERROR] 평점은 0.5 단위로 입력해야 합니다.");
        }
    }
}
