package softwareengineering.scarlet.coursework2.views.game;

public class PlayerFactory {
  public ItemImage init(String item) {
    switch (item) {
      case "m":
        return new PlayerAvatar();
      case "r":
        return new PlayerAvatar();
      default:
        return null;
    }
  }
}
