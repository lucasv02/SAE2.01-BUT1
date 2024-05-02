package modele;

import javafx.util.Pair;

public class joueur {

    private Pair <Integer, Integer> chPosition;

    public joueur (){
        chPosition = new Pair<Integer, Integer>(0, 0);
    }

    public Pair <Integer, Integer> getPosition(){
        return chPosition;
    }



}
