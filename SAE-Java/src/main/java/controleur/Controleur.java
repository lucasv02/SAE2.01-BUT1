package controleur;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import modele.ApprentiOrdonnateur;
import modele.Scenario;
import vue.HBoxApp;
import vue.VBoxCarte;
import vue.VBoxMenu;


public class Controleur implements EventHandler {

    private Scenario scenario;

    public void handle(Event event) {
        VBoxMenu menu = HBoxApp.getMenu();
        VBoxCarte carte = HBoxApp.getCarte();
    }

    public void initialisation() {
        System.out.println("Initialisation de la carte");
        VBoxMenu menu = HBoxApp.getMenu();
        VBoxCarte carte = HBoxApp.getCarte();
        String intitulee = menu.getScenario();
        System.out.println(intitulee);
        scenario = new Scenario(intitulee);
        carte.initialisationMap(scenario.getListeTemple());
    }

    public void reset() {
        System.out.println("Reset de la carte");
        VBoxMenu menu = HBoxApp.getMenu();
        VBoxCarte carte = HBoxApp.getCarte();
        carte.resetApprenti(scenario.getApprenti().getPositionApprenti());

    }

}

