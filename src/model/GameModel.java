package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.constants.Direction;
import model.constants.State;

public class GameModel {
    // Constants
    private static final int INITIAL_SNAKE_LENGTH = 3;
    private static final int HIGH_SCORES_SIZE = 5;
    private static final String SCORES_FILE = "scores.txt";

    // Instance variables
    private Snake snake;
    private Food food;
    private Random rand;
    private ScoreRecord[] records;
    private int width;
    private int height;
    private int score;
    private State state;

    // Constructor
    public GameModel(int width, int height) {
        // Initialise various properties
        this.width = width;
        this.height = height;
        this.rand = new Random();
        this.records = new ScoreRecord[HIGH_SCORES_SIZE]; 
        this.food = new Food(0, 0);
        this.state = State.INACTIVE;

        // Attempt to load high scores from file
        // If load fails, populate high scores with default scores 
        if (!readScoreData()) {
            for (int i = 0; i < records.length; i++) {
                records[i] = new ScoreRecord();
            }
        }
    }

    // Getters
    /**
     * Returns the width of game field.
     * @return 
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Returns the height of game field.
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
        return snake.getBody();
    }

    /**
     * Returns the point associated with the game's food instance.
     * @return
     */
    public Point getFood() {
        return food.getPoint();
    }
    
    /**
     * Returns the current value of the game's food instance. 
     * @return
     */
    public int getFoodScore() {
        return food.getScore();
    }
    
    /**
     * Returns the score of the current or last-played game.
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * Returns the current State object associated with the game.
     * @return
     */
    public State getGameState() {
        return state;
    }

    /**
     * Returns an array containing the current high scores.
     * @return
     */
    public ScoreRecord[] getRecords() {
        return records;
    }

    // Actions
    /**
     * Initialises components for a new game.
     */
    public void start() {
        snake = new Snake(this.width / 2, this.height / 2, 
                INITIAL_SNAKE_LENGTH);
        spawnFood();
        this.score = 0;
        this.state = State.RUNNING;
    }

    /**
     * Moves food instance to a new random point and resets its value. 
     */
    public void spawnFood() {
        food.setX(rand.nextInt(width));
        food.setY(rand.nextInt(height));
        food.resetScore();
    }

    /**
     * Performs next in-game 'tick'. Advances snake forward one tile and
     * checks if snake has collided either with a food instance or itself.
     * Game state is adjusted accordingly.
     */
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
                this.state = State.INACTIVE;
                break;
            }
        }
    }

    /**
     * Sets the snake's current direction. Returns true if direction 
     * set successfully.
     * @param direction
     * @return
     */
    public boolean setSnakeDirection(Direction direction) {
        return snake.setDirection(direction);
    }

    /**
     * Sets game status either to paused or running state depending on flag.
     * Does not change state if game is inactive. 
     * @param pause
     */
    public void setPaused(boolean pause) {
        if (pause) {
            this.state = State.PAUSED;
        }
        else if (this.state != State.INACTIVE){
            this.state = State.RUNNING;
        }
    }

    /**
     * Attempts to add record instance to list of high scores. Returns true 
     * on success, false otherwise.
     * @param record
     * @return
     */
    public boolean saveScore(ScoreRecord record) {
        // Reject record if its score does not fit on the scoreboard
        if (!isNewRecord(record.getScore())) {
            return false;
        }
        // Else, find position to insert new score at
        for (int i = HIGH_SCORES_SIZE - 2; i >= 0; i--) {
            if (record.getScore() <= records[i].getScore()) {
                break;
            }
            else {
                ScoreRecord temp = records[i];
                records[i] = record;
                if (i != HIGH_SCORES_SIZE - 1) {
                    records[i + 1] = temp;
                }
            }
        }

        writeScoreData();
        return true;
    }

    /**
     * Returns true if the given score beats the lowest score 
     * on the high scores list.
     * @param score
     * @return
     */
    public boolean isNewRecord(int score) {
        return score > records[records.length - 1].getScore();
    }

    /**
     * Removes all set high scores. High scores are replaced by default
     * 0-score records.
     */
    public void clearScores() {
        // Replace stored high scores with default high scores
        for (int i = 0; i < records.length; i++) {
            records[i] = new ScoreRecord();
        }

        // Write out default scores
        writeScoreData();
    }

    /**
     * Attempts to load scores from a text file at a pre-defined location.  
     * @return True on success, false on either an IO or format exception.
     */
    public boolean readScoreData() {
        Scanner sc = null;
        // Attempt to read parse contents of score file
        try {
            sc = new Scanner(new File(SCORES_FILE));
            // Parse contents of each line
            for (int i = 0; i < records.length; i++) {
                String line = sc.nextLine();
                String[] tokens = line.split(",");
                if (tokens.length != 2) {
                    throw new IOException("Scores in invalid format");
                }

                int score = Integer.parseInt(tokens[1]);
                ScoreRecord record = new ScoreRecord(tokens[0], score);
                records[i] = record;
            }

            // If file has trailing records, throw validation error
            if (sc.hasNext()) {
                throw new IOException("Scores in invalid format");
            }

            sc.close();

            // Sort high score list
            Arrays.sort(records, new Comparator<ScoreRecord>() {
                @Override
                public int compare(ScoreRecord a, ScoreRecord b) {
                    return b.getScore() - a.getScore();
                }
            });
            
            return true;
        }
        // On validation error, log error and return
        catch (NumberFormatException | IOException e) {
            System.err.println("Failed to read from " + SCORES_FILE);
            return false;
        }
        finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    /**
     * Attempts to write scores to a file at a pre-defined location.  
     * @return True on success, false on IO exception.
     */
    public boolean writeScoreData() {
        // Attempt to write out high scores to text file 
        // Scores currently written out as CSV
        try {
            FileWriter fw = new FileWriter(SCORES_FILE);
            for (int i = 0; i < records.length; i++) {
                fw.write(String.format("%s,%s%n", 
                        records[i].getName(), records[i].getScore()));
            }
            fw.close();
        }
        // On failure, log error and return
        catch (IOException e) {
            System.err.println("Failed to write to " + SCORES_FILE);
            return false;
        }
        return true;
    }
}
