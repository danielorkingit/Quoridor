
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    String labelText = "Willkommen"; 
    
    Spieler aktuellerSpieler;
    
    public Feld[][] spielFeld = new Feld[9][9];
    
    public Spieler[] spieler = new Spieler[2];
    
    public Game(){
        spieler[0] = new Spieler(0);
        spieler[1] = new Spieler(1);
        
        initFeld();
    }
        
    public void makeMove(String input){
        
        String[] parts = input.split(" ");
            
        String action = parts[0];
            
        if (action.equals("B")){
                
            int faktor = 1;
                
            String direction = parts[1];
                
            Feld aktuellesFeld = aktuellerSpieler.getFeld();
                
            if (direction.equals("u")){                    
                
                if (!aktuellesFeld.oben && aktuellesFeld.x != 0){
                    
                    if (spielFeld[aktuellesFeld.x-1][aktuellesFeld.y].spieler != null){
                        if (!spielFeld[aktuellesFeld.x-1][aktuellesFeld.y].oben && aktuellesFeld.x-1 != 0){
                            faktor = 2;
                        } else {
                            labelText = "Falsche eingabe, versuche es erneut Spieler " + aktuellerSpieler.id;
                            return;
                        }
                    }
                    aktuellesFeld.entferneSpieler();
                    spielFeld[aktuellesFeld.x-1*faktor][aktuellesFeld.y].setzeSpieler(aktuellerSpieler);
                    aktuellerSpieler.setFeld(spielFeld[aktuellesFeld.x-1*faktor][aktuellesFeld.y]);
                    naechsterSpieler();
                    return;   
                }
            } else if (direction.equals("d")){
                    
                if (!aktuellesFeld.unten && aktuellesFeld.x != 8){
                    if (spielFeld[aktuellesFeld.x+1][aktuellesFeld.y].spieler != null){
                        if (!spielFeld[aktuellesFeld.x+1][aktuellesFeld.y].unten && aktuellesFeld.x+1 != 0){
                            faktor = 2;
                        } else {
                            labelText = "Falsche eingabe, versuche es erneut Spieler " + aktuellerSpieler.id;
                            return;
                        }
                    } 
                    aktuellesFeld.entferneSpieler();
                    spielFeld[aktuellesFeld.x+1*faktor][aktuellesFeld.y].setzeSpieler(aktuellerSpieler);
                    aktuellerSpieler.setFeld(spielFeld[aktuellesFeld.x+1*faktor][aktuellesFeld.y]);
                    naechsterSpieler();
                    return;
                } 
            } else if (direction.equals("l")){
                    
                if (!aktuellesFeld.links && aktuellesFeld.y % 9 != 0){
                    if (spielFeld[aktuellesFeld.x][aktuellesFeld.y-1].spieler != null){
                        if (!spielFeld[aktuellesFeld.x][aktuellesFeld.y-1].links && (aktuellesFeld.y-1)% 9 != 0){
                            faktor = 2;
                        } else {
                            labelText = "Falsche eingabe, versuche es erneut Spieler " + aktuellerSpieler.id;
                            return;
                        }
                    } 
                    aktuellesFeld.entferneSpieler();
                    spielFeld[aktuellesFeld.x][aktuellesFeld.y-1*faktor].setzeSpieler(aktuellerSpieler);
                    aktuellerSpieler.setFeld(spielFeld[aktuellesFeld.x][aktuellesFeld.y-1*faktor]);
                    naechsterSpieler();
                    return;
                } 
                    
            } else if (direction.equals("r")){
                    
                if (!aktuellesFeld.rechts && aktuellesFeld.y % 8 != 0){
                    if (spielFeld[aktuellesFeld.x][aktuellesFeld.y+1].spieler != null){
                        if (!spielFeld[aktuellesFeld.x][aktuellesFeld.y+1].links && (aktuellesFeld.y+1)% 8 != 0){
                            faktor = 2;
                        } else {
                            labelText = "Falsche eingabe, versuche es erneut Spieler " + aktuellerSpieler.id;
                            return;
                        }
                    } 
                    aktuellesFeld.entferneSpieler();
                    spielFeld[aktuellesFeld.x][aktuellesFeld.y+1*faktor].setzeSpieler(aktuellerSpieler);
                    aktuellerSpieler.setFeld(spielFeld[aktuellesFeld.x][aktuellesFeld.y+1*faktor]);
                    naechsterSpieler();
                    return;
                } 
            }  
        } else if (action.equals("W")){
            
            if (parts.length == 4 && aktuellerSpieler.mauern != 0){
                    
                int x = Integer.valueOf(parts[1]);
                int y = Integer.valueOf(parts[2]);
                
                String firstDirection = parts[3];
                
                String secondDirection = parts[4];
                    
                if (firstDirection.equals("d")){
                    try{
                        if (!spielFeld[x][y].unten){
                            spielFeld[x][y].unten = true;
                            aktuellerSpieler.mauern -= 1;
                            try{
                               spielFeld[x+1][y].oben = true;
                            } catch (Exception e){}
                            try{
                                spielFeld[x][y+1].links = true;
                            } catch (Exception e){}
                            try{
                               spielFeld[x][y-1].rechts = true;
                            } catch (Exception e){}
                            naechsterSpieler();
                            return;
                        }
                    } catch (Exception e){}
                } else if (firstDirection.equals("u")){
                    if (!spielFeld[x][y].oben){
                        spielFeld[x][y].oben = true;
                        aktuellerSpieler.mauern -= 1;
                        try{
                            spielFeld[x+1][y].unten = true;
                        } catch (Exception e){}
                        naechsterSpieler();
                        return;
                    }
                } else if (firstDirection.equals("l")){
                    if (!spielFeld[x][y].links){
                        spielFeld[x][y].links = true;
                        aktuellerSpieler.mauern -= 1;
                        try{
                           spielFeld[x][y].unten = true;
                        } catch (Exception e){}
                        try{
                           spielFeld[x][y].links = true;
                        } catch (Exception e){}
                        try{
                           spielFeld[x][y-1].rechts = true;
                        } catch (Exception e){}
                        naechsterSpieler();
                        return;
                    }
                } else if (firstDirection.equals("u")){
                    
                }
            } 
        }
        labelText = "Falsche eingabe, versuche es erneut Spieler " + aktuellerSpieler.id;
    }
    
    private void naechsterSpieler(){
        if (aktuellerSpieler.id == 0) aktuellerSpieler = spieler[1];
        else aktuellerSpieler = spieler[0];
                
        labelText = "Spieler " + aktuellerSpieler.id + " ist dran.";
    }
    
    public void startGame(){
        
        initFeld();
        
        aktuellerSpieler = spieler[0];
        
        labelText = "Spieler " + aktuellerSpieler.id + " ist dran.";
        
    }

    public void initFeld(){
                
        for (int i = 0 ; i < 9 ; i++){
            for (int j = 0 ; j < 9 ; j++){
                spielFeld[i][j] = new Feld(i,j);
            }
        }
                        
        spielFeld[0][4].setzeSpieler(spieler[0]);
        spielFeld[8][4].setzeSpieler(spieler[1]);
        
        spieler[0].setFeld(spielFeld[0][4]);
        spieler[1].setFeld(spielFeld[8][4]);
        
        labelText = "Willkommen";
    }
}
