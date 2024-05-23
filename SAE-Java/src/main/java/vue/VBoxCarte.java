package vue;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modele.*;

import java.util.Collection;
import java.util.Collections;

import static java.lang.Math.abs;

public class VBoxCarte extends VBox implements Constantes {

    private Canvas canvasCarte;

    GraphicsContext graphicsContext2D;

    public VBoxCarte() {

        canvasCarte = new Canvas();
        canvasCarte.setWidth(LARGEUR_CANVAS);
        canvasCarte.setHeight(HAUTEUR_CANVAS);
        graphicsContext2D = canvasCarte.getGraphicsContext2D();
        graphicsContext2D.setGlobalBlendMode(BlendMode.SRC_OVER);


        // Création du quadrillage
        graphicsContext2D.setStroke(COULEUR_GRILLE);
        for (int i = 0; i < LARGEUR_CANVAS; i += CARRE) {
            for (int j = 0; j < HAUTEUR_CANVAS; j += CARRE) {
                graphicsContext2D.strokeRect(i, j, CARRE, CARRE);
            }
        }

        // Affichage des numéros sur les colognes
        int numcol = -15;
        graphicsContext2D.setFill(COULEUR_GRILLE);
        for(int i = CARRE; i < LARGEUR_CANVAS; i+= CARRE) {

            if (numcol >= -15 && numcol <= -10) {
                graphicsContext2D.fillText(Integer.toString(numcol), i + CARRE/6, 3*CARRE/4);
                numcol++;
            }

            else if (numcol >= -9 && numcol <= -1) {
                graphicsContext2D.fillText(Integer.toString(numcol), i + CARRE/4, 3*CARRE/4);
                numcol++;
            }

            else if (numcol >= 0 && numcol <= 9) {
                graphicsContext2D.fillText(Integer.toString(numcol), i + CARRE/3, 3*CARRE/4);
                numcol++;
            }

            else {
                graphicsContext2D.fillText(Integer.toString(numcol), i + CARRE/4, 3*CARRE/4);
                numcol++;
            }
        }

        // Affichage des numéros sur les lignes
        int numligne = -15;
        graphicsContext2D.setFill(COULEUR_GRILLE);
        for(int i = CARRE; i < HAUTEUR_CANVAS; i+= CARRE) {

            if (numligne >= -15 && numligne <= -10) {
                graphicsContext2D.fillText(Integer.toString(numligne), CARRE/6, i + 3*CARRE/4);
                numligne++;
            }

            else if (numligne >= -9 && numligne <= -1) {
                graphicsContext2D.fillText(Integer.toString(numligne), CARRE/4, i + 3*CARRE/4);
                numligne++;
            }

            else if (numligne >= 0 && numligne <= 9) {
                graphicsContext2D.fillText(Integer.toString(numligne), CARRE/3, i + 3*CARRE/4);
                numligne++;
            }

            else {
                graphicsContext2D.fillText(Integer.toString(numligne), CARRE/4, i + 3*CARRE/4);
                numligne++;
            }

        }

        this.getChildren().add(canvasCarte);
        VBoxCarte.setMargin(canvasCarte, new Insets(30));


    }

    public Position convertPosition(Position parPosition) {
        System.out.println("X: " + parPosition.getAbscisse() + " Y: " + parPosition.getOrdonnee());
        int templeX = 0;
        int templeY = 0;
        if (parPosition.getAbscisse()  < 0) {
            templeX = abs(parPosition.getAbscisse()) * CARRE;
        }
        else if (parPosition.getAbscisse() >= 0) {
            templeX = (parPosition.getAbscisse() + 16)* CARRE;
        }
        if (parPosition.getOrdonnee() < 0) {
            templeY = abs(parPosition.getOrdonnee()) * CARRE;
        }
        else if (parPosition.getOrdonnee() >= 0) {
            templeY = (parPosition.getOrdonnee() + 16) * CARRE;
        }
        System.out.println("X: " + templeX + " Y: " + templeY);
        return new Position(templeX, templeY);

    }

    public void putTemple (Temple parTemple) {

        Position templePosition = convertPosition(parTemple.getChPosition());
        graphicsContext2D.setFill(Color.BLUE);
        graphicsContext2D.fillOval(templePosition.getAbscisse() + 1, templePosition.getOrdonnee() + 1, CARRE - 2, CARRE - 2);

    }

    public void putApprenti (Position parPosition) {
         Position apprentiPosition = convertPosition(parPosition);
        graphicsContext2D.setFill(Color.DARKCYAN);
        graphicsContext2D.fillOval(apprentiPosition.getAbscisse()+ 1, apprentiPosition.getOrdonnee() + 1, CARRE-2, CARRE-2);
    }

    public void initialisationMap (Collection <Temple> parListeTemple) {
        for (Temple temple : parListeTemple) {
            putTemple(temple);
        }
        putApprenti(new Position(0, 0));
    }

    public void deleteObject (Position parPosition) {
        Position apprentiPosition = convertPosition(parPosition);
        graphicsContext2D.setFill(Color.WHITESMOKE);
        graphicsContext2D.clearRect(apprentiPosition.getAbscisse() + 1, apprentiPosition.getOrdonnee()+ 1, CARRE-2, CARRE-2);

    }

    public void updateMap (Collection <Temple> parListeTemple, Position parPosition) {
        for (Temple temple : parListeTemple) {
            putTemple(temple);
        }
        putApprenti(parPosition);
    }




}
