package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameModel;
import view.AppFrame;
import view.model.GameViewModel;

public class GameTickController implements ActionListener {
    // Instance variables
    private GameModel model;
    private AppFrame view;
    
    // Constructor
    public GameTickController(GameModel model, AppFrame view) {
        this.model = model;
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Update model
        model.move();
        
        // Generate view model from model data
        GameViewModel viewModel = new GameViewModel(
                model.getWidth(), model.getHeight(),
                model.getSnake(), model.getFood().getPoint(), 
                model.getScore(), model.getFood().getScore(), 
                model.getGameState());
        
        // Update view
        view.update(viewModel);
    }
    
}
