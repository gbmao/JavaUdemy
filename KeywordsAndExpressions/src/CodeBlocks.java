import java.util.Arrays;

public class CodeBlocks {
    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 10000;
        int levelCompleted = 8;
        int bonus = 200;
        System.out.println(Arrays.toString(args));
        int finalScore = score;

        callVictory(gameOver, finalScore, levelCompleted, bonus);


        finalScore = 500;

        callVictory(gameOver, finalScore, levelCompleted, bonus);
//        int highScore =  calculateScore(true, score, levelCompleted, bonus);

        System.out.println("The final score is: " + calculateScore(true, score, levelCompleted, bonus));
    }

    public static void callVictory(boolean gameOver, int finalScore, int levelCompleted, int bonus) {
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {


        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
        return finalScore;
    }
}
