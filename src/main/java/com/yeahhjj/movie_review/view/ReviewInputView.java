package com.yeahhjj.movie_review.view;

import com.yeahhjj.movie_review.domain.Movie;
import java.util.List;
import java.util.Scanner;

public class ReviewInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMovieId(List<Movie> movies) {
        ReviewOutputView.printMovieList(movies);
        System.out.println("리뷰를 남길 영화 번호를 입력하세요: ");
        return scanner.nextLine();
    }

    public static String inputRating() {
        System.out.println("평점을 입력하세요: ");
        return scanner.nextLine();
    }

    public static String inputContent() {
        System.out.println("감상평을 입력하세요: ");
        return scanner.nextLine();
    }
}
