package modele;

public class ApprentiOrdonnateur {
    private Position posApprenti;
    private int cristalInHand;

    // Constructeur
    public ApprentiOrdonnateur(Position posApprenti, int cristalInHand) {
        this.posApprenti = posApprenti;
        this.cristalInHand = cristalInHand;
    }

    // Méthode pour obtenir la position de l'apprenti
    public Position getPositionApprenti() {
        return posApprenti;
    }

    // Méthode pour définir la position de l'apprenti
    public void setPositionApprenti(Position posApprenti) {
        this.posApprenti = posApprenti;
    }

    // Méthode pour obtenir le cristal que l'apprenti tient
    public int getCristalInHand() {
        return cristalInHand;
    }

    // Méthode pour définir le cristal que l'apprenti tient
    public void setCristalInHand(int cristalInHand) {
        this.cristalInHand = cristalInHand;
    }
}
