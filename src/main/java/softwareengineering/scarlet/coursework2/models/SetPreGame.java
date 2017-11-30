package softwareengineering.scarlet.coursework2.models;

public class SetPreGame {

  private String name;
  
  
  public SetPreGame() {
    this.name = "----";
  }
  
  public void setName(String name)
  {
    this.name=name;
    
  }
  public String getName()
  {
    return this.name;
  }
  public void appendLetter(String letter)
  {
    if(name.contains("-"))
       name=name.replaceFirst("-", letter);
  }
  public void deleteLetter()
  {
    name= name.substring(0, name.length()-1);
  }
  
  
}
