package model;

import java.util.List;
import java.util.Random;

public class GameModel {
    // Constants
    private static final int INITIAL_SNAKE_LENGTH = 3;
   
    // Instance variables
    private Snake snake;
    private Food food;
    private Random rand;
    private int width;
    private int height;
    private int score; 
   
    // Constructor
    public GameModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.rand = new Random();
        food = new Food(rand.nextInt(width), rand.nextInt(height));
        
        this.start();
    }
    
    // Getters
    public List<Point> getSnake() { 
        return snake.getBody();
    }
    
    public Food getFood() {
        return food;
    }
    
    public int getScore() {
        return score;
    }
    
    // Actions
    public void start() {
        snake = new Snake(this.width / 2, this.height / 2, 
                INITIAL_SNAKE_LENGTH);
        spawnFood();
        score = 0;
    }
    
    public void spawnFood() {
        food.setX(rand.nextInt(width));
        food.setY(rand.nextInt(height));
    }
    
    public void move() {
        snake.move();
    }
    
    public void setSnakeDirection(Direction direction) {
        snake.setDirection(direction);
    }
}
