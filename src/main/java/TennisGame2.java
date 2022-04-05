import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame
{
    public int player1Point = 0;
    public int player2Point = 0;
    
    public String player1res = "";
    public String player2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        StringBuilder score = new StringBuilder();

        if (isEqualScore())
            score.append(equalScore());
        else if (upTo4Points()){
            int scoreDifference = player1Point - player2Point;
            score.append(advantage(scoreDifference));
        }else {
            score.append(getScorePlayer(player1Point)).append("-").append(getScorePlayer(player2Point));
        }
            return score.toString();
    }

    private boolean upTo4Points(){
        return player1Point >= 4 || player2Point >= 4;
    }

    public String advantage(int score){
        switch (score){
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
              return scoreDifference()  ? "Win for player1" : "Win for player2";
        }
    }

    private boolean scoreDifference(){
        return  player1Point - player2Point >= 2;
    }

    public String getScorePlayer(int scorePlayer){
        List<String> scoreList = Arrays.asList("Love", "Fifteen","Thirty", "Forty");
        return scoreList.get(scorePlayer);
    }

    public String equalScore(){
        List<String> scoreList = Arrays.asList("Love-All", "Fifteen-All","Thirty-All", "Deuce", "Deuce");
        return scoreList.get(player1Point);
    }

    private boolean isEqualScore() {
        return player1Point==player2Point;
    }

    public void P1Score(){
        player1Point++;
    }
    
    public void P2Score(){
        player2Point++;
    }

    public void wonPoint(String player) {
        if (player.equalsIgnoreCase(player1Name))
            P1Score();
        if (player.equalsIgnoreCase(player2Name))
            P2Score();
    }
}