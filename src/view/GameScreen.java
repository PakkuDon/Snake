package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Point;
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
            int cellWidth = this.getWidth() / viewModel.getWidth();
            int cellHeight = this.getHeight() / viewModel.getHeight();
            
            g.setColor(Color.WHITE);
            // Draw snake
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
