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
    private Direction direction;
    
    // Constructor
    public SetDirectionController(GameModel model, Direction direction) {
        this.model = model;
        this.direction = direction;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Set snake direction and move forward
        model.setSnakeDirection(direction);
    }
}
