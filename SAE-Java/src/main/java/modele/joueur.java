package modele;

import javafx.util.Pair;

import static java.lang.Math.abs;

public class joueur {

    private Pair <Integer, Integer> chPosition;

    private int chTour;

    public joueur (){
        chPosition = new Pair<Integer, Integer>(0, 0);
    }

    public Pair <Integer, Integer> getPosition(){
        return chPosition;
    }

    public void updatePosition(int posX, int posY) throws ExceptionJoueur {
        if (abs(posX - chPosition.getKey()) > 1 || abs(posY - chPosition.getValue()) > 1){
            throw new ExceptionJoueur("Deplacment non autorisée");
        }
        else {
            chPosition = new Pair<>(posX, posY);
            chTour += 1;
        }

    }


}
