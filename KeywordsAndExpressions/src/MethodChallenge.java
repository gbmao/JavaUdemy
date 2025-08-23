public class MethodChallenge {
    public static void main(String[] args) {
        String name = "Raquel";
        int playerScore = -100;

        displayHighScorePosition(name, calculateHighScorePosition(playerScore));

    }

    public static void displayHighScorePosition(String name, int position) {
        System.out.println(name + " managed to get into position " + position + " on the high score list");
    }

    public static int calculateHighScorePosition(int playerScore) {
        if (playerScore >= 1000) {
            return 1;
        } else if (playerScore >= 500) {
            return 2;
        } else if (playerScore >= 100) {
            return 3;
        }
        return 4;

    }
}
