package com.yeahhjj.movie_review.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.yeahhjj.movie_review.domain.Genre;
import com.yeahhjj.movie_review.domain.Movie;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MovieValidatorTest {
    @Test
    void 이미_등록된_영화_제목_입력_시_예외가_발생한다() {
        List<Movie> movies = List.of(
                new Movie(1,"기생충", Genre.DRAMA, "봉준호"),
                new Movie(2,"인터스텔라", Genre.SF, "크리스토퍼 놀란"),
                new Movie(3,"미션 임파서블", Genre.ACTION, "브라이언 드 팔마")
        );
        assertThatThrownBy(() -> MovieValidator.validateTitle("기생충", movies))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이미 등록된 영화입니다.");
    }

    @Test
    void 존재하지_않는_장르ID_입력_시_예외가_발생한다() {
        assertThatThrownBy(() -> MovieValidator.validateGenreId("7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 해당 ID의 장르는 존재하지 않습니다.");
    }
}
