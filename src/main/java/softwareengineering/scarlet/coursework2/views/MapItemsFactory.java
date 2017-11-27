package softwareengineering.scarlet.coursework2.views;

public class MapItemsFactory implements Factory{

  @Override
  public Items init(String item) {
    // TODO Auto-generated method stub
    switch(item) {
      case "r":
        return new Room();
      case "c":
        return new Corridor();
      case "w":
        return new Wall();
      case "g":
        return new Gold();
      case "h":
        return new Health();
      case "e":
        return new Exit();
      case "s":
        return new Strength();
      case "SD":
        return new StD();
      case "SU":
        return new StU();
      default:
       return null;
    }
  }

}