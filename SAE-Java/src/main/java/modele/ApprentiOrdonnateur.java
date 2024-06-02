package modele;

import org.jetbrains.annotations.NotNull;

public class ApprentiOrdonnateur {

    private Position posApprenti;
    private int cristalInHand;

    // Constructeur
    public ApprentiOrdonnateur() {
        this.posApprenti = new Position(0,0);
        this.cristalInHand = -1;
    }

    // Méthode pour définir la position de l'apprenti
    public void setPositionApprenti(Position posApprenti) {
       this.posApprenti = posApprenti;
   }

    // Méthode pour définir le cristal que l'apprenti tient
    public void setCristalInHand(int cristalInHand) {
        this.cristalInHand = cristalInHand;
    }

    // Méthode pour que l'apprenti dépose le cristal dans le temple donné
    public void deposerCristal( Temple temple) {
        temple.setChCristal(this.cristalInHand);
        this.cristalInHand = -1; // L'apprenti n'a plus de cristal en main
    }


    // Méthode pour obtenir la position de l'apprenti
    public Position getPositionApprenti() {
        return posApprenti;
    }

    // Méthode pour obtenir le cristal que l'apprenti tient
    public int getCristalInHand() {
        return cristalInHand;
    }

    public void deplacer(Position nouvellePosition) {
        this.posApprenti = nouvellePosition;
        }

}





