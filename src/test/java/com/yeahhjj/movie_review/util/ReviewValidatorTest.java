package com.yeahhjj.movie_review.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ReviewValidatorTest {
    @Test
    void 범위를_벗어난_숫자를_입력할_경우_예외가_발생한다() {
        assertThatThrownBy(() -> ReviewValidator.validateRating(6.5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 평점은 0.0~5.0 범위여야 합니다.");
    }

    @Test
    void 평점을_0_5_단위의_입력이_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> ReviewValidator.validateRating(2.1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 평점은 0.5 단위로 입력해야 합니다.");
    }
}
