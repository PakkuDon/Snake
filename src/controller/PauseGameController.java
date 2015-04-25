package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;

import model.GameModel;
import model.State;
import view.AppFrame;

public class PauseGameController extends AbstractAction {
    // Instance variables
    private GameModel model;
    private AppFrame view;
    
    // Constructor
    public PauseGameController(GameModel model, AppFrame view) {
        this.model = model;
        this.view = view;
    }
    
    public void actionPerformed(ActionEvent e) {
        // If game not in an inactive / dead state, toggle pause status
        State state = model.getGameState();
        if (state != State.INACTIVE) {
            boolean pauseFlag = state != State.PAUSED;
            model.setPaused(pauseFlag);
            view.setPaused(pauseFlag);
        }
    }
}
