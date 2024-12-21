package modele;

import static org.junit.jupiter.api.Assertions.*;

import modele.Position;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    public void testDeplacementUneCase() {
        Position pos = new Position(5, 5);
        pos.deplacementUneCase(new Position(6, 5));
        assertEquals(new Position(6, 5), pos);

        pos.deplacementUneCase(new Position(6, 6));
        assertEquals(new Position(6, 6), pos);

        pos.deplacementUneCase(new Position(6, 7));
        assertEquals(new Position(5, 5), pos);
    }

    @Test
    public void testEquals() {
        Position pos1 = new Position(5, 5);
        Position pos2 = new Position(5, 5);
        Position pos3 = new Position(6, 6);

        assertTrue(pos1.equals(pos2));
        assertFalse(pos1.equals(pos3));
        assertFalse(pos2.equals(pos3));
    }
}