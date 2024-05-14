package controleur;


import javafx.event.Event;
import javafx.event.EventHandler;
import modele.Temple;
import vue.VBoxRoot;

import java.io.File;
import java.util.Collection;

public class controleur implements EventHandler {
        @Override
    public void handle (Event event) {
        Object userData = ((Menultem) event.getSource()).getUserData();
        if (userData instanceof File) { // l'ut. a choisi un scénario
            File fichierScenario = (File) userData;
            System.out.println(fichierScenario.getName());
            File scenario = fichierScenario;
            Collection<Temple> temples = LectureScenario.lecture(fichierScenario);
            VBoxRoot.getApprenti().setTemples(temples);
            System.out.println(VBoxRoot.getApprenti());
        }
    }
}