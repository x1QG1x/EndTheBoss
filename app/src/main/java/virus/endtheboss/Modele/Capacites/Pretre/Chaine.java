package virus.endtheboss.Modele.Capacites.Pretre;

import java.util.Random;

import virus.endtheboss.Modele.Capacites.Capacite;
import virus.endtheboss.Modele.Carte;
import virus.endtheboss.Modele.CaseCarte;
import virus.endtheboss.Modele.Formes.FormeCase;
import virus.endtheboss.Modele.Formes.FormeCroixAvecOrigine;
import virus.endtheboss.Modele.Personnage;
import virus.endtheboss.Modele.Support;

/**
 * Created by Valentin on 16/02/2016.
 */
public class Chaine extends Capacite {
    private Support sonSupport;

    public Chaine(Support unSupport, Carte uneCarte){
        super(uneCarte, "Vinculum", new FormeCroixAvecOrigine(3), new FormeCase());
        this.sonSupport = unSupport;
    }
    @Override
    public void lancerSort(CaseCarte uneCible) {
        Personnage cible = null;
        if(uneCible instanceof Personnage){
            cible = (Personnage) uneCible;
            Random rand = new Random();
            int aleatoire=rand.nextInt(100)+1;
            if(aleatoire<=60){
                if (aleatoire<=45){
                    cible.soignerPersonnage(3);
                }else{
                    cible.coupPersonnageSansArmure(1); //Pass Armor
                }
                cible.setSesDegatDeBase(cible.getSesDegatDeBase()+1);
                this.lancerSort(uneCible);
            }else{
                if (aleatoire<=65){
                    cible.soignerPersonnage(10);
                    cible.setSesDegatDeBase(cible.getSesDegatDeBase()+2);
                }else if(aleatoire <= 70){
                    cible.coupPersonnageSansArmure(5); //Pass Armor
                    cible.setSaResistance(cible.getSaResistance()+1);
                }else{
                    cible.soignerPersonnage(1);
                }
            }
        }
    }
}
