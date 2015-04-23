package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.GameModel;

public class AppFrame extends JFrame {
    // Instance variables
    private GameModel model;
    private ToolBar toolBar;
    private GameScreen screen;
    private Footer footer;
    
    // Constructor
    public AppFrame(GameModel model) {
        // Initialise components
        this.model = model;
        this.toolBar = new ToolBar(this);
        this.screen = new GameScreen(this);
        this.footer = new Footer(this);
        
        // Set frame properties
        this.setTitle("Snake");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add components to frame
        this.add(toolBar, BorderLayout.NORTH);
        this.add(screen, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        
        // Show frame
        this.setVisible(true);
    }
}
