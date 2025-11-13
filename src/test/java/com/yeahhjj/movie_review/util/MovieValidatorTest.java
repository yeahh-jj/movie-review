package com.yeahhjj.movie_review.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MovieValidatorTest {
    @Test
    void 존재하지_않는_장르ID_입력_시_예외가_발생한다() {
        assertThatThrownBy(() -> MovieValidator.validateGenreId("7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 해당 ID의 장르는 존재하지 않습니다.");
    }
}
