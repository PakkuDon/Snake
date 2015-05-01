package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import model.Point;
import model.State;
import view.model.GameViewModel;

@SuppressWarnings("serial")
public class GameScreen extends JPanel {
    // Instance variables
    private GameViewModel viewModel;

    @Override
    public void paintComponent(Graphics g) {
        // Clear screen
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        if (viewModel != null) {
            // Create image to draw game state on
            BufferedImage image = new BufferedImage(
                    viewModel.getWidth(), viewModel.getHeight(), 
                    BufferedImage.TYPE_INT_RGB);

            // Flip graphics context along y-axis
            Graphics2D imageContext = (Graphics2D)image.createGraphics();
            AffineTransform transform = AffineTransform
                    .getTranslateInstance(0, viewModel.getHeight());
            transform.scale(1, -1);
            imageContext.setTransform(transform);

            // Set snake colour based on game state 
            if (viewModel.getState() == State.RUNNING) {
                imageContext.setColor(Color.WHITE);
            }
            else {
                imageContext.setColor(Color.DARK_GRAY);
            }

            // Draw snake body
            for (Point p : viewModel.getSnake()) {
                imageContext.fillRect(p.getX(), p.getY(), 1, 1);
            }

            // Draw food
            Point foodPoint = viewModel.getFood();
            imageContext.setColor(Color.RED);
            imageContext.fillRect(foodPoint.getX(), foodPoint.getY(), 1, 1);

            // Draw image and scale it to fill component
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }

    /**
     * Updates view to match model's state.
     * @param viewModel
     */
    public void update(GameViewModel viewModel) {
        this.viewModel = viewModel;
        this.repaint();
    }
}
