package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.GameModel;
import model.ScoreRecord;
import controller.ClearScoresController;

@SuppressWarnings("serial")
public class HighScoreDialog extends JDialog {
    // Instance variablees
    private JPanel scorePanel;
    
    // Constructor
    public HighScoreDialog(AppFrame view, GameModel model) {
        super(view);
        
        // Construct container to hold scores
        scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(0, 3));
        
        // Add headings
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(0, 3));
        header.add(new JLabel("Rank"));
        header.add(new JLabel("Player"));
        header.add(new JLabel("Score"));
        
        // Display high scores
        ScoreRecord[] records = model.getRecords();
        showScores(records);
        
        // Add button to clear scores
        JButton clearScoresBtn = new JButton("Clear scores");
        clearScoresBtn.addActionListener(new ClearScoresController(model, this));
        
        // Set properties of dialog
        this.setTitle(view.getTitle() + " - High Scores");
        this.setSize(200, 240);
        this.setLocationRelativeTo(view);
        
        // Add components to dialog
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(scorePanel, BorderLayout.CENTER);
        this.add(clearScoresBtn, BorderLayout.SOUTH);
        
        // Display dialog
        this.setVisible(true);
    }
    
    /**
     * Updates view to display given records. 
     * @param records
     */
    public void showScores(ScoreRecord[] records) {
        scorePanel.removeAll();
        for (int i = 0; i < records.length; i++) {
            ScoreRecord record = records[i];
            scorePanel.add(new JLabel(String.valueOf(i + 1)));
            scorePanel.add(new JLabel(record.getName()));
            scorePanel.add(new JLabel(String.valueOf(record.getScore())));
        }
        this.revalidate();
    }
}
