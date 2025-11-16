package com.yeahhjj.movie_review.view;

import com.yeahhjj.movie_review.domain.Movie;
import java.util.List;

public class ReviewOutputView {
    public static void printRegisterReviewHeader() {
        System.out.println("====== 리뷰 등록 ======");
    }

    public static void printMovieList(List<Movie> movies) {
        System.out.println("--- 영화 목록 ---");

        int id = 1;
        for(Movie movie : movies) {
            System.out.println(id + "." + movie.getTitle());
            id++;
        }
    }

    public static void printReviewRegistrationSuccess() {
        System.out.println("✅ 리뷰가 등록되었습니다!");
    }
}
