package softwareengineering.scarlet.coursework2.views;

public class MapItemsFactory implements Factory{

  @Override
  public items init(String item) {
    // TODO Auto-generated method stub
    switch(item) {
      case "r":
        return new room();
      case "c":
        return new carridor();
      case "w":
        return new wall();
      case "g":
        return new gold();
      case "h":
        return new health();
      case "e":
        return new exit();
      case "s":
        return new strength();
      case "SD":
        return new StD();
      case "SU":
        return new StU();
      default:
       return null;
    }
  }

}
