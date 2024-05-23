package modele;

public class Historique {

    private Position chPosition;

    private String chString;

    private int chCristaux;

    public Historique(Position parPosition, String parString, int parCristaux) {
        chPosition = parPosition;
        chString = parString;
        chCristaux = parCristaux;
    }

    public Position getChPosition() {
        return chPosition;
    }

    public String getChString() {
        return chString;
    }

    public int getChCristaux() {
        return chCristaux;
    }
}
