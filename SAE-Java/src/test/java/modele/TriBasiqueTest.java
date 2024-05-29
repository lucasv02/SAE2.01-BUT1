package modele;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriBasiqueTest {
    private List<Temple> temple;
    private ApprentiOrdonnateur apprenti;

    public List<Temple> setUp() {
        apprenti = new ApprentiOrdonnateur();
        temple = new ArrayList<Temple>();
        temple.add(new Temple(new Position(2,2), 2, 1));  // Temple bleu avec cristal vert
        temple.add(new Temple(new Position(4,8), 0, 2));  // Temple rouge avec cristal bleu
        temple.add(new Temple(new Position(9,10), 1, 0));// Temple vert avec cristal rouge
        return temple;
    }
@Test
    public void testRealignerTemples() {
        setUp();
        TriBasique.realignerTemples(temple, apprenti);
        System.out.println(temple);
        // Vérification des résultats après réalignement
        for (Temple temple : temple) {
            assertEquals(temple.getChCouleur(), temple.getChCristal());

        }
    }
}
