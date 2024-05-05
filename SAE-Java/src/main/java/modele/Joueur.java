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
        chPosition = new Pair<Integer, Integer>(0, 0);
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

    public void updatePosition(int posX, int posY) throws ExceptionJoueur {

        if (abs(posX) > 12 || abs(posY) > 12) {
            throw new ExceptionJoueur(1);
        }

        else if  (abs(posX - chPosition.getKey()) > 1 || abs(posY - chPosition.getValue()) > 1){
            throw new ExceptionJoueur(2);
        }

        else if (abs(posX - chPosition.getValue())+ abs(posY - chPosition.getValue()) > 1) {
            throw new ExceptionJoueur(2);
        }

        else if (abs(posX - chPosition.getKey()) == 0 && abs(posY - chPosition.getValue()) == 0){
            throw new ExceptionJoueur(3);
        }

        else {
            if (chPosition.getKey() > posX) {
                chPosition = new Pair<Integer, Integer>(chPosition.getKey()-1, chPosition.getValue());
            }

            if (chPosition.getKey() < posX) {
                chPosition = new Pair<Integer, Integer>(chPosition.getKey()+1, chPosition.getValue());
            }

            if (chPosition.getValue() > posY) {
                chPosition = new Pair<Integer, Integer>(chPosition.getKey(), chPosition.getValue()-1);
            }
            if (chPosition.getValue() < posY) {
                chPosition = new Pair<Integer, Integer>(chPosition.getKey(), chPosition.getValue()+1);
            }
        }
    }

    public Integer getChCristal() {
        return chCristal;
    }

    public Boolean getChPlein() {
        return chPlein;
    }
}
