package model.constants;

/**
 * Constants represent a direction that an object is facing in. Each 
 * enum member has an associated xShift, yShift which represent what values 
 * should be added to a current point to move it in the defined direction. Enum
 * members are also associated with a String key to assist with key-binding 
 * operations.
 */
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
    /**
     * Returns the x-axis shift associated with this direction.
     * @return
     */
    public int getXShift() {
        return xShift;
    }
    
    /**
     * Returns the y-axis shift associated with this direction.
     * @return
     */
    public int getYShift() {
        return yShift;
    }
    
    /**
     * Returns a String constant associated with this direction.
     * @return
     */
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