package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.constants.Direction;

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

        this.direction = Direction.EAST;
    }

    // Getters
    /**
     * Returns the list of points that make up the snake's body.
     * @return
     */
    public List<Point> getBody() {
        return Collections.unmodifiableList(body);
    }

    /**
     * Returns the snake's current direction.
     * @return
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Returns the point at the front of the snake.
     * @return
     */
    public Point getHead() {
        return body.get(0);
    }

    // Setters
    /**
     * Sets the snake's current direction to the given direction. Only sets 
     * direction if given direction is not equal or opposite to current 
     * direction.
     * @param direction
     */
    public boolean setDirection(Direction direction) {
        // If given direction opposite or equal to snake's 
        // current direction return error
        if (this.direction.isOpposite(direction) ||
                this.direction == direction) {
            return false;
        }
        this.direction = direction;
        return true;
    }

    // Actions
    /**
     * Adds a new node to the snake's body. New node's location is set to 
     * the same point as the snake's tail.
     */
    public void grow() {
        Point tail = body.get(body.size() - 1);
        body.add(new Point(tail.getX(), tail.getY()));
    }

    /**
     * Advances the snake's head forward one tile.
     */
    public void move() {
        // Make tail node new head
        Point previousHead = body.get(0);
        Point newHead = body.remove(body.size() - 1);
        body.add(0, newHead);

        // Moves snake head based on current direction
        newHead.setX(previousHead.getX() + direction.getXShift());
        newHead.setY(previousHead.getY() + direction.getYShift());
    }
}
