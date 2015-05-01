package model;

public class ScoreRecord {
    // Instance variables
    private String name;
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
    /**
     * Returns the name associated with this score record.
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the score associated with this score record.
     * @return
     */
    public int getScore() {
        return score;
    }
}
