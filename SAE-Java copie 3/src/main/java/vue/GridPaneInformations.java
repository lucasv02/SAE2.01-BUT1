package vue;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GridPaneInformations extends GridPane {

    Label lbTemple = new Label("0");

    Label lbPas = new Label("0");

    Label lbAvancement = new Label("0");

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

    public void setLbTemple(String parString) {
        lbTemple.setText(parString);
    }

    public void setLbPas(String parString) {
        lbPas.setText(parString);
    }

    public void setLbAvancement(String parString) {
        lbAvancement.setText(parString);
    }

}
