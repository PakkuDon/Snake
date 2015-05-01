package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameModel;
import view.AppFrame;

public class NewGameController implements ActionListener {
    // Instance variables
    private GameModel model;
    private AppFrame view;
    
    // Constructor
    public NewGameController(GameModel model, AppFrame view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Initialise game properties and start timer
        model.start();
        view.start();
    }
}
