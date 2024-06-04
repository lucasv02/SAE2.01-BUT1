package vue;

import controleur.Controleur;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Constantes;
import modele.Position;
import modele.Scenario;

public class HBoxApp extends HBox implements Constantes {

    public static Controleur getControleur;

    private static VBoxCarte carte;

    private static VBoxMenu menu;

    private static Controleur controleur;

    public HBoxApp() {
        carte = new VBoxCarte();
        menu = new VBoxMenu();
        controleur = new Controleur();
        this.getChildren().addAll(carte, menu);

        HBoxApp.setMargin(menu, new Insets(30));
    }

    public static VBoxCarte getCarte() {
        return carte;
    }

    public static VBoxMenu getMenu() {
        return menu;
    }

    public static Controleur getControleur() {
        return controleur;
    }

}
