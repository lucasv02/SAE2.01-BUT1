package modele;

import vue.HBoxApp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TriBasique {

    public TriBasique(Scenario ParScenario){
        getTemplesParcours(ParScenario);
    }



    public Boolean checkCristalTemple (Scenario parScenario, int parCouleur){
        Temple temple = parScenario.getTemple(parCouleur);
        if (temple.getChCouleur() != temple.getChCristal()) {
            return false;
        }
        else {
            return true;
        }
    }


    public void getTemplesParcours (Scenario parScenario){
        for (int i = 0; i < parScenario.getListeTemple().size(); i++){
            if (!checkCristalTemple(parScenario, i)) {
                Temple templeinitial = parScenario.getTemple(i);
                HBoxApp.getControleur().deplacement(templeinitial.getChPosition());
                Temple templedestination = parScenario.getTemple(parScenario.getApprenti().getCristalInHand());
                HBoxApp.getControleur().deplacement(templedestination.getChPosition());
                HBoxApp.getControleur().deplacement(templeinitial.getChPosition());

            }
        }
    }


/*
    public static void realignerTemples(Collection<Temple> temples, ApprentiOrdonnateur apprenti) {
        if (temples == null || apprenti == null) {
            throw new IllegalArgumentException("Les temples et l'apprenti ne doivent pas être nuls.");
        }

        List<Temple> templeList = new ArrayList<>(temples);

        boolean realigned;
        do {
            realigned = false;
            for (Temple temple : templeList) {
                if (temple.getChCouleur() != temple.getChCristal()) {
                    Temple targetTemple = getTempleParCouleur(templeL, temple.getChCouleur());
                    if (targetTemple != null) {
                        echangerCristaux(temple, targetTemple, apprenti);
                        realigned = true;
                    }
                }
            }
        } while (realigned);
    }

 //   public Temple trouverTempleParCouleur(List<Temple> temples, Temple currentTemple) {
  //      for (Temple temple : temples) {

    //        if (temple.getChCouleur() == currentTemple.getChCristal() && temple.getChCristal() != temple.getChCouleur()) {
      //          return temple;
          //  }
        //}
        // return null;




    private static void echangerCristaux(Temple source, Temple cible, ApprentiOrdonnateur apprenti) {
        HBoxApp.getControleur().deplacement(source.getChPosition());
        apprenti.setCristalInHand(source.getChCristal());

        HBoxApp.getControleur().deplacement(cible.getChPosition());
        int cristalTemp = cible.getChCristal();
        cible.setChCristal(apprenti.getCristalInHand());
        apprenti.setCristalInHand(cristalTemp);
        apprenti.deposerCristal(source);

        System.out.println("Échange de cristaux effectué:");
        System.out.println("Source: Temple position: " + source.getChPosition() + ", Cristal après échange: " + source.getChCristal());
        System.out.println("Cible: Temple position: " + cible.getChPosition() + ", Cristal après échange: " + cible.getChCristal());
        System.out.println("Apprenti position actuelle: " + apprenti.getPositionApprenti());
    }

  */
}
