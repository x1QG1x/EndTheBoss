package virus.endtheboss.Modele.Capacites.Archer;

import android.util.Log;

import java.util.List;

import virus.endtheboss.Modele.Personnages.Archer;
import virus.endtheboss.Modele.Capacites.Capacite;
import virus.endtheboss.Modele.Carte;
import virus.endtheboss.Modele.CaseCarte;
import virus.endtheboss.Modele.Formes.FormeEnCroix;
import virus.endtheboss.Modele.Formes.FormeEnLosangeAvecOrigine;
import virus.endtheboss.Modele.Personnages.Personnage;

/**
 * Created by Valentin on 13/02/2016.
 * Capacite pluie de Fleches pour l'archer
 */
public class PluieFleche extends Capacite {
    private Archer sonArcher;

    public PluieFleche(Archer unArcher, Carte uneCarte){
        super(uneCarte, "Pluie de piquants",new FormeEnCroix(6), new FormeEnLosangeAvecOrigine(3));
        this.sonArcher=unArcher;
    }

    @Override
    public void lancerSort(CaseCarte uneCible) {
        List<Personnage> cibles = laCarte.getPersonnagesDansForme(sonImpact,uneCible);
        for(Personnage p : cibles){
            Log.i("Pluie Fleche", "Touché enemmi : " + p.getSonNom());
            p.coupPersonnage(sonArcher.getSesDegatDeBase()-3);
        }
    }
}
