package com.yeahhjj.movie_review.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ServiceTest {
    @Test
    void 각_입력값의_조건을_충족하면_영화가_등록된다() {
        Service service = new Service();

        service.registerMovie("기생충", 3, "봉준호");

        assertThat(service.getMovies()).hasSize(1);
        assertThat(service.getMovies().get(0).getTitle()).isEqualTo("기생충");
        assertThat(service.getMovies().get(0).getDirector()).isEqualTo("봉준호");
        assertThat(service.getMovies().get(0).getGenre().getGenreId()).isEqualTo(3);
    }

    @Test
    void 각_입력값의_조건을_충족하면_리뷰가_등록된다() {
        Service service = new Service();

        service.registerMovie("기생충", 3, "봉준호");
        service.registerReview("1", "5.0", "재밌게 봤습니다!");

        assertThat(service.getReviews()).hasSize(1);
        assertThat(service.getReviews().get(0).getContent()).isEqualTo("재밌게 봤습니다!");
        assertThat(service.getReviews().get(0).getMovieId()).isEqualTo(1);
        assertThat(service.getReviews().get(0).getRating()).isEqualTo(5.0);
    }

    @Test
    void 리뷰_평균_평점을_계산한다() {
        Service service = new Service();

        service.registerMovie("기생충", 3, "봉준호");
        service.registerReview("1", "5.0", "재밌게 봤습니다!");
        service.registerReview("1", "4.5", "Good!");

        assertThat(service.findReviewsByMovieId(1)).hasSize(2);
        assertThat(service.averageRating(1)).isEqualTo(4.75);
    }
}
