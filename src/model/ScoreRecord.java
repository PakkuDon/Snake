package model;

public class ScoreRecord {
    // Instance variables
    public String name;
    private int score;

    // Constructor
    public ScoreRecord(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    // Default no-args constructor - represents a default record
    public ScoreRecord() {
        this("---", 0);
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }
}
