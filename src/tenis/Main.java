package tenis;

public class Main {
    /**
     * metodo para devolver la puntuacion de tenis
     */
    public static String getScore(int playerScore1, int playerScore2) {
        String score = "";
        final int MAX_SCORE = 4;
        final int ADVANTAGE_PLAYER1 = 1;
        final int ADVANTAGE_PLAYER2 = -1;
        final int WIN_PLAYER1 = 2;

        if (playerScore1 == playerScore2) {
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
        }
        else if (playerScore1 >=MAX_SCORE || playerScore2 >=MAX_SCORE)
        {
            int advantage = playerScore1-playerScore2;
            if (advantage==ADVANTAGE_PLAYER1) score ="Advantage player1";
            else if (advantage ==ADVANTAGE_PLAYER2) score ="Advantage player2";
            else if (advantage>=WIN_PLAYER1) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
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

        }
    return score;
    }
}