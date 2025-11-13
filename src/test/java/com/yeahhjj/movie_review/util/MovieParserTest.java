package com.yeahhjj.movie_review.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MovieParserTest {
    @Test
    void 영화_제목을_공백으로_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> MovieParser.isBlankTitle(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 영화 제목은 비워둘 수 없습니다.");
    }

    @Test
    void 장르ID_입력값을_숫자로_제대로_파싱한다() {
        assertThat(MovieParser.checkGenreId("1")).isInstanceOf(Integer.class);
    }

    @Test
    void 영화_등록_시_장르를_선택하지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> MovieParser.checkGenreId(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 장르 ID를 선택해야 합니다.");
    }

    @Test
    void 장르ID_숫자_외_입력_시_예외가_발생한다() {
        assertThatThrownBy(() -> MovieParser.checkGenreId("ㅁ"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 장르 ID는 숫자만 입력해야 합니다.");
    }

    @Test
    void 영화_감독을_공백으로_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> MovieParser.isBlankDirector(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 영화 감독을 입력해야 합니다.");
    }
}
