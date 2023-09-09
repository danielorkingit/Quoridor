
/**
 * Write a description of class Spieler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spieler
{
    public String name;
    public int id;
    
    private Feld feld;
    
    public int mauern = 5;
    
    public Spieler(int id){
        this.id = id;
    }
    
    public Feld getFeld(){
        return feld;
    }
    
    public void setFeld(Feld feld){
        this.feld = feld;
    }
}
