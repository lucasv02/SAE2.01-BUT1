package vue;

import controleur.controleur;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modele.ApprentiOrdonnateur;
import modele.DonnéesCanvas;

import java.io.File;

public class VBoxRoot extends VBox implements DonnéesCanvas {
    private static ApprentiOrdonnateur apprenti ;
    private static controleur controleur ;
    private static VBoxCanvas vueCanvas; // ancienne VBoxRoot
    public VBoxRoot () {
        controleur = new controleur() ;
// La barre de menus
        MenuBar menuBar = new MenuBar();
        this.getChildren(). add (menuBar) ;
        VBox. setMargin (menuBar, new Insets(9 )) ;
// Le menu des scénarios
        Menu menuScenarios = new Menu(INTITULE_MENU_SCENARIOS) ;
        menuBar.getMenus().add(menuScenarios) ;
// Les items du menu scénario
        File[] scenarios = new File ("scenarios"). listFiles();
        for (int i= 0 ; i <scenarios.length ; i++) {
            MenuItem menuItem = new MenuItem(scenarios[i].getName());
            menuItem.setUserData(scenarios[i]);
            menuItem.setOnAction(controleur);
            menuScenarios.getItems().add(menuItem);
        }
        // l'étiquette qui affiche le nombre de pas
        Label labelNombreDePas = new Label("Nombre de pas : 0");
        // le canvas et son contexte graphique
        Canvas canvasCarte = new Canvas();
        canvasCarte.setWidth(LARGEUR_CANVAS);
        canvasCarte.setHeight(HAUTEUR_CANVAS);
        GraphicsContext graphicsContext2D = canvasCarte.getGraphicsContext2D();
        // les carrés
        graphicsContext2D.setStroke(COULEUR_GRILLE);
        for (int i = 0; i < LARGEUR_CANVAS; i += CARRE) {
            for (int j = 0; j < HAUTEUR_CANVAS; j += CARRE) {
                graphicsContext2D.strokeRect(i, j, CARRE, CARRE);
            }
        }
        // ajout des composants graphiques à la racine (this)
        this.getChildren().add(labelNombreDePas);
        VBox.setMargin(labelNombreDePas, new Insets(30));
        this.getChildren().add(canvasCarte);
        VBox.setMargin(canvasCarte, new Insets(30));


        int numcol = 1;
        graphicsContext2D.setFill(COULEUR_GRILLE);
        for(int i = CARRE; i < LARGEUR_CANVAS; i+= CARRE){
            graphicsContext2D.fillText(Integer.toString(numcol),i+CARRE/3, CARRE/2);
            numcol++;
        }
        int numLigne = 1;
        graphicsContext2D.setFill(COULEUR_GRILLE);
        for(int i = CARRE; i < HAUTEUR_CANVAS; i+= CARRE) {
            graphicsContext2D.fillText(Integer.toString(numLigne), CARRE / 3, i + CARRE / 2);
            numLigne++;
        }
    }
    }
}