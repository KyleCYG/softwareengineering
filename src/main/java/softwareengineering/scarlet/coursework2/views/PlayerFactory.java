package softwareengineering.scarlet.coursework2.views;

public class PlayerFactory implements Factory{



@Override
  public Items init(String item) {
    // TODO Auto-generated method stub
    switch(item) {
      case "m":
        return new Player();
      case "r":
        return new Player();
      default:
       return null;
    }
  }
}