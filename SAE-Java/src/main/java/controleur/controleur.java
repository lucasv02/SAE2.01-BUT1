package controleur;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import modele.Scenario;
import modele.Temple;
import vue.VBoxRoot;
import java.io.File;
import java.util.Collection;

public class controleur implements EventHandler {
        @Override
    public void handle (Event event) {
        Object userData = ((MenuItem) event.getSource()).getUserData();
       if (userData instanceof File) { // l'ut. a choisi un scénario
           File fichierScenario = (File) userData;
           System.out.println(fichierScenario.getName());
           Scenario scenario = new Scenario("scenario1.txt");
           Collection <Temple> listeTemple = scenario.getListeTemple();
           VBoxRoot.().setTemples(listeTemple);
           System.out.println(VBoxRoot.getApprenti());


       }
    }
}