module at.ac.fhcampuswien.fhmdb {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.jfoenix;
    requires javafx.graphics;

    opens at.ac.fhcampuswien.fhmdb to javafx.fxml;
    exports at.ac.fhcampuswien.fhmdb;
}