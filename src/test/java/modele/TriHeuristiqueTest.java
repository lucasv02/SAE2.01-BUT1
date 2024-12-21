package modele;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriHeuristiqueTest {
    private Collection<Temple> temples;
    private ApprentiOrdonnateur apprenti;

    @BeforeEach
    public void setUp() {
        apprenti = new ApprentiOrdonnateur();
        temples = new ArrayList<>();
        // Initialisation des temples avec des coordonnées variées et des couleurs mélangées
        temples.add(new Temple(new Position(-2, -2), 0, 2));  // Temple rouge avec cristal vert
        temples.add(new Temple(new Position(4, 8), 2, 0));   // Temple bleu avec cristal rouge
        temples.add(new Temple(new Position(-10, 20), 1, 1)); // Temple vert avec cristal vert
    }

    @Test
    public void testalignerTemples() {
        setUp();
       // Heuristique.alignerTemples(temples, apprenti);
        System.out.println("Avant réalignement:");
        for (Temple temple : temples) {
            System.out.println("Temple: " + temple.getChCouleur() + " Position: (" + temple.getChPosition() + ") Cristal associé: " + temple.getChCristal());
        }



        System.out.println("Après réalignement:");
        for (Temple temple : temples) {
            System.out.println("Temple: " + temple.getChCouleur() + " Position: (" + temple.getChPosition() + ") Cristal associé: " + temple.getChCristal());
            assertEquals(temple.getChCouleur(), temple.getChCristal());
        }
    }
}