package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe GridPaneScenario
 * Cette classe permet de stocker graphiquement les informations sur le choix du scénario.
 */
public class GridPaneScenario extends GridPane {

    // Déclaration des attributs de la classe GridPaneScenario
    ComboBox<String> fichier = new ComboBox<>();

    /**
     * Constructeur de la classe GridPaneScenario
     * Il initialise la ComboBox pour le choix du scénario.
     */
    public GridPaneScenario() {
        int ligne = 0;

        // Initialisation de la ComboBox lectureFichiers
        File dossier = new File("data");
        File [] listefichier = dossier.listFiles();
        List<String> nomfichier = new ArrayList<>();
        if (listefichier != null) {
            for (File file : listefichier) {
                if (file.isFile()) {
                    nomfichier.add(file.getName());
                }
            }
            Collections.sort(nomfichier);
            fichier.getItems().addAll(nomfichier);

        }

        // Première ligne du GridPane
        Label lbIntituleeComBox = new Label("Choix du scénario : ");
        this.add(lbIntituleeComBox, 0, ligne, 2, 1);
        this.add(fichier, 2, ligne++, 3,1);

        // Deuxième ligne du GridPane
        Button btValider = new Button("Valider");
        Button btAnnuler = new Button("Annuler");
        Button btReset = new Button("Reset");
        this.add(btAnnuler,0 , ligne);
        this.add(btValider, 1, ligne);
        this.add(btReset, 2, ligne);

        // Gestion du clic sur le bouton btValider
        btValider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HBoxApp.getControleur().initialisation();
            }
        });

        // Gestion du clic sur le bouton btAnnuler
        btAnnuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fichier.setValue("");
            }
        });

        // Gestion du clic sur le bouton btReset
        btReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HBoxApp.getControleur().reset();
            }
        });


    }

    /**
     * Méthode getScenario qui permet de retourner le scénario choisi.
     * @args : aucun
     * @return : String
     */
    public String getScenario() {
        return fichier.getValue();
    }



}
