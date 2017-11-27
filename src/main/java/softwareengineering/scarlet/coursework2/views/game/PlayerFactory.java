package softwareengineering.scarlet.coursework2.views.game;

public class PlayerFactory implements Factory {
  @Override
  public Items init(String item) {
    switch (item) {
      case "m":
        return new PlayerRenderer();
      case "r":
        return new PlayerRenderer();
      default:
        return null;
    }
  }
}
