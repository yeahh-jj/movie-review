package com.yeahhjj.movie_review.domain;

import java.util.Arrays;

public enum Genre {
    ACTION(1, "액션"),
    COMEDY(2, "코미디"),
    DRAMA(3, "드라마"),
    HORROR(4, "공포"),
    ROMANCE(5, "로맨스"),
    SF(6, "SF");

    private final int id;
    private final String displayName;

    Genre(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int getGenreId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Genre getGenre(int id) {
        return Arrays.stream(values())
                .filter(g -> g.getGenreId() == id)
                .findFirst()
                .orElse(null);
    }

}
