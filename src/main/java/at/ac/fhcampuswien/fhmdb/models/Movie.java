package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private final String title;
    private final String description;
    private final List<String> genres;

    public Movie(String title, String description, List<String> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getGenres() {
        return genres;
    }

    public static List<Movie> initializeMovies() {
        return Arrays.asList(
                new Movie("Interstellar", "A sci-fi space epic", Arrays.asList("SCIENCE FICTION", "DRAMA")),
                new Movie("Joker", "A psychological thriller", Arrays.asList("DRAMA", "THRILLER")),
                new Movie("Inception", "A dream within a dream", Arrays.asList("SCIENCE FICTION", "ACTION")),
                new Movie("Gladiator", "A Roman general seeks revenge", Arrays.asList("ACTION", "HISTORY"))
        );
    }
}
