package modele;

import javafx.application.Preloader;
import vue.HBoxApp;

import java.util.TreeMap;

public class TriSelection {

    private TreeMap <Integer, Temple> templesRestant;

    private Temple templeD;

    private Temple templeF;

    private int etape;

    public TriSelection(Scenario parScenario) {
        templesRestant = new TreeMap<Integer, Temple>();
        templeD = null;
        templeF = null;
        etape = 0;
    }

    public void deplacement (Scenario parScenario) {

        this.EtapeSuivante();

        if (this.getEtape() == 1) {
            HBoxApp.getControleur().deplacement(this.getTempleF().getChPosition(), 2);
        }
        else if (this.getEtape() == 2) {
            HBoxApp.getControleur().deplacement(this.getTempleD().getChPosition(), 2);
        }
        else if (this.getEtape() == 3) {
            this.updatePosition(parScenario);
            HBoxApp.getControleur().deplacement(this.getTempleD().getChPosition(), 2);
        }
    }

    public void updatePosition(Scenario parScenario){

        etape = 0;
        templesRestant.clear();
        for (Temple temple : parScenario.getListeTemple()) {
            if (temple.getChCristal() != temple.getChCouleur()) {
                templesRestant.put(temple.getChCouleur(), temple);
            }
        }
        setTempleDebut();
        setTempleFin();
        System.out.println(templesRestant.size());
    }

    public void EtapeSuivante () {
        etape++;
    }


    public void setTempleDebut() {
        int valeur = templesRestant.firstKey();
        templeD = templesRestant.get(valeur);

    }

    public void setTempleFin() {
        for (Temple temple : templesRestant.values()) {
            if (temple.getChCristal() == templeD.getChCouleur()) {
                templeF = temple;
            }
        }
    }

    public Temple getTempleD() {
        return templeD;
    }

    public Temple getTempleF() {
        return templeF;
    }

    public int getEtape() {
        return etape;
    }
}
