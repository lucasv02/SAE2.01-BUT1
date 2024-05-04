package modele;

public class ExceptionCristaux extends Exception implements ConstantesErreur {

    private int chCode;

    public ExceptionCristaux(int parCode) {
        parCode = chCode;
    }

    @Override
    public String toString() {
        return ERREURS_CRISTAUX[chCode];
    }

    public int getChCode() {
        return chCode;
    }
}