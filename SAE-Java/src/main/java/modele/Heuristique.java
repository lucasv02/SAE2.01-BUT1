package modele;

import modele.Position;
import modele.Scenario;
import modele.Temple;
import vue.HBoxApp;

import java.util.Collection;

import static java.lang.Math.abs;

public class Heuristique {

    public Heuristique (Scenario parScenario) {
        Temple templePlusProche = getTempleLePlusProche(parScenario);
        HBoxApp.getControleur().deplacement(templePlusProche.getChPosition());
    }

    public Temple getTempleLePlusProche(Scenario scenario) {
        Collection<Temple> temples = scenario.getListeTemple();
        Temple templeLePlusProche = null;
        double distanceMin = Double.MAX_VALUE;

        for (Temple temple : temples) {
            double distance = distanceEntre(temple.getChPosition(), scenario.getApprenti().getPositionApprenti());
            if (distance < distanceMin) {
                templeLePlusProche = temple;
                distanceMin = distance;
            }
        }

        if (templeLePlusProche == null) {
            // Handle the case where no temple was found
            // This could be by returning a default value, throwing an exception, etc.
        }

        return templeLePlusProche;
    }

    public int distanceEntre (Position position1, Position position2) {
        int distanceX = abs(position1.getAbscisse() - position2.getAbscisse());
        int distanceY = abs(position1.getOrdonnee() - position2.getOrdonnee());
        return distanceX + distanceY;
    }



}