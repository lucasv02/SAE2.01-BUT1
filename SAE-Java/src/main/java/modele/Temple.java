package modele;

public class Temple implements Constantes {

    private Position chPosition;

    private int chCouleur;

    private int chCristal;

    public Temple(Position parPostion, int parCouleur, int parCristal) {
        chPosition = parPostion;
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
        return "Couleur du temple: " + COULEUR[chCouleur] + " Position " + chPosition.toString()
                + " Cristal associée: " + COULEUR[chCristal];
    }




}
