package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Classe Scenario
 * Cette classe permet de stocker les informations du scénario.
 */
public class Scenario {

    // Déclaration des attributs de la classe Scenario
    private Collection <Temple> listeTemple;
    private ApprentiOrdonnateur apprenti;

    /**
     * Constructeur de la classe Scenario
     * Il initialise la liste de temple et l'apprenti en fonction du fichier passé en paramètre.
     * @args : String parFile
     * @return : void
     */
    public Scenario (String parFile) {
        this.listeTemple = new ArrayList<>();
        File fichier = new File ("data" + File.separator + parFile);

        try {
            Scanner scanner = new Scanner(fichier).useDelimiter("\\s+");
            Temple temple;

            while (scanner.hasNext()) {
                int posX = scanner.nextInt();
                int poxY = scanner.nextInt();
                int couleurT = scanner.nextInt();
                int cristal = scanner.nextInt();
                temple = new Temple(new Position(posX, poxY), couleurT, cristal);
                listeTemple.add(temple);
            }
            apprenti = new ApprentiOrdonnateur();
            scanner.close();
        }
        catch (FileNotFoundException parExecption) {
            System.out.println("Fichier introuvable");
        }

    }

    /**
     * Méthode getListeTemple qui permet de récupérer la liste de temple.
     * @args : aucun
     * @return : Collection<Temple> : liste de temple
     */
    public Collection <Temple> getListeTemple() {
        return listeTemple;
    }

    /**
     * Méthode getTemple qui permet de récupérer un temple en fonction de sa couleur.
     * @args : int parCouleur
     * @return : Temple : temple
     */
    public Temple getTemple (int parCouleur) {
        for (Temple temple : listeTemple) {
            if (temple.getChCouleur() == parCouleur) {
                return temple;
            }
        }
        return null;
    }

    /**
     * Méthode getApprenti qui permet de récupérer l'apprenti.
     * @args : aucun
     * @return : ApprentiOrdonnateur : apprenti
     */
    public ApprentiOrdonnateur getApprenti() {
        return apprenti;
    }

    /**
     * Méthode getTemple qui permet de récupérer un temple en fonction de sa position.
     * @args : Position parPosition
     * @return : Temple : temple
     */
    public Temple getTemple (Position parPosition) {
        for (Temple temple : listeTemple) {
            if (temple.getChPosition().equals(parPosition)) {
                return temple;
            }
        }
        return null;
    }

    /**
     * Méthode CristauxRemis qui permet de savoir si les cristaux sont remis.
     * @args : aucun
     * @return : Boolean : true si les cristaux sont remis, false sinon
     */
    public Boolean CristauxRemis () {
        for (Temple temple : listeTemple) {
            if (temple.getChCouleur() != temple.getChCristal()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Méthode getNbRemis qui permet de récupérer le nombre de cristaux remis.
     * @args : aucun
     * @return : int : nombre de cristaux remis
     */
    public int getNbRemis () {
        int nb = 0;
        for (Temple temple : listeTemple) {
            if (temple.getChCouleur() == temple.getChCristal()) {
                nb++;
            }
        }
        return nb;
    }


}

