package tenis;

public class Main {

    /**
     * Method to get the Score o players
     * @param playerScore1 Score of player one
     * @param playerScore2 Score of player two
     * @return String for the marker
     */
    public static String getScore(int playerScore1, int playerScore2) {
        /**
         * String to construct the sentence
         */
        String score = "";
        if (isEqual(playerScore1, playerScore2)) {
            score = getEqualScore(playerScore1);
        }
        else if (isAvantage(playerScore2, playerScore1))
        {
            score = getAvantageScore(playerScore1, playerScore2);
        }
        else
        {
            score = getScoreByPoints(playerScore1, playerScore2);
        }
    return score;
    }

    /**
     * Method to get the score when the players are tied
     * @param playerScore1 Score of player one when the players are tied
     * @return String for the marker
     */
    public static String getEqualScore(int playerScore1){
         String[] scoreAsEqual = {"Love-All", "Fifteen-All", "Thirty-All", "Forty-All", "Deuce"};
        switch (playerScore1)
            {
                case 0:
                    return scoreAsEqual[0];
                case 1:
                    return scoreAsEqual[1];
                case 2:
                    return scoreAsEqual[2];
                case 3:
                    return scoreAsEqual[3];
                default:
                    return scoreAsEqual[4];

            }
    }

    /**
     * Method to get the score when one player have avantage
     * @param playerScore1 Score of player one
     * @param playerScore2 Score of player two
     * @return String for the marker when a player have avantage
     */
    public static String getAvantageScore(int playerScore1, int playerScore2){
        String[] scoreAsAdvantage = {"Advantage player1", "Advantage player2", "Win for player1", "Win for player2"};
        /**
         * Avantage for player one
         */
        final int ADVANTAGE_PLAYER_1 = 1;
        /**
         * Avantage for player two
         */
        final int ADVANTAGE_PLAYER_2 = -1;
        /**
         * Win fpr player one
         */
        final int WIN_PLAYER1 = 2;
        String score = "";
        int advantage = playerScore1-playerScore2;
        if (advantage==ADVANTAGE_PLAYER_1) score = scoreAsAdvantage[0];
        else if (advantage ==ADVANTAGE_PLAYER_2) score = scoreAsAdvantage[1];
        else if (advantage>=WIN_PLAYER1) score = scoreAsAdvantage[2];
        else score = scoreAsAdvantage[3];
        return score;
    }

    /**
     * Method to get Score by Points
     * @param playerScore1 Score of player one
     * @param playerScore2 Score of player two
     * @return String for the marker by points
     */
    public static String getScoreByPoints(int playerScore1, int playerScore2){
        String score = "";
        String[] scoreByPoints = {"Love", "Fifteen", "Thirty", "Forty"};
        for (int i=1; i<3; i++)
        {
            int auxScore = 0;
            if (i==1) auxScore = playerScore1;
            else { score+="-"; auxScore = playerScore2;}
            switch(auxScore)
            {
                case 0:
                    score+=scoreByPoints[0];
                    break;
                case 1:
                    score+=scoreByPoints[1];
                    break;
                case 2:
                    score+=scoreByPoints[2];
                    break;
                case 3:
                    score+=scoreByPoints[3];
                    break;
            }
        }
        return score;
    }

    /**
     * Method that checks that the score of both players is equal
     * @param playerScore1
     * @param playerScore2
     * @return true or false
     */
    public static boolean isEqual(int playerScore1, int playerScore2){
        return playerScore1 == playerScore2;
    }
    /**
     * Method that checks which player has the advantage
     * @param playerScore1
     * @param playerScore2
     * @return true or false
     */
    public static boolean isAvantage(int playerScore1, int playerScore2){
        /**
         * Max score to compare
         */
        final int MAX_SCORE = 4;
        return playerScore1 >=MAX_SCORE || playerScore2 >=MAX_SCORE;
    }
}