package view.model;

import java.util.List;

import model.Point;
import model.State;

public class GameViewModel {
    // Instance variables
    private int width;
    private int height;
    private List<Point> snake;
    private Point food;
    private int score;
    private int foodScore;
    private State state;
    
    // Constructor
    public GameViewModel(int width, int height, 
            List<Point> snake, Point food, 
            int score, int foodScore, State state) {
        this.width = width;
        this.height = height;
        this.snake = snake;
        this.food = food;
        this.score = score;
        this.foodScore = foodScore;
        this.state = state;
    }
    
    // Getters
    /**
     * Returns the width of the game's field.
     * @return
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Returns the height of the game's field.
     * @return
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Returns the list of points that make up the snake's body.
     * @return
     */
    public List<Point> getSnake() {
        return snake;
    }
    
    /**
     * Returns the location of the game's food instance.
     * @return
     */
    public Point getFood() {
        return food;
    }
    
    /**
     * Returns the game's current score.
     * @return
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Returns the current value of the food instance.
     * @return
     */
    public int getFoodScore() {
        return foodScore;
    }
    
    /**
     * Returns the game's current state.
     * @return
     */
    public State getState() {
        return state;
    }
}
