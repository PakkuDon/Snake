package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Snake {
    public class Node {
        // Instance variables
        private int x;
        private int y;
        
        // Constructor
        public Node(int x, int y) {
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
    
    // Instance variables
    private List<Node> body;
    private Direction direction;
    
    // Constructor
    public Snake(int x, int y, int length) {
        body = new LinkedList<Node>();
        
        Node head = new Node(x, y);
        body.add(head);
        while (body.size() < length) {
            body.add(new Node(x, y));
        }
        
        setDirection(Direction.EAST);
    }
    
    // Getters
    public List<Node> getNodes() {
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
        Node tail = body.get(body.size() - 1);
        body.add(new Node(tail.getX(), tail.getY()));
    }
    
    public void move() {
        // Make tail node new head
        Node newHead = body.remove(body.size() - 1);
        body.add(0, newHead);
        
        // Moves snake head based on current direction
        newHead.setX(newHead.getX() + direction.getXShift());
        newHead.setY(newHead.getY() + direction.getYShift());
    }
}
