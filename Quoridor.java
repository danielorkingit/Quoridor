import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Quoridor
{
    Game game;
    
    JFrame frame;
    
    JPanel spielPanel;
    JPanel bedienungPanel;
    
    JButton startButton;
    JButton restartButton;

    JTextField eingabeFeld;
    
    JLabel info;
    
    public Quoridor(){
        
        game = new Game();
        
        frame = new JFrame("Spielfeld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        game.initFeld();
        
        spielPanel = new SpielGUI(game.spielFeld);
        
        bedienungPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        restartButton = new JButton("restart");
        
        startButton = new JButton("start");
        
        eingabeFeld = new JTextField(20);
        
        info = new JLabel(game.labelText);
        
        setActionListeners();
        
        bedienungPanel.add(restartButton);
        bedienungPanel.add(startButton);
        bedienungPanel.add(eingabeFeld);
        bedienungPanel.add(info);

        frame.add(spielPanel, BorderLayout.CENTER);
        frame.add(bedienungPanel , BorderLayout.EAST);
        
        frame.pack();
        frame.setSize(1200,800);
        frame.setVisible(true);  
        
    }
    
    private void setActionListeners(){
        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                game.startGame();
                
                startButton.setVisible(false);
                
                refreshWindow();
            }
        });
        
        eingabeFeld.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    
                    game.makeMove(eingabeFeld.getText());
                                        
                    refreshWindow();
                }
            }
        });
        
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // restart the Game
                
                game.initFeld();
                                
                startButton.setVisible(true);
                
                refreshWindow();
            }
        });
    }

    
    private void refreshWindow(){
        info.setText(game.labelText);
            
        eingabeFeld.setText("");

       frame.repaint();
       frame.revalidate();
    }
}
