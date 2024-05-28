package vue;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GridPaneParcours extends GridPane {

    public GridPaneParcours() {

        int ligne = 0;

        // Première ligne du GridPane
        Button btHeuristique = new Button("Activer");
        Label lbIntituleParHeur = new Label(" Parcours héuristique");
        this.add(btHeuristique,0, ligne);
        this.add(lbIntituleParHeur, 1, ligne++, 3, 1);


        // Deuxième ligne du GridPane
        Button btTrie = new Button("Activer");
        Label lbIntituleParTrie = new Label(" Trie à bulle");
        this.add(btTrie,0, ligne);
        this.add(lbIntituleParTrie, 1, ligne++, 3, 1);

    }

}
