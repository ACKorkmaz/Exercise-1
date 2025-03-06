package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    //neu
    private List<String> genres;  // Genre-Attribut hinzufügen

    public Movie(String title, String description, List<String> genres) {
        this.title = title;
        this.description = description;
        //neu
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    //neu
    public List<String> getGenres() {  // Getter für Genres hinzufügen
        return genres;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();

        // Neu
        movies.add(new Movie("Das Schloss im Himmel",
                "Ein Waisenjunge und ein geheimnisvolles Mädchen suchen nach einer legendären schwebenden Stadt.",
                List.of("ANIMATION", "ABENTEUER", "FANTASY")));

        movies.add(new Movie("The Gorge",
                "Ein Liebespaar kämpft sich durch gefährliche Missionen in einer actionreichen Welt.",
                List.of("ACTION", "THRILLER", "ROMANCE")));

        movies.add(new Movie("Terminal",
                "Ein Mann bleibt aufgrund bürokratischer Probleme jahrelang in einem Flughafen gestrandet.",
                List.of("DRAMA", "KOMÖDIE")));

        movies.add(new Movie("Interstellar",
                "Ein Team von Astronauten reist durch ein Wurmloch, um die Menschheit zu retten.",
                List.of("SCIENCE FICTION", "ABENTEUER", "DRAMA")));

        movies.add(new Movie("Inglourious Basterds",
                "Eine Gruppe jüdischer Soldaten plant einen Anschlag auf Nazi-Offiziere im besetzten Frankreich.",
                List.of("KRIEG", "ACTION", "THRILLER")));

        movies.add(new Movie("Ziemlich beste Freunde",
                "Ein reicher, gelähmter Mann findet in seinem frechen Pfleger eine unerwartete Freundschaft.",
                List.of("DRAMA", "KOMÖDIE")));

        movies.add(new Movie("Mad Max: Fury Road",
                "In einer dystopischen Zukunft kämpft ein Überlebender um seine Freiheit und gegen Tyrannen.",
                List.of("ACTION", "SCIENCE FICTION")));

        movies.add(new Movie("Parasite",
                "Eine arme Familie erschleicht sich Zugang zu einer reichen Familie mit unerwarteten Folgen.",
                List.of("THRILLER", "DRAMA", "SATIRE")));

        movies.add(new Movie("Der Herr der Ringe: Die Gefährten",
                "Ein Hobbit begibt sich auf eine epische Reise, um einen mächtigen Ring zu zerstören.",
                List.of("FANTASY", "ABENTEUER")));

        movies.add(new Movie("The Dark Knight",
                "Ein maskierter Held stellt sich dem psychotischen Joker in einem Kampf um Gotham City.",
                List.of("ACTION", "THRILLER", "CRIME")));

        movies.add(new Movie("Die Verurteilten",
                "Ein unschuldig Verurteilter baut eine lebenslange Freundschaft in einem brutalen Gefängnis auf.",
                List.of("DRAMA", "KRIMI")));

        movies.add(new Movie("Pulp Fiction",
                "Mehrere verwobene Geschichten aus der Unterwelt von Los Angeles voller Gewalt und schwarzem Humor.",
                List.of("KRIMI", "THRILLER", "KOMÖDIE")));

        movies.add(new Movie("Your Name.",
                "Zwei Jugendliche, die sich nie getroffen haben, tauschen auf magische Weise ihre Körper.",
                List.of("ANIMATION", "ROMANCE", "FANTASY")));

        movies.add(new Movie("Shutter Island",
                "Ein Ermittler untersucht das mysteriöse Verschwinden einer Patientin aus einer psychiatrischen Anstalt.",
                List.of("THRILLER", "MYSTERY", "DRAMA")));

        movies.add(new Movie("Joker",
                "Die tragische Verwandlung eines Außenseiters in den ikonischen Clownprinzen des Verbrechens.",
                List.of("DRAMA", "THRILLER", "PSYCHOLOGISCH")));

        return movies;
    }
}