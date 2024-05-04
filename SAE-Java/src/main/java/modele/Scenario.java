package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scenario {
    public static void main (String [] args) {
        try {
            Scanner scanner = new Scanner(new File("data" + File.separator + "scenario5.txt")).useDelimiter("\\s+");
            Temple temple = new Temple();
            Cristaux cristaux = new Cristaux();

            while (scanner.hasNext()) {
                int posX = scanner.nextInt();
                int poxY = scanner.nextInt();
                int couleurT = scanner.nextInt();
                int cristal = scanner.nextInt();
                temple.ajoutChTemple(posX, poxY,couleurT);
                cristaux.ajoutChCristaux(cristal, couleurT);
            }
            System.out.println(temple);
            System.out.println(cristaux);
        }

        catch (FileNotFoundException parExecption) {
            System.out.println("Fichier introuvable");
        }

        catch (ExceptionTemple parCode) {
            System.out.println(parCode);
            System.exit(-1);
        }

        catch (ExceptionCristaux parCode) {
            System.out.println(parCode);
            System.exit(-1);
        }
    }
}
