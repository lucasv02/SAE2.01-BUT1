package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Scenario {

    private Collection <Temple> listeTemple;

    private ApprentiOrdonnateur apprenti;

    public Scenario (String parFile) {

        this.listeTemple = new ArrayList<>();
        File fichier = new File ("SAE-Java"+ File.separator +"data" +File.separator + parFile);

        try {
            Scanner scanner = new Scanner(fichier).useDelimiter("\\s+");
            Temple temple;

            while (scanner.hasNext()) {
                int posX = scanner.nextInt();
                int poxY = scanner.nextInt();
                int couleurT = scanner.nextInt();
                int cristal = scanner.nextInt();
                temple = new Temple(new Position(posX, poxY), couleurT, cristal);
                listeTemple.add(temple);
            }
            apprenti = new ApprentiOrdonnateur();
            scanner.close();
            System.out.println("Fichier lu");
        }

        catch (FileNotFoundException parExecption) {
            System.out.println("Fichier introuvable");
        }

    }

    public Collection <Temple> getListeTemple() {
        return listeTemple;
    }

    public Temple getTemple (int parCouleur) {
        for (Temple temple : listeTemple) {
            if (temple.getChCouleur() == parCouleur) {
                return temple;
            }
        }
        return null;
    }

    public ApprentiOrdonnateur getApprenti() {
        return apprenti;
    }
}
