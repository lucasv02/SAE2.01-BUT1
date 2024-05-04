package modele;

public class ClientCristaux {
    public static void main (String [] args) {
        try {
            Cristaux test = new Cristaux();
            test.ajoutChCristaux(3, 5);
            System.out.println(test);
            test.ajoutChCristaux(3,4);
        }
        catch (ExceptionCristaux parCode) {
            System.out.println(parCode);
            System.exit(-1);
        }
    }
}
