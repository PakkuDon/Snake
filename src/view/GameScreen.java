package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import model.Point;
import model.State;
import view.model.GameViewModel;

public class GameScreen extends JPanel {
    // Instance variables
    private AppFrame view;
    private GameViewModel viewModel;

    // Constructor
    public GameScreen(AppFrame view) {
        this.view = view;
    }

    @Override
    public void paintComponent(Graphics g) {
        // Clear screen
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        if (viewModel != null) {
            // Flip graphics context along y-axis
            Graphics2D g2d = (Graphics2D)g;
            AffineTransform transform = AffineTransform
                    .getTranslateInstance(0, this.getHeight());
            transform.scale(1, -1);
            g2d.setTransform(transform);

            // Calculate pixel dimensions
            int cellWidth = this.getWidth() / viewModel.getWidth();
            int cellHeight = this.getHeight() / viewModel.getHeight();

            // Set snake colour based on game state 
            if (viewModel.getState() == State.RUNNING) {
                g.setColor(Color.WHITE);
            }
            else {
                g.setColor(Color.DARK_GRAY);
            }
            
            // Draw snake body
            for (Point p : viewModel.getSnake()) {
                int startX = cellWidth * p.getX();
                int startY = cellHeight * p.getY();
                g.fillRect(startX, startY, cellWidth, cellHeight);
            }

            // Draw food
            Point foodPoint = viewModel.getFood();
            g.setColor(Color.RED);
            g.fillRect(foodPoint.getX() * cellWidth, 
                    foodPoint.getY() * cellHeight, 
                    cellWidth, cellHeight);
        }
    }

    public void update(GameViewModel viewModel) {
        this.viewModel = viewModel;
        this.repaint();
    }
}
