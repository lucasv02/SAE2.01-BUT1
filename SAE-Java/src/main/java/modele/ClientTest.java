package modele;

import java.util.Collection;

public class ClientTest {

    public static void main (String[] args) {
        Collection <Temple> liste = new Scenario("scenario0.txt").getListeTemple();
        System.out.println(liste);

    }
}
