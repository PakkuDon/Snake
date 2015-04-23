package model;

public class Point {
    // Instance variables
    private int x;
    private int y;

    // Constructor
    public Point(int x, int y) {
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
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (!(obj instanceof Point)) {
            return false;
        }
        
        // Return true if points contain same x,y values
        Point b = (Point)obj;
        return this.x == b.x && this.y == b.y;
    }
}
