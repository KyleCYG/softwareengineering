package softwareengineering.scarlet.coursework2.models;

/**
 * Represents a name/score pairing for the leaderboard
 *
 * @author Dan Cosser
 */
public class GameScore {
  private String playerName;
  private int score;

  public GameScore(String playerName, int score) {
    super();
    this.playerName = playerName;
    this.score = score;
  }

  public String getPlayerName() {
    return playerName;
  }

  public int getScore() {
    return score;
  }
}
