package model;

public class Food {
    // Instance variables
    private Point point;
    
    // Constructor
    public Food(int x, int y) {
        this.point = new Point(x, y);
    }
    
    // Getters
    public int getX() {
        return point.getX();
    }
    
    public int getY() {
        return point.getY();
    }
    
    // Setters
    public void setX(int x) {
        this.point.setX(x);
    }
    
    public void setY(int y) {
        this.point.setY(y);
    }
}
