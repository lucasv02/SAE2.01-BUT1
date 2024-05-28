package vue;

import javafx.scene.control.ComboBox;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ComBoxFile {

    private ComboBox<String> comboBox;

    public ComBoxFile() {
        comboBox = new ComboBox<>();
        AjoutFiles();
    }

    private void AjoutFiles() {

        File dossier = new File("data");
        File [] listefichier = dossier.listFiles();
        List <String> nomfichier = new ArrayList<>();
        if (listefichier != null) {
            for (File file : listefichier) {
                if (file.isFile()) {
                    nomfichier.add(file.getName());
                }
            }
            Collections.sort(nomfichier);
            comboBox.getItems().addAll(nomfichier);
            comboBox.setValue(nomfichier.get(0));
        }
    }

    public ComboBox<String> getComboBox() {
        return comboBox;
    }

    public void UpdateFiles() {
        comboBox = new ComboBox<>();
        AjoutFiles();
    }

}