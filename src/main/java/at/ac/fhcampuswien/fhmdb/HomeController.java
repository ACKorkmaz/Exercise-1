package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView<Movie> movieListView;

    @FXML
    public JFXComboBox<String> genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();
    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();
    //neu
    private boolean sortAscending = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);
        movieListView.setItems(observableMovies);
        movieListView.setCellFactory(movieListView -> new MovieCell());

        //neu
        genreComboBox.getItems().addAll(
                "All", "ACTION", "ADVENTURE", "ANIMATION", "BIOGRAPHY", "COMEDY", "CRIME", "DRAMA", "DOCUMENTARY", "FAMILY", "FANTASY", "HISTORY", "HORROR", "MUSICAL", "MYSTERY", "ROMANCE", "SCIENCE_FICTION", "SPORT", "THRILLER", "WAR", "WESTERN"
        );
        genreComboBox.setValue("All");

        sortBtn.setOnAction(actionEvent -> sortMovies());
        searchBtn.setOnAction(actionEvent -> filterMovies());
    }

    private void sortMovies() {
        if (sortAscending) {
            observableMovies.sort(Comparator.comparing(Movie::getTitle));
            sortBtn.setText("Sortieren(A-Z)");
        } else {
            observableMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
            sortBtn.setText("Sortieren (Z-A)");
        }
        sortAscending = !sortAscending;
    }

    //neu
    private void filterMovies() {
        // Suche Kleinbuchstaben machen
        String query = searchField.getText().toLowerCase();

        // Gerne auswahl
        String selectedGenre = genreComboBox.getValue();

        // filter
        List<Movie> filteredMovies = allMovies.stream()
                // filtert nach query faks falsch -> alle filme
                .filter(movie -> query.isEmpty() || movie.getTitle().toLowerCase().contains(query))
                // Filtert nach genre fals alle -> alle filme
                .filter(movie -> selectedGenre.equals("All") || movie.getGenres().contains(selectedGenre))
                .collect(Collectors.toList());

        // sotiert von a-z oder z-a
        if (sortAscending) {
            filteredMovies.sort(Comparator.comparing(Movie::getTitle)); // Aufsteigend sortieren
        } else {
            filteredMovies.sort(Comparator.comparing(Movie::getTitle).reversed()); // Absteigend sortieren
        }

        // Aktualisierte gefilterte Liste in der ObservableList speichern
        observableMovies.setAll(filteredMovies);
    }

}