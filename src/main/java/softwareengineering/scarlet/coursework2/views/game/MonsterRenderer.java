package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import softwareengineering.scarlet.coursework2.models.Monster;
import softwareengineering.scarlet.coursework2.models.Player;

public class MonsterRenderer {
  private MonsterAvatar avatar;
  private Monster monster;

  public MonsterRenderer(Monster monster) {
    avatar = new MonsterAvatar();
    this.monster = monster;
  }

  public void render(Graphics2D g2d, ImageObserver observer) {
    this.avatar.draw(this.monster.getX(), this.monster.getY(), g2d, observer);
  }
}
