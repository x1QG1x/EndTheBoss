package virus.endtheboss.Enumerations;

import java.io.Serializable;

/**
 * Created by Quentin Gangler on 11/02/2016.
 * Donne des constantes utiles pour le jeu
 */
public class GameValues implements Serializable{
    public static int WIDTH = 0;
    public static int HEIGHT = 0;

    public static int nbHorTile = 20;
    public static int nbVerTile = 20;

    public static float tileHeight = HEIGHT/nbHorTile;
    public static float tileWidth = WIDTH/nbVerTile;

    public static void updateSurface(int WIDTH, int HEIGHT){
        GameValues.HEIGHT = HEIGHT;
        GameValues.WIDTH = WIDTH;

        tileHeight = GameValues.HEIGHT/nbHorTile;
        tileWidth = GameValues.WIDTH/nbVerTile;
    }
}
