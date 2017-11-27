package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import softwareengineering.scarlet.coursework2.controllers.GameController;
import softwareengineering.scarlet.coursework2.controllers.MoveDirection;
import softwareengineering.scarlet.coursework2.models.Dungeon;

public class GamePanel extends JPanel implements KeyListener{
  /**
   * Main Panel of showing the dungeon
   */
  private static final long serialVersionUID = 1L;
  
  private PlayerRenderer playerRender;
  private LevelRenderer levelRender;
  private GameController controller;
  
  public GamePanel(GameController controller, Dungeon dungeon) {
    this.controller = controller;  
    initGamePanel(dungeon);
  }
  
  private void initGamePanel(Dungeon dungeon) {
    addKeyListener(new TAdapter());
    setFocusable(true);
    levelRender = new LevelRenderer(dungeon,this);
    playerRender = new PlayerRenderer();
  }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setFont(new Font("Chalkduster", Font.PLAIN, 20));
      g2d.drawString("Shalllll.. weeee.. begin?", 300, 25);
      levelRender.render(g2d);
      playerRender.draw(g2d, this);

      Toolkit.getDefaultToolkit().sync();
    }

    private class TAdapter extends KeyAdapter {
      @Override
      public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
          case KeyEvent.VK_LEFT:
            controller.movePlayer(MoveDirection.LEFT);
            break;
          case KeyEvent.VK_RIGHT:
            controller.movePlayer(MoveDirection.RIGHT);
            break;
          case KeyEvent.VK_UP:
            controller.movePlayer(MoveDirection.UP);
            break;
          case KeyEvent.VK_DOWN:
            controller.movePlayer(MoveDirection.DOWN);
            break;
        }
      }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
