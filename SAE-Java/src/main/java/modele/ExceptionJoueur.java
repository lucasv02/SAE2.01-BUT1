package modele;
public class ExceptionJoueur extends Exception implements ConstantesErreur{

    private int chCode;

    public ExceptionJoueur(int parCode) {
        chCode = parCode;
    }

    @Override
    public String toString() {
        return ERREURS_JOUEURS[chCode];
    }

    public int getChCode() {
        return chCode;
    }
}
