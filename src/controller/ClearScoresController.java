package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.GameModel;
import view.HighScoreDialog;

public class ClearScoresController implements ActionListener {
    // Instance variables
    private GameModel model;
    private HighScoreDialog view;
    
    // Constructor
    public ClearScoresController(GameModel model, HighScoreDialog view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // Prompt user for confirmation
        // If user confirms action, delete scores
        int option = JOptionPane.showConfirmDialog(view, 
                "Are you sure to want to clear the scoreboard?\n"
                + "Lost scores cannot be recovered.",
                view.getTitle() + " - Confirmation required",
                JOptionPane.WARNING_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            model.clearScores();
            view.showScores(model.getRecords());
        }
    }
}
