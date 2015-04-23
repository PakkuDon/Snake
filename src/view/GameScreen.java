package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
    // Instance variables
    private AppFrame view;
    
    // Constructor
    public GameScreen(AppFrame view) {
        this.view = view;
    }

    @Override
    public void paintComponent(Graphics g) {
        // Clear screen
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        // Draw snake
        
        // Draw food
    }
}
