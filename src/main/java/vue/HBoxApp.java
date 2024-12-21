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

/**
 * Classe HBoxApp
 * Cette classe permet de stocker graphiquement les éléments de l'application.
 * Elle hérite de la classe HBox et integre plusieurs éléments graphiques comme la carte et le menu.
 */
public class HBoxApp extends HBox implements Constantes {

    // Déclaration des attributs de la classe HBoxApp
    public static Controleur getControleur;
    private static VBoxCarte carte;
    private static VBoxMenu menu;
    private static Controleur controleur;

    /**
     * Constructeur de la classe HBoxApp
     * Il initialise les éléments graphiques de l'application ainsi que le controleur.
     */
    public HBoxApp() {
        carte = new VBoxCarte();
        menu = new VBoxMenu();
        controleur = new Controleur();
        this.getChildren().addAll(carte, menu);

        HBoxApp.setMargin(menu, new Insets(30));
    }

    /**
     * Méthode getCarte qui permet de récupérer la carte.
     * @args : aucun
     * @return : VBoxCarte : carte
     */
    public static VBoxCarte getCarte() {
        return carte;
    }

    /**
     * Méthode getMenu qui permet de récupérer le menu.
     * @args : aucun
     * @return : VBoxMenu : menu
     */
    public static VBoxMenu getMenu() {
        return menu;
    }

    /**
     * Méthode getControleur qui permet de récupérer le controleur.
     * @args : aucun
     * @return : Controleur : controleur
     */
    public static Controleur getControleur() {
        return controleur;
    }

}
