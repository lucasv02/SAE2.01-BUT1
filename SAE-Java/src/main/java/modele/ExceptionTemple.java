package modele;

public class ExceptionTemple extends Exception implements ConstantesErreur {

    private int chCode;

    public ExceptionTemple(int parCode) {
        parCode = chCode;
    }

    @Override
    public String toString() {
        return ERREURS_TEMPLE[chCode];
    }

    public int getChCode() {
        return chCode;
    }
}

