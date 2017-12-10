package softwareengineering.scarlet.coursework2.models;

public class DemoMonster extends Monster {

  public DemoMonster(int startX, int startY) {
    super("Demo Monster", startX, startY, 1, 1);
    behaviour = new MonsterBehaviourType1();
  }

}
