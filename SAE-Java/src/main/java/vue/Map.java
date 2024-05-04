package vue;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.Cristaux;
import modele.ExceptionCristaux;
import modele.ExceptionTemple;
import modele.Temple;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Map extends VBox {

    private Label nbPas;
    private Canvas canvasCarte;
    private GraphicsContext graphicsContext2D;

    public Map() {

        try {
            Scanner scanner = new Scanner(new File("data" + File.separator + "scenario0.txt")).useDelimiter("\\s+");
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
