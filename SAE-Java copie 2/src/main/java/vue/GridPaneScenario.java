package vue;

import controleur.Controleur;
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

public class GridPaneScenario extends GridPane {

    ComboBox<String> fichier = new ComboBox<>();

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
        this.add(fichier, 2, ligne++, 2,1);

        // Deuxième ligne du GridPane
        Button btValider = new Button("Valider");
        Button btAnnuler = new Button("Annuler");
        Button btReset = new Button("Reset");
        this.add(btReset, 1, ligne);
        this.add(btAnnuler,0 , ligne);
        this.add(btValider, 2, ligne);

        btValider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HBoxApp.getControleur().initialisation();
            }
        });

        btAnnuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fichier.setValue("");
            }
        });


    }

    public String getScenario() {
        return fichier.getValue();
    }




}
