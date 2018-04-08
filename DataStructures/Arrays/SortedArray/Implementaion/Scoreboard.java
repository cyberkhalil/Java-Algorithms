package DataStructures.Arrays.SortedArray.Implementaion;

import java.util.Arrays;
import java.util.Random;

public class Scoreboard {

    public static void main(String[] args) {
        Random ran = new Random();
        Scoreboard highScore = new Scoreboard(10);
        highScore.add(new ScoreRecord(ran.nextInt(500), "player1"));
        highScore.add(new ScoreRecord(ran.nextInt(500), "player2"));
        highScore.add(new ScoreRecord(ran.nextInt(500), "player3"));
        highScore.add(new ScoreRecord(ran.nextInt(500), "player4"));
        highScore.add(new ScoreRecord(ran.nextInt(500), "player5"));
        highScore.add(new ScoreRecord(ran.nextInt(500), "player6"));
        highScore.add(new ScoreRecord(ran.nextInt(500), "player13"));
        highScore.add(new ScoreRecord(ran.nextInt(500), "player14"));
        highScore.add(new ScoreRecord(ran.nextInt(500), "player7"));
        highScore.add(new ScoreRecord(ran.nextInt(500), "player8"));
        highScore.add(new ScoreRecord(ran.nextInt(500), "player9"));
        highScore.add(new ScoreRecord(ran.nextInt(500), "player10"));
        highScore.add(new ScoreRecord(ran.nextInt(500), "player11"));
        highScore.add(new ScoreRecord(ran.nextInt(500), "player12"));
        System.out.println(highScore);
    }

    private ScoreRecord[] scoreRecordsArray;
    private int lastEntityIndex;

    public Scoreboard(int capacity) {
        scoreRecordsArray = new ScoreRecord[capacity];
        lastEntityIndex = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(getScoreRecordsArray());
    }

    public void add(ScoreRecord record) {
        for (int i = 0; i < getScoreRecordsArray().length; i++) {
            if (scoreRecordsArray[i] == null || scoreRecordsArray[i].getScore() < record.getScore()) {
                for (int j = scoreRecordsArray.length - 1; j > i; j--) {
                    scoreRecordsArray[j] = scoreRecordsArray[j - 1];
                }
                scoreRecordsArray[i] = record;
                if (lastEntityIndex < scoreRecordsArray.length) {
                    lastEntityIndex++;
                }
                return;
            }
        }
    }

    public void remove(int Index) {
        if (lastEntityIndex >= Index) {
            for (int i = Index; i < lastEntityIndex - 1; i++) {
                scoreRecordsArray[i] = scoreRecordsArray[i + 1];
            }
            scoreRecordsArray[--lastEntityIndex] = null;
        }
    }

    public void remove(String name) {
        for (int i = 0; i < lastEntityIndex; i++) {
            if (scoreRecordsArray[i].getName().equals(name)) {
                remove(i);
            }
        }
    }

    /**
     * @param lastEntityIndex the lastEntityIndex to set
     */
    public void setLastEntityIndex(int lastEntityIndex) {
        this.lastEntityIndex = lastEntityIndex;
    }

    /**
     * @return the scoreRecordsArray
     */
    public ScoreRecord[] getScoreRecordsArray() {
        return scoreRecordsArray;
    }

    /**
     * @param scoreRecordsArray the scoreRecordsArray to set
     */
    public void setScoreRecordsArray(ScoreRecord[] scoreRecordsArray) {
        this.scoreRecordsArray = scoreRecordsArray;
    }
}
