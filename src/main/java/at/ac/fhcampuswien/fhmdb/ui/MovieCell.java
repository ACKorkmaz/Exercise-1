package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MovieCell extends ListCell<Movie> {
    private final Label title = new Label();
    private final Label detail = new Label();
    private final VBox layout = new VBox(title, detail);

    @Override
    protected void updateItem(Movie movie, boolean empty) {
        super.updateItem(movie, empty);

        if (empty || movie == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (!this.getStyleClass().contains("movie-cell")) {
                this.getStyleClass().add("movie-cell");
            }

            title.setText(movie.getTitle());
            if (movie.getDescription() != null) {
                detail.setText(movie.getDescription());
            } else {
                detail.setText("No description available");
            }


            // Farbgebung
            title.getStyleClass().add("text-yellow");
            detail.getStyleClass().add("text-white");
            layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));

            // Layout-Anpassungen
            title.setStyle("-fx-font-size: 20px;");

            double maxWidth;
            if (this.getScene() != null && this.getScene().getWidth() > 30) {
                maxWidth = this.getScene().getWidth() - 30;
            } else {
                maxWidth = 300;
            }
            detail.setMaxWidth(maxWidth);
            detail.setWrapText(true);
            layout.setPadding(new Insets(10));
            layout.setSpacing(10);
            layout.setAlignment(javafx.geometry.Pos.CENTER_LEFT);

            setGraphic(layout);
        }
    }
}
