package controleur;


import javafx.event.Event;
import javafx.event.EventHandler;
import modele.*;
import vue.HBoxApp;
import vue.VBoxCarte;
import vue.VBoxMenu;


public class Controleur implements EventHandler {

    private Scenario scenario;

    private VBoxCarte carte = HBoxApp.getCarte();

    private VBoxMenu menu = HBoxApp.getMenu();

    private Heuristique heuristique;

    private static TriSelection triSelection;

    private Boolean tri = false;

    public void handle(Event event) {

    }

    public void initialisation() {
        String intitulee = menu.getScenario();
        scenario = new Scenario(intitulee);

        carte.initialisationMap(scenario.getListeTemple(), scenario.getApprenti());
        menu.setLabelNbTemple(scenario.getListeTemple().size());
        heuristique = new Heuristique(scenario);

    }

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

    public void deplacement (Position parPosition, int parMode) {
        setMode(parMode);
        carte.deplacementApprenti(parPosition, HBoxApp.getControleur().getScenario());
    }

    public ApprentiOrdonnateur getApprenti() {
        return scenario.getApprenti();
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void prendreCristal () {
        Position position = getApprenti().getPositionApprenti();
        Integer couleur = scenario.getTemple(position).getChCristal();
        scenario.getApprenti().setCristalInHand(couleur);
        scenario.getTemple(position).setChCristal(-1);
        carte.setCristal(true);
    }

    public void echangeCristal() {
        Position position = getApprenti().getPositionApprenti();
        Integer couleur = getApprenti().getCristalInHand();
        Integer couleurtemple = scenario.getTemple(position).getChCristal();
        scenario.getTemple(position).setChCristal(couleur);
        getApprenti().setCristalInHand(couleurtemple);
    }

    public void heuristique() {
        if (carte.getInitialisation()) {
            heuristique.deplacement(scenario);
        }
    }

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


    public Boolean getDeplacement () {
        return carte.getDeplacement();
    }

    public void setMode(int parMode) {
        carte.setMode(parMode);
    }





}

