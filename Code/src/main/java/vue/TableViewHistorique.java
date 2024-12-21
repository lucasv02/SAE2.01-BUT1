package vue;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Historique;
import modele.Position;

/**
 * Classe TableViewHistorique
 * Cette classe permet de stocker graphiquement les informations de l'historique.
 */
public class TableViewHistorique extends TableView {

    /**
     * Constructeur de la classe TableViewHistorique
     * Il initialise les colonnes de la TableView.
     */
    public TableViewHistorique() {

        TableColumn<Historique, Position> postionColumn = new TableColumn<>("Position");
        TableColumn <Historique, String> stringColumn = new TableColumn<>("Descriptions");
        TableColumn <Historique, Integer> intColumn = new TableColumn<>("Cristal");

        postionColumn.setCellValueFactory(new PropertyValueFactory<>("chPosition"));
        stringColumn.setCellValueFactory(new PropertyValueFactory<>("chString"));
        intColumn.setCellValueFactory(new PropertyValueFactory<>("chCristaux"));

        postionColumn.setPrefWidth(100);
        stringColumn.setPrefWidth(200);
        intColumn.setPrefWidth(100);
        this.getColumns().add(postionColumn);
        this.getColumns().add(stringColumn);
        this.getColumns().add(intColumn);
    }


}
