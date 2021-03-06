package virus.endtheboss.Modele.Formes;

import java.util.ArrayList;
import java.util.List;

import virus.endtheboss.Enumerations.GameValues;
import virus.endtheboss.Modele.CaseCarte;
import virus.endtheboss.Modele.CaseVide;

/**
 * Created by Quentin Gangler on 13/02/2016.
 *
 */
public class FormeTous extends Forme {

    public FormeTous(){
        super(0);
    }

    @Override
    public List<CaseCarte> getForme(CaseCarte origine) {
        List<CaseCarte> forme = new ArrayList<>();
        for(int x = 0; x < GameValues.nbHorTile;x++){
            for (int y = 0; y < GameValues.nbVerTile; y++){
                forme.add(new CaseVide(x,y));
            }
        }
        return forme;
    }
}
