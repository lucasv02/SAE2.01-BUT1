package modele;

/**
 * Classe Historique
 * Cette classe permet de stocker les informations de l'historique.
 */
public class Historique {

    // Déclaration des attributs de la classe Historique
    private Position chPosition;
    private String chString;
    private int chCristaux;

    /**
     * Constructeur de la classe Historique
     * Il initialise la position, le string et le nombre de cristaux.
     * @args : Position parPosition, String parString, int parCristaux
     * @return : void
     */
    public Historique(Position parPosition, String parString, int parCristaux) {
        chPosition = parPosition;
        chString = parString;
        chCristaux = parCristaux;
    }

    /**
     * Méthode getChPosition qui permet de récupérer la position de l'historique.
     * @args : aucun
     * @return : Position : position de l'historique
     */
    public Position getChPosition() {
        return chPosition;
    }

    /**
     * Méthode getChString qui permet de récupérer le string de l'historique.
     * @args : aucun
     * @return : String : string de l'historique
     */
    public String getChString() {
        return chString;
    }

    /**
     * Méthode getChCristaux qui permet de récupérer le cristal de l'historique.
     * @args : aucun
     * @return : int : cristal de l'historique
     */
    public int getChCristaux() {
        return chCristaux;
    }
}
