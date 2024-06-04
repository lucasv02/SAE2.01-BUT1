package modele;

import javafx.application.Preloader;
import modele.Position;
import modele.Scenario;
import modele.Temple;
import vue.HBoxApp;

import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Math.abs;
import static java.lang.Thread.sleep;

public class Heuristique {

    public Heuristique (Scenario parScenario) {
    }

    public void deplacement(Scenario parScenario) {

        if (parScenario.getApprenti().getCristalInHand() == -1) {
            Temple templeLePlusProche = getTempleLePlusProche(parScenario);
            HBoxApp.getControleur().deplacement(templeLePlusProche.getChPosition(), 3);
        }
        else {
            Temple temple = parScenario.getTemple(parScenario.getApprenti().getCristalInHand());
            if (!HBoxApp.getControleur().getDeplacement()) {
                HBoxApp.getControleur().deplacement(temple.getChPosition(), 3);
            }
        }
    }


    public Temple getTempleLePlusProche(Scenario scenario) {
        Collection<Temple> temples = scenario.getListeTemple();
        Temple templeLePlusProche = null;
        double distanceMin = Double.MAX_VALUE;

        for (Temple temple : temples) {
            double distance = distanceEntre(temple.getChPosition(), scenario.getApprenti().getPositionApprenti());
            if (distance < distanceMin && temple.getChCouleur() != temple.getChCristal()) {
                templeLePlusProche = temple;
                distanceMin = distance;
            }
        }

//        if (templeLePlusProche == null) {
//            // Handle the case where no temple was found
//            // This could be by returning a default value, throwing an exception, etc.
//        }

        return templeLePlusProche;
    }

    public int distanceEntre (Position position1, Position position2) {
        int distanceX = abs(position1.getAbscisse() - position2.getAbscisse());
        int distanceY = abs(position1.getOrdonnee() - position2.getOrdonnee());
        return distanceX + distanceY;
    }


}