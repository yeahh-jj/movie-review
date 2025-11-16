package com.yeahhjj.movie_review.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.yeahhjj.movie_review.domain.Movie;
import com.yeahhjj.movie_review.service.Service;
import org.junit.jupiter.api.Test;

public class ReviewValidatorTest {
    @Test
    void 존재하지_않는_영화ID를_입력할_경우_예외가_발생한다() {
        Service service = new Service();
        service.registerMovie("기생충", "3", "봉준호");
        service.registerMovie("미션임파서블", "1", "브라이언 드 팔마");

        assertThatThrownBy(() -> ReviewValidator.validateMovieId("3", service.getMovies()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 영화ID에_맞는_영화가_도출된다() {
        Service service = new Service();
        service.registerMovie("기생충", "3", "봉준호");
        service.registerMovie("미션임파서블", "1", "브라이언 드 팔마");

        int movieId = ReviewValidator.validateMovieId("2", service.getMovies());

        assertThat(movieId).isEqualTo(2);
    }

    @Test
    void 평점_범위를_벗어난_숫자를_입력할_경우_예외가_발생한다() {
        assertThatThrownBy(() -> ReviewValidator.validateRating("6.5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 평점은 0.0~5.0 범위여야 합니다.");
    }

    @Test
    void 평점을_0_5_단위의_입력이_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> ReviewValidator.validateRating("2.1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 평점은 0.5 단위로 입력해야 합니다.");
    }
}
