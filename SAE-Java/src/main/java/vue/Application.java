package vue;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.Constantes;

import java.util.Map;

public class Application extends javafx.application.Application implements Constantes {

    public void start(Stage stage){
        // VBoxRoot root = new VBoxRoot();
        // HBoxRoot root1 = new HBoxRoot();
        HBoxApp root = new HBoxApp();
        Scene scene = new Scene(root, TAILLE_HAUTEUR, TAILLE_LARGEUR);
        stage.setScene(scene);
        stage.setTitle("L'Apprenti Ordonnateur");
        stage.show();
    }

    public static void main(String [] args) {
        javafx.application.Application.launch(args);
    }
}
