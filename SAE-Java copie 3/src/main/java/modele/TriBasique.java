package modele;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe TriBasique contient des méthodes pour réaligner les cristaux
 * dans les temples en utilisant un algorithme de tri basique.
 */
public class TriBasique {

    /**
     * Réaligne les cristaux dans les temples en utilisant un algorithme de tri par sélection.
     *
     * @param temples  la liste des temples à réaligner
     * @param apprenti l'apprenti ordonnateur qui se déplace pour réaligner les cristaux
     */
    public static void realignerTemples(ArrayList <Temple> temples, ApprentiOrdonnateur apprenti) {
        int n = temples.size();
        for (int i = 0; i < n - 1; i++) {
            // Trouver l'index du minimum élément à partir de i
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (temples.get(j).getChCristal() < temples.get(minIdx).getChCristal()) {
                    minIdx = j;
                }
            }
            // Échanger le cristal du temple actuel avec celui du temple à l'index minIdx
            if (minIdx != i) {
                deplacerCristal(temples.get(i), temples.get(minIdx), apprenti);
            }
        }
    }

    /**
     * Déplace un cristal d'un temple source à un temple cible.
     *
     * @param source   le temple source contenant le cristal à déplacer
     * @param cible    le temple cible où le cristal doit être déposé
     * @param apprenti l'apprenti ordonnateur qui effectue les déplacements
     */
    private static void deplacerCristal(Temple source, Temple cible, ApprentiOrdonnateur apprenti) {
        // Déplacement de l'apprenti au temple source
        apprenti.deplacer(source.getChPosition());
        apprenti.setCristalInHand(source.getChCristal());

        // Déplacement de l'apprenti au temple cible
        apprenti.deplacer(cible.getChPosition());
        apprenti.deposerCristal(cible);
    }
}
