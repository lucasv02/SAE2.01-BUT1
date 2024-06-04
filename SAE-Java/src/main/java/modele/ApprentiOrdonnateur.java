package modele;

// Classe pour l'apprenti ordonnateur
public class ApprentiOrdonnateur {

    // Déclaration des attributs de la classe ApprentiOrdonnateur
    private Position posApprenti;
    private int cristalInHand;

    /**
     * Constructeur de la classe ApprentiOrdonnateur
     * Il initialise la position de l'apprenti à (0,0) et le cristal qu'il tient à -1,
     * le -1 signifie qu'il ne tient aucun cristal.
     * @args : aucun
     * @return : void
     */
    public ApprentiOrdonnateur() {
        this.posApprenti = new Position(0,0);
        this.cristalInHand = -1;
    }

    /**
     * Méthode pour définir la position de l'apprenti
     * Elle prend en paramètre la position de l'apprenti qu'il initialise.
     * @args : Position posApprenti
     * @return : void
     */
    public void setPositionApprenti(Position posApprenti) {
       this.posApprenti = posApprenti;
   }

    /**
     * Méthode pour définir le cristal que l'apprenti tient
     * Elle prend en paramètre le cristal que l'apprenti tient et l'initialise.
     * @args : int cristalInHand
     * @return : void
     */
    public void setCristalInHand(int cristalInHand) {
        this.cristalInHand = cristalInHand;
    }

    /**
     * Méthode pour déposer un cristal sur le temple.
     * Elle prend en paramètre le temple et dépose le cristal que l'apprenti tient sur le temple.
     * Le cristal du joueur est mis à -1.
     * @args : Temple temple
     * @return : void
     */
    public void deposerCristal( Temple temple) {
        temple.setChCristal(this.cristalInHand);
        this.cristalInHand = -1; // L'apprenti n'a plus de cristal en main
    }

    /**
     * Méthoderécupérer la position de l'apprenti
     * @args : aucun
     * @return : Position : position de l'apprenti
     */
    public Position getPositionApprenti() {
        return posApprenti;
    }

    /**
     * Méthode pour récupérer le cristal que l'apprenti tient
     * @args : aucun
     * @return : int : cristal que l'apprenti tient
     */
    public int getCristalInHand() {
        return cristalInHand;
    }

}





