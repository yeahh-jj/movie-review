package com.yeahhjj.movie_review.util;

public class ReviewParser {
    public static int checkMovieId(String movieId) {
        isBlankMovieId(movieId);
        return parseMovieId(movieId);
    }

    private static void isBlankMovieId(String movieId) {
        if(movieId == null || movieId.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 영화 ID를 입력해야 합니다.");
        }
    }

    private static int parseMovieId(String movieId) {
        try {
            return Integer.parseInt(movieId);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 영화 ID는 숫자만 입력해야 합니다.");
        }
    }

    public static double checkRating(String rating) {
        isBlankRating(rating);
        return parseRating(rating);
    }

    private static void isBlankRating(String rating) {
        if (rating == null || rating.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 평점을 입력해야 합니다.");
        }
    }

    private static Double parseRating(String rating) {
        try {
            return Double.parseDouble(rating.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 평점은 숫자 입력만 가능합니다.");
        }
    }

    public static void isBlankContent(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 감상평을 입력해야 합니다.");
        }
    }
}
