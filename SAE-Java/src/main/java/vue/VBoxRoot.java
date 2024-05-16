//package vue;
//
//import controleur.controleur;
//import javafx.geometry.Insets;
//import javafx.scene.control.Menu;
//import javafx.scene.control.MenuBar;
//import javafx.scene.control.MenuItem;
//import javafx.scene.layout.VBox;
//import modele.ApprentiOrdonnateur;
//import modele.Constantes;
//
//import java.io.File;
//
//public class VBoxRoot extends VBox implements Constantes {
//    private static ApprentiOrdonnateur apprenti ;
//    private static controleur controleur ;
//    private static VBoxCanvas vueCanvas; // ancienne VBoxRoot
//    public VBoxRoot () {
//        controleur = new controleur() ;
//// La barre de menus
//        MenuBar menuBar = new MenuBar();
//        this.getChildren(). add (menuBar) ;
//        VBox. setMargin (menuBar, new Insets(9 )) ;
//// Le menu des scénarios
//        Menu menuScenarios = new Menu(INTITULE_MENU_SCENARIOS) ;
//        menuBar.getMenus().add(menuScenarios) ;
//// Les items du menu scénario
//        File[] scenarios = new File ("scenarios"). listFiles();
//        for (int i= 0 ; i <scenarios.length ; i++) {
//            MenuItem menuItem = new MenuItem(scenarios[i].getName());
//            menuItem.setUserData(scenarios[i]);
//            menuItem.setOnAction(controleur);
//            menuScenarios.getItems().add(menuItem);
//        }
//    }
//}