module com.javafx.game {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.javafx.game to javafx.fxml;
    exports com.javafx.game;
}
