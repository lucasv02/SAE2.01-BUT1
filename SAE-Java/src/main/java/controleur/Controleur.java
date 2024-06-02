package controleur;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import modele.ApprentiOrdonnateur;
import modele.Heuristique;
import modele.Position;
import modele.Scenario;
import modele.TriBasique;
import vue.HBoxApp;
import vue.VBoxCarte;
import vue.VBoxMenu;


public class Controleur implements EventHandler {

    private Scenario scenario;

    private VBoxCarte carte = HBoxApp.getCarte();

    private VBoxMenu menu = HBoxApp.getMenu();

    private Boolean init = false;

    private Boolean deplacement = false;

    public void handle(Event event) {

    }

    public void initialisation() {
        System.out.println("Initialisation de la carte");
        String intitulee = menu.getScenario();
        System.out.println(intitulee);
        scenario = new Scenario(intitulee);
        carte.initialisationMap(scenario.getListeTemple(), scenario.getApprenti());
        menu.setLabelNbTemple(scenario.getListeTemple().size());
        init = true;
    }

    public void reset() {
        System.out.println("Reset de la carte");
        carte.reset(scenario.getListeTemple(), scenario.getApprenti());
        menu.setLabelNbTemple(0);
        menu.setLabelNBPas(0);
        carte.setCristal(false);
        init = false;
    }

    public void deplacement (Position parPosition) {
        carte.deplacementApprenti(parPosition, HBoxApp.getControleur().getScenario());
        deplacement = true;
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
        if (init) {
            Heuristique heuristique = new Heuristique(scenario);
        }
    }

    public void Tri(){
        if (init) {
            TriBasique tri = new TriBasique(scenario);
        }
    }



}

