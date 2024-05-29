module org.example.saejava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;

    opens org.example.saejava to javafx.fxml;
    exports org.example.saejava;
    exports modele;
    exports vue;
}