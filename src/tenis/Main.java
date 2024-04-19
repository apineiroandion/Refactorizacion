package tenis;

public class Main {
    /**
     * Max score to compare
     */
    final static int MAX_SCORE = 4;
    /**
     * Avantage for player one
     */
    final static int ADVANTAGE_PLAYER_1 = 1;
    /**
     * Avantage for player two
     */
    final static int ADVANTAGE_PLAYER_2 = -1;
    /**
     * Win fpr player one
     */
    final static int WIN_PLAYER1 = 2;

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
        if (playerScore1 == playerScore2) {
            score = getEqualScore(playerScore1);
        }
        else if (playerScore1 >=MAX_SCORE || playerScore2 >=MAX_SCORE)
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
        String score = "";
            switch (playerScore1)
            {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        return score;
    }

    /**
     * Method to get the score when one player have avantage
     * @param playerScore1 Score of player one
     * @param playerScore2 Score of player two
     * @return String for the marker when a player have avantage
     */
    public static String getAvantageScore(int playerScore1, int playerScore2){
        String score = "";
        int advantage = playerScore1-playerScore2;
        if (advantage==Main.ADVANTAGE_PLAYER_1) score ="Advantage player1";
        else if (advantage ==ADVANTAGE_PLAYER_2) score ="Advantage player2";
        else if (advantage>=WIN_PLAYER1) score = "Win for player1";
        else score ="Win for player2";
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
        for (int i=1; i<3; i++)
        {
            int auxScore = 0;
            if (i==1) auxScore = playerScore1;
            else { score+="-"; auxScore = playerScore2;}
            switch(auxScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }
}