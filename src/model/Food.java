package model;

public class Food {
    // Instance variables
    private int x;
    private int y;
    
    // Constructor
    public Food(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
    
    // Getters
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    // Setters
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
}
