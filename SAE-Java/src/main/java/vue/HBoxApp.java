package vue;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Constantes;

public class HBoxApp extends HBox implements Constantes {

    private VBoxCarte carte;

    private VBoxMenu menu;

    public HBoxApp() {

        carte = new VBoxCarte();
        menu = new VBoxMenu();
        this.getChildren().addAll(carte, menu);

    }

}
