package vue;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Classe GridPaneInformations
 * Cette classe permet de stocker graphiquement les informations du jeu.
 */
public class GridPaneInformations extends GridPane {

    // Déclaration des attributs de la classe GridPaneInformations
    Label lbTemple = new Label("0");
    Label lbPas = new Label("0");
    Label lbAvancement = new Label("0");

    /**
     * Constructeur de la classe GridPaneInformations
     * Il initialise les labels des informations du jeu.
     */
    public GridPaneInformations() {
        int ligne = 0;

        // Première ligne du GridPane
        Label lbIntituleNbTemple = new Label("Nombre de temple : ");
        this.add(lbIntituleNbTemple, 0, ligne, 3, 1);
        this.add(lbTemple,3, ligne++);

        // Deuxième ligne du GridPane
        Label lbIntituleePas = new Label("Nombre de Pas : ");
        this.add(lbIntituleePas, 0, ligne, 3, 1);
        this.add(lbPas, 3, ligne++);

        // Troisième ligne du GridPane
        Label lbIntituleeAvancement = new Label("Taux d'avancement : ");
        this.add(lbIntituleeAvancement, 0, ligne, 3, 1);
        this.add(lbAvancement, 3, ligne++);

    }

    /**
     * Méthode setLbTemple qui permet de modifier le label du nombre de temple.
     * @args : String parString
     * @return : void
     */
    public void setLbTemple(String parString) {
        lbTemple.setText(parString);
    }

    /**
     * Méthode setLbPas qui permet de modifier le label du nombre de pas.
     * @args : String parString
     * @return : void
     */
    public void setLbPas(String parString) {
        lbPas.setText(parString);
    }

    /**
     * Méthode setLbAvancement qui permet de modifier le label du taux d'avancement.
     * @args : String parString
     * @return : void
     */
    public void setLbAvancement(String parString) {
        lbAvancement.setText(parString);
    }

}
