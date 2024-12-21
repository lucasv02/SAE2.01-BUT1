package modele;

/**
 * Classe Temple
 * Cette classe permet de stocker les informations des temples.
 */
public class Temple implements Constantes {

    // Déclaration des attributs de la classe Temple
    private Position chPosition;
    private int chCouleur;
    private int chCristal;

    /**
     * Constructeur de la classe Temple
     * Il initialise la position, la couleur et le cristal du temple en fonction des paramètres.
     * @args : Position parPosition, int parCouleur, int parCristal
     * @return : void
     */
    public Temple(Position parPosition, int parCouleur, int parCristal) {
        chPosition = parPosition;
        chCouleur = parCouleur;
        chCristal = parCristal;
    }

    /**
     * Méthode getChPosition qui permet de récupérer la position du temple.
     * @args : aucun
     * @return : Position : position du temple
     */
    public Position getChPosition ()  {
        return chPosition;
    }

    /**
     * Méthode getChCouleur qui permet de récupérer la couleur du temple.
     * @args : aucun
     * @return : int : couleur du temple
     */
    public int getChCouleur () {
        return chCouleur;
    }

    /**
     * Méthode getChCristal qui permet de récupérer le cristal du temple.
     * @args : aucun
     * @return : int : cristal du temple
     */
    public int getChCristal () {
        return chCristal;
    }

    /**
     * Méthode setChcristal qui permet de modifier le cristal du temple.
     * @args : int chCristal
     * @return : void
     */
    public void setChCristal(int chCristal) {
        this.chCristal = chCristal;
    }

    /**
     * Méthode toString qui permet d'afficher les informations du temple.
     * @args : aucun
     * @return : String : informations du temple
     */
    public String toString() {
        return "Temple: " + chCouleur + " Couleur du temple: " + COULEUR[chCouleur] + " Position: " + chPosition.toString()
                + " Cristal associée: " + COULEUR[chCristal];
    }


}
