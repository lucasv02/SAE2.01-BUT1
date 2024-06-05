package modele;

import javafx.application.Preloader;
import vue.HBoxApp;

import java.util.TreeMap;

/**
 * Classe TriSelection
 * Cette classe permet de de trier les temples en fonction de leur couleur et de les déplacer.
 */
public class TriSelection {

    // Déclaration des attributs de la classe TriSelection
    TreeMap <Integer, Temple> templesRestant;
    private Temple templeD;
    private Temple templeF;
    private int etape;

    /**
     * Constructeur de la classe TriSelection
     * Il initialise les temples restants (temple qui n'ont pas le bon cristal), le temple de départ, le temple d'arrivée et l'étape.
     * @args : Scenario parScenario
     * @return : void
     */
    public TriSelection(Scenario parScenario) {
        templesRestant = new TreeMap<Integer, Temple>();
        templeD = null;
        templeF = null;
        etape = 0;
    }

    /**
     * Méthode deplacement qui permet a l'apprenti de se déplacer en fonction de l'étape afin de réaliser le tri.
     * @args : Scenario parScenario
     * @return : void
     */
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

    /**
     * Méthode updatePosition qui permet de mettre à jour les temples restants dans la TreeMap.
     * @args : Scenario parScenario
     * @return : void
     */
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

    /**
     * Méthode EtapeSuivante qui permet de passer à l'étape suivante.
     * @args : aucun
     * @return : void
     */
    public void EtapeSuivante () {
        etape++;
    }

    /**
     * Méthode setTempleDebut qui permet de définir le temple de départ.
     * @args : aucun
     * @return : void
     */
    public void setTempleDebut() {
        int valeur = templesRestant.firstKey();
        templeD = templesRestant.get(valeur);

    }

    /**
     * Méthode setTempleFin qui permet de définir le temple d'arrivée.
     * @args : aucun
     * @return : void
     */
    public void setTempleFin() {
        for (Temple temple : templesRestant.values()) {
            if (temple.getChCristal() == templeD.getChCouleur()) {
                templeF = temple;
            }
        }
    }

    /**
     * Méthode getTempleD qui permet de récupérer le temple de départ.
     * @args : aucun
     * @return : Temple : temple de départ
     */
    public Temple getTempleD() {
        return templeD;
    }

    /**
     * Méthode getTempleF qui permet de récupérer le temple d'arrivée.
     * @args : aucun
     * @return : Temple : temple d'arrivée
     */
    public Temple getTempleF() {
        return templeF;
    }

    /**
     * Méthode getEtape qui permet de récupérer l'étape.
     * @args : aucun
     * @return : int : étape
     */
    public int getEtape() {
        return etape;
    }
}
