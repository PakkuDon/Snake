package view;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {
    // Instance variables
    private AppFrame view;
    private JButton newGameBtn;
    private JButton pauseBtn;
    private JButton showScoresBtn;
    
    // Constructor
    public ToolBar(AppFrame view) {
        // Initialise components
        this.view = view;
        this.newGameBtn = new JButton("New game");
        this.pauseBtn = new JButton("Pause");
        this.showScoresBtn = new JButton("Show scores");
        
        // Disable dragging
        this.setFloatable(false);
        
        // Add components to panel
        this.add(newGameBtn);
        this.add(pauseBtn);
        this.add(showScoresBtn);
    }
}
