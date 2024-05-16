package modele;

public class Temple implements DonnéesCanvas {

    private Position chPosition;

    private int chCouleur;

    private int chCristal;

    public Temple(Position parPosition, int parCouleur, int parCristal) {
        chPosition = parPosition;
        chCouleur = parCouleur;
        chCristal = parCristal;
    }

    public Position getChPosition ()  {
        return chPosition;
    }

    public int getChCouleur () {
        return chCouleur;
    }

    public int getChCristal () {
        return chCristal;
    }

    public String toString() {
        return "Temple: " + chCouleur + " Couleur du temple: " + COULEUR[chCouleur] + " " + chPosition.toString()
                + " Cristal associée: " + COULEUR[chCristal];
    }




}
