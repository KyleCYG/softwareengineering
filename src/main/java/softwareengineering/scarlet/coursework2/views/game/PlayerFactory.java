package softwareengineering.scarlet.coursework2.views.game;

public class PlayerFactory implements Factory {
  @Override
  public Items init(String item) {
    switch (item) {
      case "m":
        return new Player();
      case "r":
        return new Player();
      default:
        return null;
    }
  }
}
