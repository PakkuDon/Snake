package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.ScoreRecord;

public class HighScoreDialog {
    // Constructor
    public HighScoreDialog(AppFrame view, ScoreRecord[] records) {
        // Construct container to hold scores
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(0, 3));
        
        // Add headings
        scorePanel.add(new JLabel("Rank"));
        scorePanel.add(new JLabel("Player"));
        scorePanel.add(new JLabel("Score"));
        
        // Add records
        for (int i = 0; i < records.length; i++) {
            ScoreRecord record = records[i];
            scorePanel.add(new JLabel(String.valueOf(i + 1)));
            scorePanel.add(new JLabel(record.getName()));
            scorePanel.add(new JLabel(String.valueOf(record.getScore())));
        }
        
        // Display dialog
        JOptionPane.showMessageDialog(view, scorePanel, 
                view.getTitle() + " - High Scores", JOptionPane.PLAIN_MESSAGE);
    }
}
