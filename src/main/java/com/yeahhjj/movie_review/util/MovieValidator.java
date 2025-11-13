package com.yeahhjj.movie_review.util;

import com.yeahhjj.movie_review.domain.Genre;

public class MovieValidator {

    public static void validateGenreId(String genreId) {
        int id = MovieParser.checkGenreId(genreId);
        if(Genre.getGenre(id) == null) {
            throw new IllegalArgumentException("[ERROR] 해당 ID의 장르는 존재하지 않습니다.");
        }
    }

}
