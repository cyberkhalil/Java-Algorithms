package data_structures.arrays.sorted_array.tests;

public class ScoreRecord implements Comparable<ScoreRecord> {

    private final int score;
    private final String name;

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
