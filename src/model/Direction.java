package model;

public enum Direction {
    NORTH(0, 1, "VK_UP"), 
    EAST(1, 0, "VK_RIGHT"), 
    SOUTH(0, -1, "VK_DOWN"), 
    WEST(-1, 0, "VK_LEFT");
    
    // Instance variables
    private int xShift;
    private int yShift;
    private String key;
    
    // Constructor
    private Direction(int xShift, int yShift, String key) {
        this.xShift = xShift;
        this.yShift = yShift;
        this.key = key;
    }
    
    // Accessors
    public int getXShift() {
        return xShift;
    }
    
    public int getYShift() {
        return yShift;
    }
    
    public String getKey() {
        return key;
    }
    
    /**
     * Returns true if the given direction is the exact opposite of 
     * this direction.
     * @param b
     * @return
     */
    public boolean isOpposite(Direction b) {
        return Math.abs(this.ordinal() - b.ordinal()) == 2; 
    }
}