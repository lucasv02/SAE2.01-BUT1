package modele;

public class ApprentiOrdonnateur {

    private Position posApprenti;
    private int cristalInHand;

    // Constructeur
    public ApprentiOrdonnateur() {
        this.posApprenti = new Position(0,0);
        this.cristalInHand = -1;
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

    // Méthode pour déplacer l'apprenti à une position donnée
    public void deplacer(Position position) {

    }
    // Méthode pour que l'apprenti dépose le cristal dans le temple donné
    public void deposerCristal(Temple temple) {
        // Vérifier si l'apprenti tient un cristal
        if (cristalInHand != -1) {
            // Déposer le cristal dans le temple
            temple.setChCristal(cristalInHand);
            cristalInHand = -1; // Réinitialiser le cristal en main de l'apprenti
            System.out.println("Cristal déposé dans le temple à la position " + temple.getChPosition());
        }
        else {
            System.out.println("Aucun cristal en main pour déposer.");
        }
    }
}


