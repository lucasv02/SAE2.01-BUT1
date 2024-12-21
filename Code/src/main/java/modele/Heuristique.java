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

/**
 * Classe Heuristique
 * Cette classe permet de déplacer l'apprenti sur la carte en fonction de l'heuristique choisie.
 */
public class Heuristique {

    /**
     * Constructeur de la classe Heuristique
     * @args : Scenario parScenario
     * @return : void
     */
    public Heuristique (Scenario parScenario) {
    }

    /**
     * Méthode deplacement qui permet de déplacer l'apprenti sur la carte en fonction de l'heuristique choisie.
     * Elle prend en parmaètre scénario afin d'effectuer des calculs sur le deplacement à effectuer.
     * @args : Scenario parScenario
     * @return : void
     */
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

    /**
     * Méthode getTempleLePlusProche qui permet de récupérer le temple le plus proche de l'apprenti.
     * @param scenario
     * @return Temple : temple le plus proche de l'apprenti
     */
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
        return templeLePlusProche;
    }

    /**
     * Méthode distanceEntre qui permet de calculer la distance entre deux positions.
     * Elle prend en paramètre deux positions et retourne la distance entre ces deux positions.
     * @param position1
     * @param position2
     * @return int : distance entre les deux positions
     */
    public int distanceEntre (Position position1, Position position2) {
        int distanceX = abs(position1.getAbscisse() - position2.getAbscisse());
        int distanceY = abs(position1.getOrdonnee() - position2.getOrdonnee());
        return distanceX + distanceY;
    }


}