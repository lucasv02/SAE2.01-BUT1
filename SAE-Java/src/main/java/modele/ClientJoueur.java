package modele;

public class ClientJoueur {
    public static void main (String [] args) {
        try {
            Joueur test = new Joueur();
            System.out.println(test);
            test.updatePosition(0,3);
        }
        catch(ExceptionJoueur parCode){
            System.out.println(parCode);
            System.exit(-1);

        }
    }
}
