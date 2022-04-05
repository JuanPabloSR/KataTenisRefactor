
public class TennisGame3 implements TennisGame {

    private int scorePlayer2;
    private int scorePlayer1;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (comparingScores())
            return scoreResults();
        if (isEqualsScore())
            return "Deuce";
        return getWinner();
    }

    private String getWinner() {
        return isAdvantage() ? "Advantage " + playerAdvantage() : "Win for " + playerAdvantage();
    }

    private String playerAdvantage() {
        return scorePlayer1 > scorePlayer2 ? player1Name : player2Name;
    }

    private boolean isAdvantage() {
        return Math.pow((scorePlayer2 - scorePlayer1), 2) == 1;
    }

    private String scoreResults() {
        String[] scores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return isEqualsScore() ? scores[scorePlayer1] + "-All" : scores[scorePlayer1] + "-" + scores[scorePlayer2];
    }

    private boolean isDifferentToSix() {
        return (scorePlayer1 + scorePlayer2 != 6);
    }

    private boolean isLessThanFour(int scorePlayer) {
        return scorePlayer < 4;
    }

    private boolean comparingScores() {
        return isLessThanFour(scorePlayer1) && isLessThanFour(scorePlayer2) && isDifferentToSix();
    }

    private boolean isEqualsScore() {
        return scorePlayer1 == scorePlayer2;
    }

    public void player1Score() {
        scorePlayer1++;
    }

    public void player2Score() {
        scorePlayer2++;
    }

    public void wonPoint(String player) {
        if (player.equalsIgnoreCase(player1Name))
            player1Score();
        if (player.equalsIgnoreCase(player2Name))
            player2Score();
    }
}