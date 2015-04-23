package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.Timer;

import model.GameModel;
import view.model.GameViewModel;
import controller.GameTickController;

public class AppFrame extends JFrame {
    // Instance variables
    private GameModel model;
    private ToolBar toolBar;
    private GameScreen screen;
    private Footer footer;
    private Timer timer;
    
    // Constructor
    public AppFrame(GameModel model) {
        // Initialise components
        this.model = model;
        this.toolBar = new ToolBar(model, this);
        this.screen = new GameScreen(this);
        this.footer = new Footer(this);
        this.timer = new Timer(100, new GameTickController(model, this));
        
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
    
    public void start() {
        timer.start();
    }
    
    public void update(GameViewModel viewModel) {
        if (!viewModel.isRunning()) {
            timer.stop();
        }
        screen.update(viewModel);
        footer.update(viewModel);
    }
}
