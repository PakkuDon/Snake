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
    private boolean isRunning;

    // Constructor
    public GameModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.rand = new Random();
        this.food = new Food(0, 0);
        this.isRunning = false;
    }

    // Getters
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Point> getSnake() { 
        return snake.getBody();
    }

    public Food getFood() {
        return food;
    }

    public int getScore() {
        return score;
    }

    public boolean isRunning() {
        return isRunning;
    }

    // Actions
    public void start() {
        snake = new Snake(this.width / 2, this.height / 2, 
                INITIAL_SNAKE_LENGTH);
        spawnFood();
        this.score = 0;
        this.isRunning = true;
    }

    public void spawnFood() {
        food.setX(rand.nextInt(width));
        food.setY(rand.nextInt(height));
        food.resetScore();
    }

    public void move() {
        // Move snake 
        snake.move();
        Point head = snake.getHead();

        // If snake head has gone out of bounds, 'warp' head node
        // to other side of map
        if (head.getX() < 0 || head.getX() >= width 
                || head.getY() < 0 || head.getY() >= height) {
            switch (snake.getDirection()) {
            case NORTH:
                head.setY(0);
                break;
            case EAST:
                head.setX(0);
                break;
            case SOUTH:
                head.setY(height - 1);
                break;
            case WEST:
                head.setX(width - 1);
                break;
            }
        }

        // If snake has collected food, update score, extend snake and 
        // reset and respawn food
        // Otherwise decrease food points
        if (head.equals(food.getPoint())) {
            this.score += food.getScore();
            snake.grow();
            spawnFood();
        }
        else {
            food.decreaseScore();
        }

        // Check if snake has collided with itself
        // If true, end game
        List<Point> snakeBody = snake.getBody();
        for (int i = 1; i < snakeBody.size(); i++) {
            if (head.equals(snakeBody.get(i))) {
                this.isRunning = false;
                break;
            }
        }
    }

    public void setSnakeDirection(Direction direction) {
        snake.setDirection(direction);
    }
}
