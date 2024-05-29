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

    private ApprentiOrdonnateur apprenti;

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
        apprenti = new ApprentiOrdonnateur();
        carte.initialisationMap(scenario.getListeTemple());
        menu.setLabelNbTemple(scenario.getListeTemple().size());
    }

    public void reset() {
        System.out.println("Reset de la carte");
        VBoxMenu menu = HBoxApp.getMenu();
        VBoxCarte carte = HBoxApp.getCarte();
        carte.reset(scenario.getListeTemple(), apprenti);
        menu.setLabelNbTemple(0);


    }



}

