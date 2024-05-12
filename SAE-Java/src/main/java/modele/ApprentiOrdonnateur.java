package modele;

public class ApprentiOrdonnateur {
    private Position posApprenti;
    private Cristaux cristalInHand;

    // Constructeur
    public ApprentiOrdonnateur(Position posApprenti, Cristaux cristalInHand) {
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
    public Cristaux getCristalInHand() {
        return cristalInHand;
    }

    // Méthode pour définir le cristal que l'apprenti tient
    public void setCristalInHand(Cristaux cristalInHand) {
        this.cristalInHand = cristalInHand;
    }
}
