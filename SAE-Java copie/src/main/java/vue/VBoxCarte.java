package vue;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import modele.Constantes;

public class VBoxCarte extends VBox implements Constantes {

    private Canvas canvasCarte;

    public VBoxCarte() {

        canvasCarte = new Canvas();
        canvasCarte.setWidth(LARGEUR_CANVAS);
        canvasCarte.setHeight(HAUTEUR_CANVAS);
        GraphicsContext graphicsContext2D = canvasCarte.getGraphicsContext2D();

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
}
