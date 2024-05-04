package modele;

public interface ConstantesErreur {

    public final String [] ERREURS_JOUEURS = {
            "Déplacement hors champ",
            "Déplacement non autorisée"

    };

    public final String [] ERREURS_TEMPLE = {
            "Ce temple est déja inscrit dans la base des temples",
            "La base ne trouvent pas votre temple"
    };

    public final String [] ERREURS_CRISTAUX = {
            "Ce cristal est déjà dans notre base des cristaux",
            "Le cristal demandée n'est pas présent dans la base des cristaux"
    };

}

