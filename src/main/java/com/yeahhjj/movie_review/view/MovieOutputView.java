package com.yeahhjj.movie_review.view;

import com.yeahhjj.movie_review.domain.Genre;

public class MovieOutputView {
    public static void printRegisterMovieHeader() {
        System.out.println("====== 영화 등록 ======");
    }

    public static void printGenreList() {
        System.out.println("--- 장르 목록 ---");

        for (Genre genre : Genre.values()) {
            System.out.println(genre.getGenreId() + "." + genre.getDisplayName());
        }

        System.out.println("---------------");
    }

    public static void printMovieRegistrationSuccess() {
        System.out.println("✅ 영화가 등록되었습니다!");
    }
}
