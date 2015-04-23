package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Footer extends JPanel {
    // Instance variables
    private AppFrame view;
    private JLabel scoreLabel;
    private JLabel foodScoreLabel;
    
    // Constructor
    public Footer(AppFrame view) {
        // Initialise components
        this.view = view;
        this.scoreLabel = new JLabel("Score:");
        this.foodScoreLabel = new JLabel("Food score:");
        
        // Set panel properties
        this.setLayout(new GridLayout(0, 2));
        
        // Add components to panel
        this.add(scoreLabel);
        this.add(foodScoreLabel);
    }
}
