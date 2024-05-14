package modele;

import javafx.util.Pair;

import static java.lang.Math.abs;

public class Joueur {

    private Pair <Integer, Integer> chPosition;

    private int chTour;

    private Boolean chPlein;

    // Variable Integer pour le champ car on veut avoir la posibilité de le déclarer en tant que null
    private Integer chCristal;

    public Joueur() {
        chPosition = new Pair <Integer, Integer>(0, 0);
        chCristal = null;
        chPlein = false;
    }

    public Pair <Integer, Integer> getPosition(){
        return chPosition;
    }

    public int getChTour () {
        return chTour;
    }

    @Override
    public String toString() {
        return "Position X: " + chPosition.getKey() + " " +  "Position Y: " + chPosition.getValue();
    }

    public void updatePosition (int posX, int posY) throws ExceptionJoueur {
        if (chPosition.getKey().equals(posX) && chPosition.getValue().equals(posY)) {
            throw new ExceptionJoueur(3);
        }
    }

    public Integer getChCristal() {
        return chCristal;
    }

    public Boolean getChPlein() {
        return chPlein;
    }
}
