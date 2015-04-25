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
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public List<Point> getSnake() {
        return snake;
    }
    
    public Point getFood() {
        return food;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getFoodScore() {
        return foodScore;
    }
    
    public State getState() {
        return state;
    }
}
