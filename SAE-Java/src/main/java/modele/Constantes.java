package modele;

import javafx.scene.paint.Color;

public interface Constantes {

    // Constantes sur la taille de la fenetre de l'application
    final int TAILLE_HAUTEUR = 1350;
    final int TAILLE_LARGEUR = 900;

    // Constantes sur les différents menus
    public final String[] TYPE_MENUS = {
            "Scénario",
            "Parcours",
            "Informations",
            "Mode manuel",
            "Historique"
    };

    // Constatntes sur le canvas

    final int LARGEUR_CANVAS = 800;
    final int HAUTEUR_CANVAS = 800;
    final int CARRE = 25;
    final Color COULEUR_GRILLE = Color.BLACK;

    public final String[] COULEUR = {
            "Rouge",
            "Vert",
            "Bleu",
            "Jaune",
            "Orange",
            "Violet",
            "Rose",
            "Turquoise",
            "Blanc",
            "Noir",
            "Gris",
            "Magenta",
            "Cyan",
            "Marron",
            "Olive",
            "Indigo",
            "Beige",
            "Corail",
            "Or",
            "Argent"
    };

    public final String[] COULEUR_HEX_TEMPLE = {
            "#FF0000",
            "#00FF00",
            "#0000FF",
            "#FFFF00",
            "#FFA500",
            "#800080",
            "#FFC0CB",
            "#40E0D0",
            "#FFFFFF",
            "#000000",
            "#808080",
            "#FF00FF",
            "#00FFFF",
            "#A52A2A",
            "#808000",
            "#4B0082",
            "#F5F5DC",
            "#FF7F50",
            "#FFD700",
            "#C0C0C0"
    };
}

