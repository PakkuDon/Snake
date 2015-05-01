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
    /**
     * Returns the x-value of food's location.
     * @return
     */
    public int getX() {
        return point.getX();
    }

    /**
     * Returns the y-value of food's location.
     * @return
     */
    public int getY() {
        return point.getY();
    }
    
    /**
     * Returns the underlying point object associated with food instance.
     * @return
     */
    public Point getPoint() {
        return point;
    }

    /**
     * Returns score value of food instance.
     * @return
     */
    public int getScore() {
        return score;
    }

    // Setters
    /**
     * Sets x-value of food's location.
     * @param x
     */
    public void setX(int x) {
        this.point.setX(x);
    }

    /**
     * Sets y-value of food's location.
     * @param y
     */
    public void setY(int y) {
        this.point.setY(y);
    }

    // Actions
    /**
     * Sets score back to pre-defined maximum.
     */
    public void resetScore() {
        this.score = MAX_SCORE;
    }

    /**
     * Decrements score amount if it is higher than the set minimum.
     */
    public void decreaseScore() {
        if (score > MIN_SCORE) {
            this.score--;
        }
    }
}
