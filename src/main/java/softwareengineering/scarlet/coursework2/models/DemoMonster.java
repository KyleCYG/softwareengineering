package softwareengineering.scarlet.coursework2.models;

public class DemoMonster extends Monster {
  private static int monsterStartStrength = 5;
  private static int monsterStartHealth = 20;

  public boolean hasHadTurn = false;

  public DemoMonster(int startX, int startY) {
    super("Demo Monster", startX, startY, monsterStartHealth, monsterStartStrength);
    behaviour = new MonsterBehaviourType1();
  }

  @Override
  public void performAction(Dungeon dungeon, Player player) {
    super.performAction(dungeon, player);
    hasHadTurn = true;
  }

  public boolean isHasHadTurn() {
    return hasHadTurn;
  }

  public void setHasHadTurn(boolean hasHadTurn) {
    this.hasHadTurn = hasHadTurn;
  }
}
