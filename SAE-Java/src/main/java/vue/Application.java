package vue;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Map;

public class Application extends javafx.application.Application {

    public void start(Stage stage){
        File css= new File("css"+ File.separator + "file.css");


        HBoxApp root = new HBoxApp();
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.setTitle("Jeu");
        scene.getStylesheets().add(css.toURI().toString());
        stage.show();
    }

    public static void main(String [] args) {
        javafx.application.Application.launch(args);
    }
}
