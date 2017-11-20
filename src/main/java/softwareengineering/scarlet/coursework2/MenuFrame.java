package softwareengineering.scarlet.coursework2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MenuFrame extends JFrame {

  public MenuFrame() {
    initUI();
  }

  public void initUI() {
    this.add(new MenuPanel());

    setSize(500, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}


class MenuPanel extends JPanel implements KeyListener {

  int selectedOption = 0;
  Font menuFont = new Font("Monospaced", Font.PLAIN, 12);
  boolean pressed = false;

  private void drawOptions(Graphics2D g2d) {

    g2d.setFont(menuFont);
    g2d.drawString("  New Game", 180, 250);
    g2d.drawString("  View Leaderboard", 180, 270);
    g2d.drawString("  Quit", 180, 290);

    addKeyListener(this);
    setFocusable(true);
    //does not get arrow keys as input
    setFocusTraversalKeysEnabled(false);
    
  }
  
  private void drawMenuArrow(Graphics2D g2d){
    
    int ySpacing = 20; // height between menu option
    g2d.setFont(menuFont);
    g2d.drawString("→", 180, 250+selectedOption*ySpacing);
    
  }

  void drawTitle(Graphics2D g2d) {
    String titleArt =
        "  ______                                                  ______                                   __     \n"
            + " /      \\                                                /      \\                                 /  |    \n"
            + "/$$$$$$  | __    __   ______    ______    ______        /$$$$$$  | __    __   ______    _______  _$$ |_   \n"
            + "$$ \\__$$/ /  |  /  | /      \\  /      \\  /      \\       $$ |  $$ |/  |  /  | /      \\  /       |/ $$   |  \n"
            + "$$      \\ $$ |  $$ |/$$$$$$  |/$$$$$$  |/$$$$$$  |      $$ |  $$ |$$ |  $$ |/$$$$$$  |/$$$$$$$/ $$$$$$/   \n"
            + " $$$$$$  |$$ |  $$ |$$ |  $$ |$$    $$ |$$ |  $$/       $$ |_ $$ |$$ |  $$ |$$    $$ |$$      \\   $$ | __ \n"
            + "/  \\__$$ |$$ \\__$$ |$$ |__$$ |$$$$$$$$/ $$ |            $$ / \\$$ |$$ \\__$$ |$$$$$$$$/  $$$$$$  |  $$ |/  |\n"
            + "$$    $$/ $$    $$/ $$    $$/ $$       |$$ |            $$ $$ $$< $$    $$/ $$       |/     $$/   $$  $$/ \n"
            + " $$$$$$/   $$$$$$/  $$$$$$$/   $$$$$$$/ $$/              $$$$$$  | $$$$$$/   $$$$$$$/ $$$$$$$/     $$$$/  \n"
            + "                    $$ |                                     $$$/                                         \n"
            + "                    $$ |                                                                                  \n"
            + "                    $$/                                                                                   ";

    Font titleFont = new Font("Monospaced", Font.BOLD, 6);
    g2d.setFont(titleFont);

    // Set title draw coordinates
    int x = 50;
    int y = 100;

    // Print line by line; N.B. Graphics.drawString method does not break
    // across lines, so we must do it for it.
    for (String line : titleArt.split("\n")) {
      g2d.drawString(line, x, y += g2d.getFontMetrics().getHeight());
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    drawOptions(g2d);
    drawMenuArrow(g2d);
    drawTitle(g2d);

  }
  
  public void keyTyped(KeyEvent event){

  }

  /**
   * Implements logic for key presses when on menu screen.
   * 
   * @param event
   *                An event generated when user presses key.
   */
  public void keyPressed(KeyEvent event){
    if (!pressed) { // prevents multiple KeyEvents for single keypress
      pressed = true;
      
      if(event.getKeyCode()== KeyEvent.VK_DOWN){
        selectedOption++;
        selectedOption = selectedOption%3; // mod loops back to top option
        
        repaint(); 
      } else if(event.getKeyCode()== KeyEvent.VK_UP){
        selectedOption--;
        if(selectedOption == -1) {
          selectedOption = 2; // loop back to bottom option
        }
        
        repaint();
      } else if (selectedOption == 2 && event.getKeyCode()== KeyEvent.VK_ENTER){
        System.exit(0);
        
      }
    }
  }

public void keyReleased(KeyEvent event){
  pressed = false;  
}
  
}
