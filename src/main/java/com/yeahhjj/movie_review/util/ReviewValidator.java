package com.yeahhjj.movie_review.util;

public class ReviewValidator {
    private final static double MIN = 0.0;
    private final static double MAX = 5.0;

    public static void validateRating(double rating) {
        rangeOfRating(rating);
        halfRating(rating);
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
