package vue;


import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import modele.Constantes;

/**
 * Classe VBoxMenu
 * Cette classe permet de stocker graphiquement les éléments du menu.
 * Elle hérite de la classe VBox et integre plusieurs éléments graphiques comme le scénario, les informations, le parcours et l'historique.

 */
public class VBoxMenu extends VBox implements Constantes {

    // Déclaration des attributs de la classe VBoxMenu
    private static GridPaneParcours parcours;
    private static GridPaneScenario scenario;
    private static GridPaneInformations informations;
    private static TableViewHistorique historique;

    /**
     * Constructeur de la classe VBoxMenu
     * Il initialise les éléments graphiques du menu.
     */
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

    /**
     * Méthode getScenario qui permet de récupérer le scénario sélectionné.
     * @args : aucun
     * @return : String : scénario sélectionné
     */
    public String getScenario() {
        return scenario.getScenario();
    }

    /**
     * Méthode setLabelNbTemple qui permet de modifier le label du nombre de temple.
     * @args : int parValeur
     * @return : void
     */
    public void setLabelNbTemple (int parValeur) {
        informations.setLbTemple(String.valueOf(parValeur));
    }

    /**
     * Méthode setLabelNBPas qui permet de modifier le label du nombre de pas.
     * @args : int parValeur
     * @return : void
     */
    public void setLabelNBPas (int parValeur) {
        informations.setLbPas(String.valueOf(parValeur));
    }

    /**
     * Méthode setLabelAvancement qui permet de modifier le label du taux d'avancement.
     * @args : int parValeur, int parTotal
     * @return : void
     */
    public void setLabelAvancement (int parValeur, int parTotal) {
        informations.setLbAvancement(String.valueOf(parValeur) + " / " + String.valueOf(parTotal));
    }
}
