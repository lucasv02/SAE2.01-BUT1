package modele;

import java.util.List;

/**
 * La classe TriBasique contient des méthodes pour réaligner les cristaux
 * dans les temples en utilisant un algorithme de tri basique.
 */
public class TriBasique {

    /**
     * Réaligne les cristaux dans les temples en utilisant un algorithme de tri par sélection.
     * Chaque temple doit avoir un cristal de la même couleur.
     *
     * @param temples  la liste des temples à réaligner
     * @param apprenti l'apprenti ordonnateur qui se déplace pour réaligner les cristaux
     */
    public static void realignerTemples(List<Temple> temples, ApprentiOrdonnateur apprenti) {
        if (temples == null || apprenti == null) {
            throw new IllegalArgumentException("Les temples et l'apprenti ne doivent pas être nuls.");
        }

        int n = temples.size();
        for (int i = 0; i < n; i++) {
            // Trouver le temple qui doit recevoir le cristal correspondant à la couleur actuelle
            Temple correctTemple = trouverTempleParCouleur(temples, i );
            if (correctTemple != null && correctTemple.getChCristal() != correctTemple.getChCouleur()) {
                deplacerCristal(correctTemple, temples.get(i), apprenti);
            }
        }
    }

    /**
     * Trouve un temple par sa couleur.
     *
     * @param temples la liste des temples
     * @param couleur la couleur du temple recherché
     * @return le temple avec la couleur spécifiée, ou null s'il n'existe pas
     */
    private static Temple trouverTempleParCouleur(List<Temple> temples, int couleur) {
        for (Temple temple : temples) {
            if (temple.getChCouleur() == couleur) {
                return temple;
            }
        }
        return null;
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
