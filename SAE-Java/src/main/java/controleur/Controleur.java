package controleur;

// Import des classes du package modele, vue ainsi que de la classe EventHandler
import javafx.event.Event;
import javafx.event.EventHandler;
import modele.*;
import vue.HBoxApp;
import vue.VBoxCarte;
import vue.VBoxMenu;

// Classe Controleur qui implémente l'interface EventHandler
public class Controleur implements EventHandler {

    // Déclaration des attributs de la classe Controleur
    private Scenario scenario;
    private VBoxCarte carte = HBoxApp.getCarte();
    private VBoxMenu menu = HBoxApp.getMenu();
    private Heuristique heuristique;
    private static TriSelection triSelection;
    private Boolean tri = false;

    public void handle(Event event) {
    }

    /**
     * Méthode initialisation qui permet d'initialiser le scénario et de l'afficher graphiquement.
     * @args : aucun
     * @return : void
     */
    public void initialisation() {
        String intitulee = menu.getScenario();
        scenario = new Scenario(intitulee);

        carte.initialisationMap(scenario.getListeTemple(), scenario.getApprenti());
        menu.setLabelNbTemple(scenario.getListeTemple().size());
        heuristique = new Heuristique(scenario);

    }

    /**
     * Méthode reset qui permet de réinitialiser le scénario et de l'afficher graphiquement.
     * Elle vérifie bien qu'aucun déplacement est en cours avant de reiiitialiser le scénario.
     * @args : aucun
     * @return : void
     */
    public void reset() {
        if (!carte.getDeplacement()) {

            carte.reset(scenario.getListeTemple(), scenario.getApprenti());
            menu.setLabelNbTemple(0);
            menu.setLabelNBPas(0);
            menu.setLabelAvancement(0, 0);
            scenario.getApprenti().getPositionApprenti().SetNombreDePas(0);
            carte.setCristal(false);
            heuristique = new Heuristique(scenario);
        }
    }

    /**
     * Méthode deplacement qui permet de déplacer l'apprenti sur la carte.
     * Elle vérifie bien qu'aucun déplacement est en cours avant de déplacer l'apprenti.
     * @args : Position parPosition, int parMode
     * @return : void
     */ 
    public void deplacement (Position parPosition, int parMode) {
        setMode(parMode);
        carte.deplacementApprenti(parPosition, HBoxApp.getControleur().getScenario());
    }

    /**
     * Méthode qui permet de récupérer l'apprenti à partir de la classe Scenario qui est dans le modèle.
     * @args : aucun
     * @return : ApprentiOrdonnateur
     */
    public ApprentiOrdonnateur getApprenti() {
        return scenario.getApprenti();
    }

    /**
     * Méthode getScenario qui permet de récupérer le scénario a partir de la classe Scenario qui est dans le modèle.
     * @args : aucun
     * @return
     */
    public Scenario getScenario() {
        return scenario;
    }

    /**
     * Méthode prendreCristal qui permet de prendre un cristal sur la carte et dans scénario.
     * Elle permet à notre Apprenti de prendre un cristal sur le temple  et de le mettre dans sa main.
     * @args : aucun
     * @return : void
     */
    public void prendreCristal () {
        Position position = getApprenti().getPositionApprenti();
        Integer couleur = scenario.getTemple(position).getChCristal();
        scenario.getApprenti().setCristalInHand(couleur);
        scenario.getTemple(position).setChCristal(-1);
        carte.setCristal(true);
    }

    /**
     * Méthode echangeCristal qui permet d'échnger le cristal sur la carte et dans scénario.
     * Elle permet à notre Apprenti d'échanger le cristal qu'il a en main avec celui qui est sur le temple.
     * @args : aucun
     * @return : void
     */
    public void echangeCristal() {
        Position position = getApprenti().getPositionApprenti();
        Integer couleur = getApprenti().getCristalInHand();
        Integer couleurtemple = scenario.getTemple(position).getChCristal();
        scenario.getTemple(position).setChCristal(couleur);
        getApprenti().setCristalInHand(couleurtemple);
    }

    /**
     * Méthode heuristique qui permet de déplacer l'apprenti sur la carte en utilisant l'heuristique.
     * Elle permet à notre Apprenti de se déplacer sur la carte en utilisant l'heuristique.
     * @args : aucun
     * @return : void
     */
    public void heuristique() {
        if (carte.getInitialisation()) {
            heuristique.deplacement(scenario);
        }
    }

    /**
     * Méthode tri qui permet de trier les temples sur la carte en utilisant le tri par sélection.
     * Elle permet de trier les temples sur la carte en utilisant le tri par sélection.
     * @args : aucun
     * @return : void
     */
    public void tri() {
        if (carte.getInitialisation()) {
            if (!tri) {
                triSelection = new TriSelection(scenario);
                triSelection.updatePosition(scenario);
                deplacement(triSelection.getTempleD().getChPosition(), 2);
                tri = true;
            }
            else {
                triSelection.deplacement(scenario);
            }
        }

    }

    /**
     * Méthode getDeplacement qui permet de savoir si un déplacement est en cours.
     * Elle permet de récupérer le déplacement de l'apprenti.
     * @args : aucun
     * @return : Boolean
     */
    public Boolean getDeplacement () {
        return carte.getDeplacement();
    }

    /**
     * Méthode setMode qui permet de définir le mode de déplacement de l'apprenti.
     * Elle permet de définir le mode de déplacement de l'apprenti entre le mode manuel, tri par sélection et heuristique.
     * @args : int parMode
     * @return : void
     */
    public void setMode(int parMode) {
        carte.setMode(parMode);
    }





}

