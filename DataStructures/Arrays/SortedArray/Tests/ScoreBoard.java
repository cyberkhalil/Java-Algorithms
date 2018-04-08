package DataStructures.Arrays.SortedArray.Tests;

import DataStructures.Arrays.SortedArray.SortedArray;
import java.util.Random;

public class ScoreBoard {

    public static void main(String[] args) {
        Random ran = new Random();
        ScoreBoard highScore = new ScoreBoard(10);
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player1"));
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player2"));
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player3"));
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player4"));
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player5"));
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player6"));
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player13"));
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player14"));
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player7"));
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player8"));
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player9"));
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player10"));
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player11"));
        highScore.addScore(new ScoreRecord(ran.nextInt(500), "player12"));
        System.out.println(highScore);
    }

    private SortedArray<ScoreRecord> scoreRecordsArray;

    public ScoreBoard(int capacity) {
        scoreRecordsArray = new SortedArray<>(capacity);
    }

    @Override
    public String toString() {
        return scoreRecordsArray.toString();
    }

    public boolean addScore(ScoreRecord record) {
        return scoreRecordsArray.add(record);
    }

    public boolean removeScore(ScoreRecord record) {
        return scoreRecordsArray.remove(record);
    }

    /**
     * @return the scoreRecordsArray
     */
    public ScoreRecord[] getScoreRecordsArray() {
        return scoreRecordsArray.getArray();
    }

}
