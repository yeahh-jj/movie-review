package com.yeahhjj.movie_review.view;

import java.util.Scanner;

public class MenuInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMenuNumber() {
        System.out.println("> 번호를 입력하세요: ");
        return scanner.nextLine();
    }
}
