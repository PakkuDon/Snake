package model;

public enum Direction {
    NORTH(0, 1), 
    EAST(1, 0), 
    SOUTH(0, -1), 
    WEST(-1, 0);
    
    // Instance variables
    private int xShift;
    private int yShift;
    
    // Constructor
    private Direction(int xShift, int yShift) {
        this.xShift = xShift;
        this.yShift = yShift;
    }
    
    // Accessors
    public int getXShift() {
        return xShift;
    }
    
    public int getYShift() {
        return yShift;
    }
}