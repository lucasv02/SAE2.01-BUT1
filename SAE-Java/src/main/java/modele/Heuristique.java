package modele;

import java.util.List;

public class Heuristique {

    public static void realignerTemples(List<Temple> temples, ApprentiOrdonnateur apprenti){
        for(Temple temple : temples){
            if (temple.getChCouleur() != temple.getChCristal()){
                Temple targetTemple = trouverTempleParCouleur(temples,temple.getChCristal());
                deplacerCristal(temple,targetTemple, apprenti);
            }
        }
    }

    private static Temple trouverTempleParCouleur(List<Temple> temples, int couleur) {
        for (Temple temple : temples) {
            if (temple.getChCouleur() == couleur) {
                return temple;
            }
        }
        return null;
    }

    private static void deplacerCristal( Temple source, Temple cible, ApprentiOrdonnateur apprenti) {
        // Déplacement de l'apprenti au temple source
        apprenti.deplacer(source.getChPosition());
        apprenti.setCristalInHand(source.getChCristal());

        // Déplacement de l'apprenti au temple cible
        apprenti.deplacer(cible.getChPosition());
        apprenti.deposerCristal(cible);
    }
}
