package com.yeahhjj.movie_review.service;

import com.yeahhjj.movie_review.domain.Genre;
import com.yeahhjj.movie_review.domain.Movie;
import com.yeahhjj.movie_review.util.MovieParser;
import com.yeahhjj.movie_review.util.MovieValidator;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private final List<Movie> movies = new ArrayList<>();

    public void registerMovie(String title, String genreId, String director) {
        MovieValidator.validateTitle(title, movies);
        int genre = MovieValidator.validateGenreId(genreId);
        MovieParser.isBlankDirector(director);

        movies.add(new Movie(title, Genre.getGenre(genre), director));
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
