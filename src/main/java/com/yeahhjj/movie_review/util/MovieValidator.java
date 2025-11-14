package com.yeahhjj.movie_review.util;

import com.yeahhjj.movie_review.domain.Genre;
import com.yeahhjj.movie_review.domain.Movie;
import java.util.List;

public class MovieValidator {
    public static void validateTitle(String title, List<Movie> movies) {
        MovieParser.isBlankTitle(title);
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                throw new IllegalArgumentException("[ERROR] 이미 등록된 영화입니다.");
            }
        }
    }

    public static int validateGenreId(String genreId) {
        int id = MovieParser.checkGenreId(genreId);
        if (Genre.getGenre(id) == null) {
            throw new IllegalArgumentException("[ERROR] 해당 ID의 장르는 존재하지 않습니다.");
        }
        return id;
    }

}
