package vue;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Map;

public class Application extends javafx.application.Application {

    public void start(Stage stage){
        VBoxRoot root = new VBoxRoot();
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.setTitle("Jeu");
        stage.show();
    }

    public static void main(String [] args) {
        javafx.application.Application.launch(args);
    }
}
