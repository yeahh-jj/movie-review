package com.yeahhjj.movie_review.util;

public class MovieParser {
    public static void isBlankTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 영화 제목은 비워둘 수 없습니다.");
        }
    }

    public static int checkGenreId(String id) {
        isBlankGenreId(id);
        return parseGenreId(id);
    }

    private static void isBlankGenreId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 장르 ID를 선택해야 합니다.");
        }
    }

    private static int parseGenreId(String id) {
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 장르 ID는 숫자만 입력해야 합니다.");
        }
    }

    public static void isBlankDirector(String director) {
        if (director == null || director.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 영화 감독을 입력해야 합니다.");
        }
    }
}
