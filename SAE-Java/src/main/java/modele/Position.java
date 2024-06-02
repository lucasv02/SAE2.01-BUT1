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
    public double distanceTo(Position other) {
        double deltaX = this.abscisse - other.getAbscisse();
        double deltaY = this.ordonnee - other.getOrdonnee();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
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
