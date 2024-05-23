package vue;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.Constantes;
import modele.Historique;
import modele.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VBoxMenu extends VBox implements Constantes {

    private static MenuBar menuBar;

    private static Menu menuSce;
    private static Menu menuInf;
    private static Menu menuPar;
    private static Menu menuMan;
    private static Menu menuHis;

    private static ComBoxFile listefichiers;

    private static StackPane carrousel;

    private static TableView <Historique> tableHistorique;

    public VBoxMenu() {

        menuBar = new MenuBar();
        menuSce = new Menu(TYPE_MENUS[0]);
        menuInf = new Menu(TYPE_MENUS[1]);
        menuPar = new Menu(TYPE_MENUS[2]);
        menuMan = new Menu(TYPE_MENUS[3]);
        menuHis = new Menu(TYPE_MENUS[4]);

        menuBar.getMenus().addAll(menuSce, menuInf, menuPar, menuMan, menuHis);
        this.getChildren().add(menuBar);
        VBoxMenu.setMargin(menuBar, new Insets(30));

        tableHistorique = new TableView<Historique>();
        TableColumn <Historique, Position> postionColumn = new TableColumn<>("Position");
        TableColumn <Historique, String> stringColumn = new TableColumn<>("Descriptions");
        TableColumn <Historique, Integer> intColumn = new TableColumn<>("Cristal");

        postionColumn.setCellValueFactory(new PropertyValueFactory<>("chPosition"));
        stringColumn.setCellValueFactory(new PropertyValueFactory<>("chString"));
        intColumn.setCellValueFactory(new PropertyValueFactory<>("chCristaux"));

        postionColumn.setPrefWidth(100);
        stringColumn.setPrefWidth(200);
        intColumn.setPrefWidth(100);
        tableHistorique.getColumns().add(postionColumn);
        tableHistorique.getColumns().add(stringColumn);
        tableHistorique.getColumns().add(intColumn);

        this.getChildren().add(tableHistorique);
        VBoxMenu.setMargin(tableHistorique, new Insets(30));
    }
}
