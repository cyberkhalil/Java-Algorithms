package DataStructures.Arrays.SortedArray.Tests;

public class ScoreRecord implements Comparable<ScoreRecord> {

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

    @Override
    public int compareTo(ScoreRecord o) {
        return this.score - o.score;
    }

}
