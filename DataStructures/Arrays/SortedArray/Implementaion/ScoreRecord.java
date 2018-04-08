package DataStructures.Arrays.SortedArray.Implementaion;

public class ScoreRecord {

    private int score;
    private String name;

    public ScoreRecord(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public String toString() {
        return getName() + ":" + getScore();
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
