package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    private HomeController homeController;

    @BeforeEach
    void setUp() {
        if (!Platform.isFxApplicationThread()) {
            try {
                Platform.startup(() -> {});
            } catch (IllegalStateException e) {
                // Falls JavaFX schon läuft, ignoriere den Fehler
            }
        }

        homeController = new HomeController();
        List<Movie> testMovies = Arrays.asList(
                new Movie("Interstellar", "SCIENCE FICTION", Arrays.asList("SCIENCE_FICTION")),
                new Movie("Joker", "DRAMA", Arrays.asList("DRAMA")),
                new Movie("Inception", "SCIENCE FICTION", Arrays.asList("SCIENCE_FICTION")),
                new Movie("Gladiator", "ACTION", Arrays.asList("ACTION"))
        );
        homeController.setMoviesForTesting(testMovies);

        // Initialisierung der FXML-Elemente innerhalb von Platform.runLater
        Platform.runLater(() -> {
            homeController.setSearchField(new TextField());
            homeController.setGenreComboBox(new JFXComboBox<>());
            homeController.setSortBtn(new JFXButton());
        });
    }


    @Test
    void testSortingAscending() {
        Platform.runLater(() -> {
            homeController.sortMovies();
            ObservableList<Movie> sortedMovies = homeController.getObservableMovies();
            assertTrue(sortedMovies.get(0).getTitle().compareToIgnoreCase(sortedMovies.get(1).getTitle()) <= 0);
        });
    }

    @Test
    void testSortingDescending() {
        Platform.runLater(() -> {
            homeController.sortMovies();
            homeController.sortMovies();
            ObservableList<Movie> sortedMovies = homeController.getObservableMovies();
            assertTrue(sortedMovies.get(0).getTitle().compareToIgnoreCase(sortedMovies.get(1).getTitle()) >= 0);
        });
    }

    @Test
    void testFilterByGenre() {
        Platform.runLater(() -> {
            homeController.genreComboBox.setValue("ACTION");
            homeController.filterMovies();
            for (Movie movie : homeController.getObservableMovies()) {
                assertTrue(movie.getGenres().contains("ACTION"));
            }
        });
    }

    @Test
    void testFilterBySearchQuery() {
        Platform.runLater(() -> {
            homeController.searchField.setText("Joker");
            homeController.filterMovies();
            assertEquals(1, homeController.getObservableMovies().size());
            assertEquals("Joker", homeController.getObservableMovies().get(0).getTitle());
        });
    }

    @Test
    void testFilterByEmptySearchQuery() {
        Platform.runLater(() -> {
            homeController.searchField.setText("");
            homeController.genreComboBox.setValue("All");
            homeController.filterMovies();
            assertEquals(4, homeController.getObservableMovies().size());
        });
    }

    @Test
    void testFilterByNonExistentMovie() {
        Platform.runLater(() -> {
            homeController.searchField.setText("NonExistentMovie");
            homeController.filterMovies();
            assertEquals(0, homeController.getObservableMovies().size());
        });
    }
}