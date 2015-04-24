package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import model.Direction;
import model.GameModel;
import view.model.GameViewModel;
import controller.GameTickController;
import controller.SetDirectionController;

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
        this.setKeyBindings(model);

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

        // Bind named inputs to event handlers
        actionMap.put(Direction.NORTH.getKey(), 
                new SetDirectionController(model, Direction.NORTH));
        actionMap.put(Direction.EAST.getKey(),
                new SetDirectionController(model, Direction.EAST));
        actionMap.put(Direction.SOUTH.getKey(),
                new SetDirectionController(model, Direction.SOUTH));
        actionMap.put(Direction.WEST.getKey(), 
                new SetDirectionController(model, Direction.WEST));
    }
}
