package modele;

import javafx.util.Pair;

import static java.lang.Math.abs;

public class Joueur {

    private Pair <Integer, Integer> chPosition;

    private int chTour;

    public Joueur() {
        chPosition = new Pair<Integer, Integer>(0, 0);
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
        else {
            chPosition = new Pair<>(posX, posY);
            chTour += 1;
        }
    }

}
