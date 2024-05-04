package modele;

import javafx.util.Pair;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class Cristaux implements Constantes {

    private TreeMap <Integer, Integer> chCristaux;

    public Cristaux (int parCouleur, int parTemple) {
        chCristaux = new TreeMap<Integer, Integer>();
    }

    public int getTaille () {
        return chCristaux.size();
    }

    public void ajoutChCristaux (int parCristaux, int parTemple) throws ExceptionCristaux {
        if (chCristaux.containsKey(parCristaux)) {
            throw new ExceptionCristaux(0);
        }
        else {
            chCristaux.put(parCristaux, parTemple);
        }
    }

    public void updateChCristaux (int parCristaux, int parTemple) throws ExceptionCristaux {
        if (!chCristaux.containsKey(parCristaux)) {
            throw new ExceptionCristaux(1);
        }
        else {
            chCristaux.put(parCristaux, parTemple);
        }
    }

    public int getPosition (int parCristaux) throws ExceptionCristaux {
        if (!chCristaux.containsKey(parCristaux)) {
            throw new ExceptionCristaux(1);
        }
        else {
            return chCristaux.get(parCristaux);
        }
    }

    public String toString() {
        Set <Integer> setClefs = chCristaux.keySet();
        Iterator <Integer> iterateur = setClefs.iterator();
        String phrase = "";
        while (iterateur.hasNext()) {
            int clef = iterateur.next();
            phrase += "Cristaux: " + COULEUR_TEMPLE[clef] + " Temple actuel: " + COULEUR_TEMPLE[chCristaux.get(clef)] + "\n";
        }
        return phrase;
    }

    public String toString(int parCristaux) throws ExceptionCristaux {

        if (!chCristaux.containsKey(parCristaux)) {
            throw new ExceptionCristaux(1);
        }
        else {
            return "Cristaux: " + COULEUR_TEMPLE[parCristaux] + " Temple actuel: " + chCristaux.get(parCristaux);
        }
    }



}
