package vue;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modele.ApprentiOrdonnateur;
import modele.DonneesCanvas;
import modele.INTITULE_MENU_SCENARIOS;

import java.io.File;




public class VBoxRoot extends VBox implements DonneesCanvas,INTITULE_MENU_SCENARIOS {
    private static ApprentiOrdonnateur apprenti ;
    //private static controleur controleur ;
    public VBoxRoot () {
        //controleur = new controleur() ;


        // La barre de menus
        MenuBar menuBar = new MenuBar();
        this.getChildren().add(menuBar) ;
        VBox.setMargin (menuBar, new Insets(9 )) ;

        // Le menu des scénarios
        Menu menuScenarios = new Menu("Scénario") ;
        menuBar.getMenus().add(menuScenarios) ;

        // Les items du menu scénario
        for(String intituleMenuScenario : INTITULE_MENU_SCENARIOS) {
            MenuItem menuItem = new MenuItem(intituleMenuScenario);
            menuItem.setUserData(intituleMenuScenario);
            //menuItem.setOnAction(controleur);
            menuScenarios.getItems().add(menuItem);
        }
        // Ajustement de la taille de la grille
        int numColumns = 31;
        int numRows = 31;
        int gridWidth = numColumns * CARRE;
        int gridHeight = numRows * CARRE;

        // l'étiquette qui affiche le nombre de pas
        Label labelNombreDePas = new Label("Nombre de pas : 0");

        // le canvas et son contexte graphique
        Canvas canvasCarte = new Canvas(gridWidth, gridHeight);
        canvasCarte.setWidth(LARGEUR_CANVAS);
        canvasCarte.setHeight(HAUTEUR_CANVAS);
        GraphicsContext graphicsContext2D = canvasCarte.getGraphicsContext2D();

        // les carrés
        for (int i = 0; i < gridWidth; i += CARRE) {
            for (int j = 0; j < gridHeight; j += CARRE) {
                graphicsContext2D.strokeRect(i, j, CARRE, CARRE);
            }
        }
        // ajout des composants graphiques à la racine (this)
        this.getChildren().add(labelNombreDePas);
        VBox.setMargin(labelNombreDePas, new Insets(30));
        this.getChildren().add(canvasCarte);
        VBox.setMargin(canvasCarte, new Insets(30));


        graphicsContext2D.setFill(COULEUR_GRILLE);
        for (int i = 0; i < numColumns; i++) {
            int x = (i + 1) * CARRE + CARRE / 3; // Ajouter CARRE pour positionner à l'extérieur
            int y = CARRE / 2;
            graphicsContext2D.fillText(Integer.toString(i), x, y);
        }
        for (int i = 0; i < numRows; i++) {
            int x = CARRE / 3;
            int y = (i + 1) * CARRE + CARRE / 2; // Ajouter CARRE pour positionner à l'extérieur
            graphicsContext2D.fillText(Integer.toString(i), x, y);

        }

    }

}

