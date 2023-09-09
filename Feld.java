
/**
 * Write a description of class Feld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Feld
{
    public int x;
    public int y;

    public boolean oben = false;
    public boolean unten = false;
    public boolean links = false;
    public boolean rechts = false;

    public Spieler spieler;
    public boolean besetzt = false;
    
    public Feld(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setzeSpieler(Spieler s){
        boolean besetzt = true;
        this.spieler = s;
    }
    
    public void entferneSpieler(){
        boolean besetzt = false;
        this.spieler = null;
    }
}
