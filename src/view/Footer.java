package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.model.GameViewModel;

@SuppressWarnings("serial")
public class Footer extends JPanel {
    // Instance variables
    private JLabel scoreLabel;
    private JLabel foodScoreLabel;
    
    // Constructor
    public Footer() {
        // Initialise components
        this.scoreLabel = new JLabel("Score:");
        this.foodScoreLabel = new JLabel("Food score:");
        
        // Set panel properties
        this.setLayout(new GridLayout(0, 2));
        
        // Add components to panel
        this.add(scoreLabel);
        this.add(foodScoreLabel);
    }
    
    public void update(GameViewModel viewModel) {
        scoreLabel.setText("Score: " + viewModel.getScore());
        foodScoreLabel.setText("Food score: " + viewModel.getFoodScore());
    }
}
