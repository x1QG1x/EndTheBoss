package virus.endtheboss.Modele.Capacites;

import java.util.ArrayList;
import java.util.List;

import virus.endtheboss.Modele.Archer;
import virus.endtheboss.Modele.Carte;
import virus.endtheboss.Modele.CaseCarte;
import virus.endtheboss.Modele.CaseVide;
import virus.endtheboss.Modele.Formes.FormeCase;
import virus.endtheboss.Modele.Formes.FormeEnCroix;
import virus.endtheboss.Modele.Formes.FormeEnLosange;
import virus.endtheboss.Modele.Personnage;

/**
 * Created by Valentin on 13/02/2016.
 */
public class PluieFleche extends Capacite{
    private Archer sonArcher;

    public PluieFleche(Archer unArcher, Carte uneCarte){
        super(uneCarte);
        this.sonArcher=unArcher;
        this.saPortee=new FormeEnCroix(6);
        this.sonImpact=new FormeEnLosange(3);
    }

    @Override
    public void lancerSort(CaseCarte uneCible) {
        List<Personnage> cibles = new ArrayList<>();
        cibles = laCarte.getPersonnagesDansForme(sonImpact,uneCible);
        for(Personnage p : cibles){
            p.coupPersonnage(sonArcher.getDegatArc()-8);
        }
    }
}