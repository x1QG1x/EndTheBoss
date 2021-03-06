package virus.endtheboss.Modele.Capacites.Archer;

import android.util.Log;

import java.util.Random;

import virus.endtheboss.Modele.Personnages.Archer;
import virus.endtheboss.Modele.Capacites.Capacite;
import virus.endtheboss.Modele.Carte;
import virus.endtheboss.Modele.CaseCarte;
import virus.endtheboss.Modele.Formes.FormeCase;
import virus.endtheboss.Modele.Formes.FormeEnLosange;
import virus.endtheboss.Modele.Personnages.Personnage;

/**
 * Cette capacité est le tir à l'arc de l'archer.
 * Created by Valentin on 13/02/2016.
 */
public class TirArc extends Capacite {

    private Archer sonArcher;

    public TirArc(Archer unArcher, Carte uneCarte){
        super(uneCarte, "Tir au boss", new FormeEnLosange(15), new FormeCase());
        this.sonArcher=unArcher;
    }

    @Override
    public void lancerSort(CaseCarte uneCible) {
        Personnage cible = null;
        if(uneCible instanceof Personnage){
            cible = (Personnage) uneCible;
        }
        Random r = new Random();
        int tentative = r.nextInt(100) + 1;
        Log.i("Tir arc", "Tentative : " + tentative + " (Chance Contact " + sonArcher.getChanceContact() + ") " + cible);
        if(tentative < sonArcher.getChanceContact() && cible != null){
            Log.i("Tir Arc", "Touché");
            cible.coupPersonnage(sonArcher.getSesDegatDeBase()+5);

            if(sonArcher.getChanceContact()<100){
                sonArcher.setChanceContact(sonArcher.getChanceContact()+4);
            }else{
                sonArcher.setChanceContact(100);
            }

            Log.i("Tir Arc", "Chance Contact : " + sonArcher.getChanceContact());

            if(sonArcher.getSesDegatDeBase()<75){
                sonArcher.setSesDegatDeBase(sonArcher.getSesDegatDeBase()+4);
            }

            Log.i("Tir Arc", "Degat Arc : " + sonArcher.getSesDegatDeBase());
        }
    }
}
