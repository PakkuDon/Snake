package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameModel;
import view.AppFrame;
import view.HighScoreDialog;

public class ShowScoresController implements ActionListener {
    // Instance variables
    private GameModel model;
    private AppFrame view;
    
    // Constructor
    public ShowScoresController(GameModel model, AppFrame view) {
        this.model = model;
        this.view = view;
    }
    
    @Override
    // Display high scores
    public void actionPerformed(ActionEvent e) {
        new HighScoreDialog(view, model);
    }
}
