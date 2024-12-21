package vue;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Map;

public class Application extends javafx.application.Application {

    /**
     * Méthode start qui permet de lancer l'application.
     * Elle instancie un objet de la classe HBoxApp et crée une scène.
     * @args : Stage stage
     * @return : void
     */
    public void start(Stage stage) {
        HBoxApp root = new HBoxApp();
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.setTitle("Jeu");
        stage.show();
    }

    public static void main(String [] args) {
        javafx.application.Application.launch(args);
    }
}
