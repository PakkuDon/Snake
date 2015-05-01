package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.GameModel;
import model.ScoreRecord;
import model.constants.State;
import view.AppFrame;
import view.HighScoreDialog;
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
                model.getSnake(), model.getFood(), 
                model.getScore(), model.getFoodScore(), 
                model.getGameState());

        // Update view
        view.update(viewModel);

        // If game ended, check if current score is a new record
        if (model.getGameState() == State.INACTIVE) {
            // If score is a new record, prompt user for a name to
            // associate with the score and submit score
            int score = model.getScore();
            if (model.isNewRecord(score)) {
                String name;

                // Prompt user until they enter a name
                // Empty Strings accepted for now
                do {
                    name = JOptionPane.showInputDialog(view, 
                            "You've set a new high score! Please enter a name:");
                    
                    // Display error if no name given
                    if (name == null) {
                        JOptionPane.showMessageDialog(view, 
                                "Name required. Please try again.", 
                                view.getTitle() + " - Error", 
                                JOptionPane.ERROR_MESSAGE);
                    }
                } while (name == null);
                
                // Submit new score
                ScoreRecord newRecord = new ScoreRecord(name, score);
                model.saveScore(newRecord);

                // Display scores
                new HighScoreDialog(view, model);
            }
        }
    }

}
