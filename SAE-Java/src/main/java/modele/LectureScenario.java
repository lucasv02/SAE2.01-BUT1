package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class LectureScenario implements Constantes {

    public static Collection <Temple> lecture (String parNomF) {

        File fichier = new File("data" + File.separator + parNomF);
        Collection <Temple> TemplesDuScenario = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(fichier).useDelimiter("\\s+");
            Temple temple;

            while (scanner.hasNext()) {
                int posX = scanner.nextInt();
                int poxY = scanner.nextInt();
                int couleurT = scanner.nextInt();
                int cristal = scanner.nextInt();
                temple = new Temple(new Position(posX, poxY), couleurT, cristal);
                TemplesDuScenario.add(temple);
                System.out.println(temple);
            }
           scanner.close();
        }

        catch (FileNotFoundException parExecption) {
            System.out.println("Fichier introuvable");
        }

        return TemplesDuScenario;
    }


}
