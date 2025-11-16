package com.yeahhjj.movie_review.view;

import com.yeahhjj.movie_review.domain.Movie;
import com.yeahhjj.movie_review.domain.Review;
import com.yeahhjj.movie_review.service.Service;
import java.util.List;

public class ReviewOutputView {
    public static void printRegisterReviewHeader() {
        System.out.println("====== 리뷰 등록 ======");
    }

    public static void printMovieList(List<Movie> movies) {
        System.out.println("--- 영화 목록 ---");

        int id = 1;
        for (Movie movie : movies) {
            System.out.println(id + "." + movie.getTitle());
            id++;
        }
    }

    public static void printReviewRegistrationSuccess() {
        System.out.println("✅ 리뷰가 등록되었습니다!");
    }

    public static void printReviews(Service service) {
        for (Movie movie : service.getMovies()) {
            System.out.println("[" + movie.getId() + "] " + movie.getTitle() +
                    " (감독: " + movie.getDirector() +
                    " | 장르: " + movie.getGenre().getDisplayName() + ")");

            double avgRating = service.averageRating(movie.getId());
            System.out.println("    평균 평점: " + avgRating);

            printMovieReviews(movie.getId(), service.getReviews());

            System.out.println();
        }
    }

    private static void printMovieReviews(int movieId, List<Review> reviews) {
        List<Review> movieReviews = reviews.stream()
                .filter(r -> r.getMovieId() == movieId)
                .toList();

        for (Review review : movieReviews) {
            System.out.println("   - [⭐️" + review.getRating() + "] " + review.getContent());
        }
    }
}
