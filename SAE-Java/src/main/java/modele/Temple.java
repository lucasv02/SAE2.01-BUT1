package modele;

import javafx.util.Pair;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class Temple implements ConstantesTemple {

    private TreeMap<Integer, Pair<Integer, Integer>> chTemple;

    public Temple() {
        chTemple = new TreeMap<>();
    }

    public int getTaille() {
        return chTemple.size();
    }

    public void ajoutChTemple (int parPosX, int parPosY, int parClefT) throws ExceptionTemple {

        if (chTemple.containsKey(parClefT)) {
            throw new ExceptionTemple(0);
        }
        else {
            chTemple.put(parClefT, new Pair<>(parPosX, parPosY));
        }

    }

    public void updateChTemple (int parPosX, int parPosY, int parClefT) throws ExceptionTemple {

        if (!chTemple.containsKey(parClefT)) {
            throw new ExceptionTemple(1);
        }

        else {
            chTemple.put(parClefT, new Pair<>(parPosX, parPosY));
        }

    }

    public Pair getTemple (int parClefT) throws ExceptionTemple {
        if (!chTemple.containsKey(parClefT)) {
            throw new ExceptionTemple(1);
        }
        else {
            return chTemple.get(parClefT);
        }
    }

    public String toString() {

        Set <Integer> setsClefs = chTemple.keySet();
        Iterator <Integer> iterateur = setsClefs.iterator();
        String phrase = "";
        while (iterateur.hasNext()) {
            int clef = iterateur.next();
            phrase += "Couleur du temple: " + COULEUR_TEMPLE[clef] + " PositionX: " + +chTemple.get(clef).getKey()
                    + " PositionY: " + chTemple.get(clef).getValue() + "\n";
        }
        return phrase;
    }

    public String toString(int parClefT) throws ExceptionTemple{

        if (!chTemple.containsKey(parClefT)) {
            throw new ExceptionTemple(1);
        }
        else {
            return "Couleur du temple: " + COULEUR_TEMPLE[parClefT] + " PositionX: " + +chTemple.get(parClefT).getKey()
                    + " PositionY: " + chTemple.get(parClefT).getValue();
        }
    }


}
