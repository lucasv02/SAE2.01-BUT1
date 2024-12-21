package modele;

/**
 * Classe Position
 * Cette classe permet de stocker les informations de la position.
 */
public class Position {

    // Déclaration des attributs de la classe Position
    private static int nombreDePas = 0;
    private int abscisse;
    private int ordonnee;

    /**
     * Constructeur de la classe Position
     * Il initialise l'abscisse et l'ordonnée en fonction des paramètres donnés.
     * @args : int abscisse, int ordonnee
     * @return : void
     */
    public Position(int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    /**
     * Méthode deplacementUneCase qui permet de déplacer la position d'une case.
     * @args : Position parPosition
     * @return : void
     */
    public void deplacementUneCase(Position parPosition) {
        nombreDePas++;
        if (abscisse > parPosition.abscisse) {
            this.abscisse -= 1;
            return;
        }

        if (abscisse < parPosition.abscisse) {
            this.abscisse += 1;
            return;
        }

        if (ordonnee > parPosition.ordonnee) {
            this.ordonnee -= 1;
            return;
        }

        if (ordonnee < parPosition.ordonnee) {
            this.ordonnee += 1;
            return;
        }

    }

    /**
     * Méthode setAbscisse qui permet de définir l'abscisse de la position..
     * @args : int abscisse : abscisse de la position
     * @return : void
     */
    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    /**
     * Méthode setOrdonnee qui permet de définir l'ordonnée de la position.
     * @args : int ordonnee : ordonnée de la position
     * @return : void
     */
    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    /**
     * Méthode equals qui permet de comparer deux positions.
     * @args : Position position : position à comparer
     * @return : boolean : true si les positions sont égales, false sinon
     */
    public boolean equals(Position position) {
        if (position.abscisse - abscisse == 0 && position.ordonnee - ordonnee == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Méthode SetNombreDePas qui permet de définir le nombre de pas.
     * @args : int parNb : nombre de pas
     * @return : void
     */
    public void SetNombreDePas(int parNb) {
        nombreDePas = parNb;
    }

    /**
     * Méthode getAbscisse qui permet de récupérer l'abscisse de la position.
     * @args : aucun
     * @return : int : abscisse de la position
     */
    public int getAbscisse () {
        return abscisse;
    }

    /**
     * Méthode getOrdonnee qui permet de récupérer l'ordonnée de la position.
     * @args : aucun
     * @return : int : ordonnée de la position
     */
    public int getOrdonnee () {
        return ordonnee;
    }

    /**
     * Méthode getNombreDePas qui permet de récupérer le nombre de pas.
     * @args : aucun
     * @return : int : nombre de pas
     */
    public static int getNombreDePas () {
        return nombreDePas;
    }

    /**
     * Méthode toString qui permet d'afficher la position.
     * @args : aucun
     * @return : String : position
     */
    public String toString() {
        return "(" + abscisse +  "," + ordonnee + ")";
    }
    }
