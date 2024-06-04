package vue;

import controleur.Controleur;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modele.*;

import java.util.*;

import static java.lang.Math.abs;

public class VBoxCarte extends VBox implements Constantes {

    Canvas canvasCarte;

    GraphicsContext graphicsContext2D;

    private Boolean deplacement = false;

    private Boolean initialisation = false;

    private Boolean cristal = false;

    private int mode = 0;

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


        canvasCarte.setOnMouseClicked(event -> {
            int abscisse = (int) event.getX() / CARRE;
            int ordonnee = (int) event.getY() / CARRE;

            abscisse -= 16;
            ordonnee -= 16;

            Position positionClick = new Position(abscisse, ordonnee);
            if (initialisation) {
                if (positionClick.getAbscisse() != -16 &&  positionClick.getOrdonnee() != -16 ) {
                    HBoxApp.getControleur().deplacement(positionClick, 0);
                }
            }
        });

    }

    public Position convertPosition(Position parPosition) {
        int templeX = 0;
        int templeY = 0;

        if (parPosition.getAbscisse() < 0 ) {
            templeX = abs(parPosition.getAbscisse() + 16) * CARRE;
        }

        else if (parPosition.getAbscisse() > 0) {
            templeX = (abs(parPosition.getAbscisse())+16) * CARRE;
        }

        else if (parPosition.getAbscisse() == 0) {
            templeX = 16 * CARRE;
        }

        if (parPosition.getOrdonnee() < 0) {
            templeY = abs(parPosition.getOrdonnee()+16) * CARRE;
        }
        else if (parPosition.getOrdonnee() >= 0) {
            templeY = (parPosition.getOrdonnee() + 16) * CARRE;
        }
        else if (parPosition.getOrdonnee() == 0) {
            templeY = 16 * CARRE;

        }

        return new Position(templeX, templeY);
    }

    public void putTemple (Temple parTemple) {
        Position templePosition = convertPosition(parTemple.getChPosition());
        graphicsContext2D.setFill(Color.web(COULEUR_HEX_TEMPLE[parTemple.getChCouleur()]));
        graphicsContext2D.fillRect(templePosition.getAbscisse() + 1, templePosition.getOrdonnee() + 1, CARRE - 2, CARRE - 2);


    }

    public void putCristal (Temple parTemple) {
        Position templePosition = convertPosition(parTemple.getChPosition());
        if (parTemple.getChCristal() == -1) {
            graphicsContext2D.setFill(Color.WHITE);
            graphicsContext2D.fillOval(templePosition.getAbscisse() + 1 + CARRE / 4, templePosition.getOrdonnee() + 1 + CARRE / 4, CARRE / 2, CARRE / 2);

        }
        else {
            graphicsContext2D.setFill(Color.web(COULEUR_HEX_TEMPLE[parTemple.getChCristal()]));
            graphicsContext2D.fillOval(templePosition.getAbscisse() + 1 + CARRE / 4, templePosition.getOrdonnee() + 1 + CARRE / 4, CARRE / 2, CARRE / 2);

        }
    }

    public void putCristalJoueur (ApprentiOrdonnateur parApprenti) {
        Position JoueurPosition = convertPosition(parApprenti.getPositionApprenti());
        if (parApprenti.getCristalInHand() == -1) {
            graphicsContext2D.setFill(Color.WHITE);
            graphicsContext2D.fillOval(JoueurPosition.getAbscisse() + 1 + CARRE / 4, JoueurPosition.getOrdonnee() + 1 + CARRE / 4, CARRE / 2, CARRE / 2);
        }
        else {
            graphicsContext2D.setFill(Color.web(COULEUR_HEX_TEMPLE[parApprenti.getCristalInHand()]));
            graphicsContext2D.fillOval(JoueurPosition.getAbscisse() + 1 + CARRE / 4, JoueurPosition.getOrdonnee() + 1 + CARRE / 4, CARRE / 2, CARRE / 2);
        }
    }

    public void putApprenti (ApprentiOrdonnateur parApprenti) {
         Position apprentiPosition = convertPosition(parApprenti.getPositionApprenti());
        graphicsContext2D.setFill(Color.DARKCYAN);
        graphicsContext2D.fillOval(apprentiPosition.getAbscisse()+ 1, apprentiPosition.getOrdonnee() + 1, CARRE-2, CARRE-2);
        if (cristal) {
            putCristalJoueur(parApprenti);
        }

        else {
            graphicsContext2D.setFill(Color.WHITE);
            graphicsContext2D.fillOval(apprentiPosition.getAbscisse() + 1 + CARRE / 4, apprentiPosition.getOrdonnee() + 1 + CARRE / 4, CARRE / 2, CARRE / 2);
        
        }

    }

    public void initialisationMap (Collection <Temple> parListeTemple, ApprentiOrdonnateur parApprenti) {
        if (!initialisation) {
            for (Temple temple : parListeTemple) {
                putTemple(temple);
                putCristal(temple);
            }
            putApprenti(parApprenti);
            initialisation = true;
        }
    }

    public void reset(Collection <Temple> parListeTemple, ApprentiOrdonnateur parApprenti) {
        if (initialisation) {
            for (Temple temple : parListeTemple) {
                deleteObject(temple.getChPosition());
                deleteObject(parApprenti.getPositionApprenti());
            }
            initialisation = false;
        }

    }

    public void deleteObject (Position parPosition) {
        Position apprentiPosition = convertPosition(parPosition);

        graphicsContext2D.setFill(Color.WHITESMOKE);
        graphicsContext2D.clearRect(apprentiPosition.getAbscisse() + 1, apprentiPosition.getOrdonnee()+ 1, CARRE-2, CARRE-2);

    }


    public void deplacementApprenti (Position parPositionCible, Scenario parScenario) {
        if (! deplacement) {
            deplacement = true;
            Timer timer = new Timer();
            TimerTask timertask = new TimerTask() {
                @Override
                public void run() {
                    deleteObject(parScenario.getApprenti().getPositionApprenti());

                    for (Temple temple : parScenario.getListeTemple()) {
                        if (parScenario.getApprenti().getPositionApprenti().equals(temple.getChPosition())) {
                            putTemple(temple);
                            putCristal(temple);
                        }
                    }

                    parScenario.getApprenti().getPositionApprenti().deplacementUneCase(parPositionCible);
                    putApprenti(parScenario.getApprenti());

                    if (parScenario.getTemple(parScenario.getApprenti().getPositionApprenti()) != null && parPositionCible.equals(parScenario.getApprenti().getPositionApprenti())) {
                        if (!cristal) {
                            HBoxApp.getControleur().prendreCristal();
                        }
                        else {
                            HBoxApp.getControleur().echangeCristal();}
                    }
                    if (parScenario.getApprenti().getPositionApprenti().equals(parPositionCible)) {
                        timer.cancel();
                        deplacement = false;

                        if (mode == 2) {
                            if (!parScenario.CristauxRemis()) {
                                HBoxApp.getControleur().tri();
                            }
                        }
                        if (mode ==3) {
                            if (!parScenario.CristauxRemis()) {
                                HBoxApp.getControleur().heuristique();
                            }
                        }


                    }
                    Platform.runLater(() -> {
                        HBoxApp.getMenu().setLabelNBPas(parScenario.getApprenti().getPositionApprenti().getNombreDePas());
                        HBoxApp.getMenu().setLabelAvancement(parScenario.getNbRemis(), parScenario.getListeTemple().size());
                    });
                }
            };

            timer.scheduleAtFixedRate(timertask, 100, 100);
        }

    }





    public void setCristal(Boolean parBoolean) {
        cristal = parBoolean;
    }

    public Boolean getDeplacement() {
        return deplacement;
    }

    public Boolean getInitialisation() {
        return initialisation;
    }

    public Boolean getCristal() {
        return cristal;
    }

    public void setMode(int parMode) {
        mode = parMode;
    }
}
