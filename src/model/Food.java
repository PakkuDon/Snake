package model;

public class Food {
    // Constants
    private static final int MAX_SCORE = 100;
    private static final int MIN_SCORE = 10;

    // Instance variables
    private Point point;
    private int score;

    // Constructor
    public Food(int x, int y) {
        this.point = new Point(x, y);
        this.score = MAX_SCORE;
    }

    // Getters
    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }
    
    public Point getPoint() {
        return point;
    }

    public int getScore() {
        return score;
    }

    // Setters
    public void setX(int x) {
        this.point.setX(x);
    }

    public void setY(int y) {
        this.point.setY(y);
    }

    // Actions
    public void resetScore() {
        this.score = MAX_SCORE;
    }

    public void decreaseScore() {
        if (score > MIN_SCORE) {
            this.score--;
        }
    }
}
