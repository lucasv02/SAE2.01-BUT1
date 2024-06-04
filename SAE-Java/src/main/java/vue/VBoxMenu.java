package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import modele.Constantes;
import modele.Historique;
import modele.Position;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VBoxMenu extends VBox implements Constantes {

    private static GridPaneParcours parcours;

    private static GridPaneScenario scenario;

    private static GridPaneInformations informations;

    private static TableViewHistorique historique;

    public VBoxMenu() {

        Label lbscenario = new Label("Scénario");
        this.getChildren().add(lbscenario);
        scenario = new GridPaneScenario();
        this.getChildren().add(scenario);


        VBoxMenu.setMargin(scenario, new Insets(30));

        Label lbinformations = new Label("Informations");
        this.getChildren().add(lbinformations);
        informations = new GridPaneInformations();
        this.getChildren().add(informations);

        VBoxMenu.setMargin(informations, new Insets(30));

        Label lbparcours = new Label("Parcours");
        this.getChildren().add(lbparcours);
        parcours = new GridPaneParcours();
        this.getChildren().add(parcours);

        VBoxMenu.setMargin(parcours, new Insets(30));


        Label lbhistorique = new Label("Historique");
        this.getChildren().add(lbhistorique);
        historique = new TableViewHistorique();
        this.getChildren().add(historique);

        VBoxMenu.setMargin(historique, new Insets(30));

    }

    public String getScenario() {
        return scenario.getScenario();
    }

    public void setLabelNbTemple (int parValeur) {
        informations.setLbTemple(String.valueOf(parValeur));
    }

    public void setLabelNBPas (int parValeur) {
        informations.setLbPas(String.valueOf(parValeur));
    }

    public void setLabelAvancement (int parValeur, int parTotal) {
        informations.setLbAvancement(String.valueOf(parValeur) + " / " + String.valueOf(parTotal));
    }
}
