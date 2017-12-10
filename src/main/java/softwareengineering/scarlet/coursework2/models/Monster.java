package softwareengineering.scarlet.coursework2.models;

public abstract class Monster extends Character {
  protected MonsterBehaviour behaviour;

  public Monster(String name, int startX, int startY, int health, int strength) {
    super(name, startX, startY, health, strength);
  }

  public void performAction(Dungeon dungeon, Player player) {
    behaviour.performAction(this, dungeon, player);
  }
}
