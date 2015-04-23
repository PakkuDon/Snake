package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Snake {
    // Instance variables
    private List<Point> body;
    private Direction direction;
    
    // Constructor
    public Snake(int x, int y, int length) {
        body = new LinkedList<Point>();
        
        Point head = new Point(x, y);
        body.add(head);
        while (body.size() < length) {
            body.add(new Point(x, y));
        }
        
        setDirection(Direction.EAST);
    }
    
    // Getters
    public List<Point> getBody() {
        return Collections.unmodifiableList(body);
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    // Setters
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    // Actions
    public void grow() {
        Point tail = body.get(body.size() - 1);
        body.add(new Point(tail.getX(), tail.getY()));
    }
    
    public void move() {
        // Make tail node new head
        Point newHead = body.remove(body.size() - 1);
        body.add(0, newHead);
        
        // Moves snake head based on current direction
        newHead.setX(newHead.getX() + direction.getXShift());
        newHead.setY(newHead.getY() + direction.getYShift());
    }
}
