package view;

import javax.swing.JButton;
import javax.swing.JToolBar;

import model.GameModel;
import controller.NewGameController;
import controller.PauseGameController;

public class ToolBar extends JToolBar {
    // Instance variables
    private AppFrame view;
    private JButton newGameBtn;
    private JButton pauseBtn;
    private JButton showScoresBtn;
    
    // Constructor
    public ToolBar(GameModel model, AppFrame view) {
        // Initialise components
        this.view = view;
        this.newGameBtn = new JButton("New game");
        this.pauseBtn = new JButton("Pause");
        this.showScoresBtn = new JButton("Show scores");
        
        // Register event handlers
        newGameBtn.addActionListener(new NewGameController(model, view));
        pauseBtn.addActionListener(new PauseGameController(model, view));
        
        // Disable dragging
        this.setFloatable(false);
        
        // Make components non-focusable so that key-bindings can work
        this.setFocusable(false);
        newGameBtn.setFocusable(false);
        pauseBtn.setFocusable(false);
        showScoresBtn.setFocusable(false);
        
        // Add components to panel
        this.add(newGameBtn);
        this.add(pauseBtn);
        this.add(showScoresBtn);
    }
    
    public void setPauseText(boolean isPaused) {
        if (isPaused) {
            pauseBtn.setText("Unpause");
        }
        else {
            pauseBtn.setText("Pause");
        }
    }
}
