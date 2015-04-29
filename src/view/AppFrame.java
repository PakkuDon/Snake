package view;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import model.Direction;
import model.GameModel;
import model.State;
import view.model.GameViewModel;
import controller.GameTickController;
import controller.PauseGameController;
import controller.SetDirectionController;

@SuppressWarnings("serial")
public class AppFrame extends JFrame {
    // Instance variables
    private ToolBar toolBar;
    private GameScreen screen;
    private Footer footer;
    private Timer timer;

    // Constructor
    public AppFrame(GameModel model) {
        // Initialise components
        this.toolBar = new ToolBar(model, this);
        this.screen = new GameScreen();
        this.footer = new Footer();
        this.timer = new Timer(100, new GameTickController(model, this));

        // Set frame properties
        this.setTitle("Snake");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setKeyBindings(model);
        this.setLocationByPlatform(true);

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
        if (viewModel.getState() != State.RUNNING) {
            timer.stop();
        }
        screen.update(viewModel);
        footer.update(viewModel);
    }
    
    public void setPaused(boolean pauseFlag) {
        if (pauseFlag) {
            timer.stop();
        }
        else {
            timer.start();
        }
        
        // Update view to accommodate for pause status
        toolBar.setPauseText(pauseFlag);
    }
    
    private void setKeyBindings(GameModel model) {
        // Retrieve mappings for frame
        InputMap inputMap = ((JComponent)this.getContentPane()).
                getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = ((JComponent)this.getContentPane()).getActionMap();

        // Set input keystrokes and associated names
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), 
                Direction.NORTH.getKey());
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), 
                Direction.EAST.getKey());
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), 
                Direction.SOUTH.getKey());
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), 
                Direction.WEST.getKey());
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "pause");

        // Bind named inputs to event handlers
        actionMap.put(Direction.NORTH.getKey(), 
                new SetDirectionController(model, this, Direction.NORTH));
        actionMap.put(Direction.EAST.getKey(),
                new SetDirectionController(model, this, Direction.EAST));
        actionMap.put(Direction.SOUTH.getKey(),
                new SetDirectionController(model, this, Direction.SOUTH));
        actionMap.put(Direction.WEST.getKey(), 
                new SetDirectionController(model, this, Direction.WEST));
        actionMap.put("pause", new PauseGameController(model, this));
    }
}
