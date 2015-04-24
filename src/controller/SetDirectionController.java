package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Direction;
import model.GameModel;
import view.AppFrame;
import view.model.GameViewModel;

public class SetDirectionController extends AbstractAction {
    // Instance variables
    private GameModel model;
    private AppFrame view;
    private Direction direction;
    
    // Constructor
    public SetDirectionController(GameModel model, AppFrame view, 
            Direction direction) {
        this.model = model;
        this.view = view;
        this.direction = direction;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Set snake direction and move forward
        model.setSnakeDirection(direction);
        model.move();
        
        // Generate view model from model data
        GameViewModel viewModel = new GameViewModel(
                model.getWidth(), model.getHeight(),
                model.getSnake(), model.getFood().getPoint(), 
                model.getScore(), model.getFood().getScore(), 
                model.isRunning());
        
        // Update view
        view.update(viewModel);
    }
}
