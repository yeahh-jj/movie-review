package com.yeahhjj.movie_review;

import com.yeahhjj.movie_review.controller.Controller;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieReviewApplication {

    public static void main(String[] args) {
        new Controller().run();
    }

}
