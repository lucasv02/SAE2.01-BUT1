package modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vue.HBoxApp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriSelectionTest {

    private TriSelection triSelection;
    private ApprentiOrdonnateur apprenti;
    private Temple temple1;
    private Temple temple2;
    private Temple temple3;

    @BeforeEach
    public void setUp() {
        apprenti = new ApprentiOrdonnateur();

        temple1 = new Temple(new Position(1, 1), 1, 2); // Temple rouge avec cristal bleu
        temple2 = new Temple(new Position(2, 2), 2, 3); // Temple bleu avec cristal vert
        temple3 = new Temple(new Position(3, 3), 3, 1); // Temple vert avec cristal rouge

        Collection<Temple> temples = new ArrayList<>();
        temples.add(temple1);
        temples.add(temple2);
        temples.add(temple3);

        triSelection = new TriSelection(temples);
    }

    @Test
    public void testUpdatePosition() {
        triSelection.updatePosition();

        assertEquals(3, triSelection.templesRestant.size());
        assertEquals(temple1, triSelection.templesRestant.get(1));
        assertEquals(temple2, triSelection.templesRestant.get(2));
        assertEquals(temple3, triSelection.templesRestant.get(3));
    }

    @Test
    public void testEtapeSuivante() {
        assertEquals(0, triSelection.getEtape());
        triSelection.EtapeSuivante();
        assertEquals(1, triSelection.getEtape());
    }

    @Test
    public void testDeplacement() {
        triSelection.updatePosition();
        triSelection.deplacement();
        assertEquals(1, triSelection.getEtape());

        triSelection.deplacement();
        assertEquals(2, triSelection.getEtape());

        triSelection.deplacement();
        assertEquals(3, triSelection.getEtape());
    }
}
