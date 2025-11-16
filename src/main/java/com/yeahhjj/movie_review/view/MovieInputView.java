package com.yeahhjj.movie_review.view;

import java.util.Scanner;

public class MovieInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputTitle() {
        System.out.println("> 영화 제목을 입력하세요: ");
        return scanner.nextLine();
    }

    public static String inputDirector() {
        System.out.println("> 감독을 입력하세요: ");
        return scanner.nextLine();
    }

    public static String inputGenreId() {
        MovieOutputView.printGenreList();
        System.out.println("> 장르 번호를 입력하세요: ");
        return scanner.nextLine();
    }

}
