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
                new Movie("Interstellar", "A space epic where astronauts travel through a wormhole to find a new home for humanity.", Arrays.asList("SCIENCE FICTION", "DRAMA")),
                new Movie("Joker", "A troubled comedian spirals into madness and becomes the infamous villain, Joker, in this psychological thriller.", Arrays.asList("DRAMA", "THRILLER")),
                new Movie("Inception", "A skilled thief enters people's dreams to steal secrets but faces a complex mission that blurs reality and dream.", Arrays.asList("SCIENCE FICTION", "ACTION")),
                new Movie("Gladiator", "A betrayed Roman general seeks revenge against the corrupt emperor who murdered his family.", Arrays.asList("ACTION", "HISTORY")),
                new Movie("The Dark Knight", "Batman faces the Joker, a criminal mastermind who seeks to create chaos in Gotham City.", Arrays.asList("ACTION", "THRILLER")),
                new Movie("Titanic", "A romance set aboard the ill-fated R.M.S. Titanic as a young couple falls in love amidst disaster.", Arrays.asList("ROMANCE", "DRAMA")),
                new Movie("The Matrix", "A hacker discovers that the reality he lives in is a simulation controlled by machines.", Arrays.asList("SCIENCE FICTION", "ACTION")),
                new Movie("Forrest Gump", "The extraordinary life of a simple man who inadvertently influences key events in U.S. history.", Arrays.asList("DRAMA", "ROMANCE")),
                new Movie("The Godfather", "The story of a powerful Mafia family, focusing on the rise of Michael Corleone.", Arrays.asList("CRIME", "DRAMA")),
                new Movie("Pulp Fiction", "Interwoven stories of crime and redemption in the underworld of Los Angeles.", Arrays.asList("CRIME", "THRILLER")),
                new Movie("The Shawshank Redemption", "A man wrongly imprisoned for murder forms a lifelong friendship with a fellow inmate.", Arrays.asList("DRAMA", "CRIME")),
                new Movie("Fight Club", "An insomniac office worker forms an underground fight club that evolves into something much darker.", Arrays.asList("DRAMA", "THRILLER")),
                new Movie("The Lion King", "A young lion prince overcomes adversity to reclaim his rightful place as king of the savanna.", Arrays.asList("ANIMATION", "FAMILY")),
                new Movie("The Avengers", "A group of superheroes assemble to stop an alien invasion and save the world from destruction.", Arrays.asList("ACTION", "SCIENCE FICTION")),
                new Movie("Avatar", "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the indigenous Na'vi people.", Arrays.asList("SCIENCE FICTION", "ACTION")),
                new Movie("The Silence of the Lambs", "A young FBI agent seeks the help of an imprisoned cannibalistic serial killer to catch another serial killer on the loose.", Arrays.asList("THRILLER", "CRIME")),
                new Movie("Jurassic Park", "A theme park featuring genetically resurrected dinosaurs goes awry when the creatures break free from their enclosures.", Arrays.asList("SCIENCE FICTION", "ADVENTURE")),
                new Movie("Schindler's List", "The true story of a German businessman who saves the lives of more than a thousand Jewish refugees during the Holocaust.", Arrays.asList("HISTORY", "DRAMA")),
                new Movie("The Wizard of Oz", "A young girl from Kansas is swept away by a tornado to the magical land of Oz, where she meets strange and wonderful characters on a quest to return home.", Arrays.asList("FAMILY", "FANTASY")),
                new Movie("Star Wars: A New Hope", "A young farm boy becomes involved in the struggle between good and evil, joining a group of rebels to defeat the Empire.", Arrays.asList("SCIENCE FICTION", "ACTION")),
                new Movie("The Shining", "A man and his family become isolated in a remote hotel, where the father slowly descends into madness under the influence of supernatural forces.", Arrays.asList("HORROR", "THRILLER")),
                new Movie("The Grand Budapest Hotel", "A quirky and visually stunning comedy about the misadventures of a hotel concierge and his protégé, set in the fictional Eastern European country of Zubrowka.", Arrays.asList("COMEDY", "DRAMA")),
                new Movie("The Social Network", "The story of the creation of Facebook, focusing on the complex relationship between its founders and the legal battles that ensued.", Arrays.asList("DRAMA", "BIOGRAPHY")),
                new Movie("Mad Max: Fury Road", "In a post-apocalyptic world, a drifter teams up with a rebel warrior to escape a warlord and his army in a high-octane road battle.", Arrays.asList("ACTION", "SCIENCE FICTION")),
                new Movie("La La Land", "A jazz musician and an aspiring actress fall in love but struggle to reconcile their dreams with their relationship.", Arrays.asList("MUSICAL", "ROMANCE")),
                new Movie("The Pursuit of Happyness", "A struggling salesman and his young son face many hardships as they pursue a better life, driven by hope and determination.", Arrays.asList("DRAMA", "BIOGRAPHY")),
                new Movie("Spider-Man: Into the Spider-Verse", "A teenager from Brooklyn is thrust into an alternate universe, where multiple Spider-People from different dimensions must team up to save the multiverse.", Arrays.asList("ANIMATION", "ACTION")),
                new Movie("The Hunger Games", "In a dystopian future, a young woman volunteers to take her sister's place in a televised fight to the death, where only one can survive.", Arrays.asList("SCIENCE FICTION", "ACTION")),
                new Movie("The Truman Show", "A man discovers that his entire life has been a reality television show, and he begins to rebel against the scripted world around him.", Arrays.asList("DRAMA", "SCIENCE FICTION")),
                new Movie("Django Unchained", "A freed slave teams up with a bounty hunter to rescue his wife from a ruthless plantation owner in this violent and stylish western.", Arrays.asList("WESTERN", "DRAMA")),
                new Movie("The Incredibles", "A family of superheroes struggles to balance their lives as normal citizens with their need to save the world.", Arrays.asList("ANIMATION", "ACTION")),
                new Movie("The Departed", "An undercover cop and a mole in the police force try to identify each other while infiltrating an Irish gang in Boston.", Arrays.asList("CRIME", "THRILLER")),
                new Movie("The Terminator", "A cyborg assassin is sent back in time to kill the mother of a future rebel leader, but a soldier from the future tries to protect her.", Arrays.asList("SCIENCE FICTION", "ACTION"))

        );
    }
}
