package com.yeahhjj.movie_review.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ReviewParserTest {
    @Test
    void 영화_ID_문자를_숫자로_제대로_파싱한다() {
        assertThat(ReviewParser.parseMovieId("1")).isInstanceOf(Integer.class);
    }

    @Test
    void 리뷰를_작성하려는_영화_ID를_공백으로_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> ReviewParser.parseMovieId(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 영화 ID를 입력해야 합니다.");
    }

    @Test
    void 평점을_공백으로_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> ReviewParser.checkRating(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 평점을 입력해야 합니다.");
    }

    @Test
    void 평점을_숫자_외_입력_시_예외가_발생한다() {
        assertThatThrownBy(() -> ReviewParser.checkRating("aaaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 평점은 숫자 입력만 가능합니다.");
    }

    @Test
    void 감상평을_공백으로_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> ReviewParser.isBlankContent(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 감상평을 입력해야 합니다.");
    }
}
