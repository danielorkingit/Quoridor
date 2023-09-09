import java.awt.*;
import javax.swing.*;

public class SpielGUI extends JPanel {
    
    private Feld[][] spielFeld;
    
    public SpielGUI(Feld[][] spielFeld) {
        this.spielFeld = spielFeld;
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (int i = 1 ; i < 18 ; i++){
            for (int j = 1; j < 18; j++) {
                    if ((i-1) % 2 == 0){
                        if ((j-1) % 2 == 0){
                            g.setColor(getSquareColor((i-1)/2, (j-1)/2));
                            g.fillRect(40*j-((j/2)*20), 40*i-((i/2)*20), 40, 40);
                            g.setColor(Color.WHITE);
                        } else {
                            g.fillRect(40*j-((j/2)*20)+20, 40*i-((i/2)*20), 20, 40);
                        }
                    }
                    else if ((i-1) % 2 != 0){
                        if ((j-1) % 2 == 0){
                            g.setColor(getSpaceColor((i)/2, (j-1)/2));
                            g.fillRect(40*j-((j/2)*20), 40*i-((i/2)*20)+20, 40, 20);
                            g.setColor(Color.WHITE);
                        }
                    }
                }
        }
    }
    
    private Color getSpaceColor(int i, int j){
        
        Feld feld = spielFeld[i][j];
        
        if (i % 2 != 0){
            if (spielFeld[i-1][j].unten) return Color.YELLOW;
        }
        if (feld.rechts) return Color.YELLOW;
        
        return Color.WHITE;
    }
    
    private Color getSquareColor(int i, int j){
        
        Feld feld = spielFeld[i][j];
        
        if (feld.spieler != null){
            if (feld.spieler.id == 0) return Color.GREEN;
            else return Color.RED;
        }
        
        return new Color(102,102,102);
    }
}
