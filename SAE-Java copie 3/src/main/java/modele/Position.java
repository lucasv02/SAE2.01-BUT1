package modele;

public class Position {
    private static int nombreDePas = 0;
    private int abscisse;
    private int ordonnee;

    public Position(int abscisse, int ordonnee) {

        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

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

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }


    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }


    public boolean equals(Position position) {
        if (position.abscisse - abscisse == 0 && position.ordonnee - ordonnee == 0) {
            return true;
        }
        else {
            return false;
        }
    }



    public void SetNombreDePas(int parNb) {
        nombreDePas = parNb;
    }

    public int getAbscisse () {
        return abscisse;
    }

    public int getOrdonnee () {
        return ordonnee;
    }

    public static int getNombreDePas () {
        return nombreDePas;
    }

    public String toString() {
        return "(" + abscisse +  "," + ordonnee + ")";
    }
}