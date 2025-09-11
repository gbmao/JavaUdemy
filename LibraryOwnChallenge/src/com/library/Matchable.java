package com.library;

public interface Matchable {
    String byName();

    String byAuthor();

    Integer byPages();

    Genre byGenre();

     enum Genre {
        ROMANCE, DIDACTIC, POETRY, DEFAULT;

         static Genre fromString(String genre) {
            return switch (genre.toUpperCase()) {
                case "ROMANCE" -> Genre.ROMANCE;
                case "DIDACTIC" -> Genre.DIDACTIC;
                case "POETRY" -> Genre.POETRY;
                default -> Genre.DEFAULT;
            };
        }
    }

}
