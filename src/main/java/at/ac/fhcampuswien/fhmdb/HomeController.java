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
import java.util.ArrayList;
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

    private final List<Movie> allMovies = new ArrayList<>(Movie.initializeMovies());
    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();
    private boolean sortAscending = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);
        movieListView.setItems(observableMovies);
        movieListView.setCellFactory(movieListView -> new MovieCell());

        genreComboBox.getItems().addAll(
                "All", "ACTION", "ADVENTURE", "ANIMATION", "BIOGRAPHY", "COMEDY", "CRIME", "DRAMA",
                "DOCUMENTARY", "FAMILY", "FANTASY", "HISTORY", "HORROR", "MUSICAL", "MYSTERY",
                "ROMANCE", "SCIENCE_FICTION", "SPORT", "THRILLER", "WAR", "WESTERN"
        );
        genreComboBox.setValue("All");

        sortBtn.setOnAction(actionEvent -> sortMovies());
        searchBtn.setOnAction(actionEvent -> filterMovies());
    }

    public void sortMovies() {
        if (sortAscending) {
            observableMovies.sort(Comparator.comparing(Movie::getTitle));
            if (sortBtn != null) sortBtn.setText("Sortieren (Z-A)");
        } else {
            observableMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
            if (sortBtn != null) sortBtn.setText("Sortieren (A-Z)");
        }
        sortAscending = !sortAscending;
    }

    public ObservableList<Movie> getObservableMovies() {
        return observableMovies;
    }

    public void filterMovies() {
        if (searchField == null || genreComboBox == null) {
            return;
        }

        final String query = searchField.getText().toLowerCase();
        final String genreFilter;
        if (genreComboBox.getValue() != null) {
            genreFilter = genreComboBox.getValue();
        } else {
            genreFilter = "All";
        }


        List<Movie> filteredMovies = allMovies.stream()
                .filter(movie -> query.isEmpty() ||
                        movie.getTitle().toLowerCase().contains(query) ||
                        movie.getDescription().toLowerCase().contains(query))
                .filter(movie -> genreFilter.equals("All") || movie.getGenres().contains(genreFilter))
                .collect(Collectors.toList());

        if (sortAscending) {
            filteredMovies.sort(Comparator.comparing(Movie::getTitle));
        } else {
            filteredMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
        }

        observableMovies.setAll(filteredMovies);
    }

    // SETTER für TESTS
    public void setSearchField(TextField searchField) {
        this.searchField = searchField;
    }

    public void setGenreComboBox(JFXComboBox<String> genreComboBox) {
        this.genreComboBox = genreComboBox;
    }

    public void setSortBtn(JFXButton sortBtn) {
        this.sortBtn = sortBtn;
    }

    public void setMoviesForTesting(List<Movie> movies) {
        allMovies.clear();
        allMovies.addAll(movies);
        observableMovies.setAll(movies);
    }
}
