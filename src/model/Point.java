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
    /**
     * Returns x-value of this point.
     * @return
     */
    public int getX() {
        return x;
    }
    
    /**
     * Returns y-value of this point.
     * @return
     */
    public int getY() {
        return y;
    }
    
    // Setters
    /**
     * Sets x-value of this point.
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Sets y-value of this point.
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    /**
     * Returns true if the given object is a point instance that has 
     * the same x,y values as this point.
     */
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
