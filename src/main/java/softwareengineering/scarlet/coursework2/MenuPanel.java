package softwareengineering.scarlet.coursework2;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import softwareengineering.scarlet.coursework2.views.InputNameFrame;

public class MenuPanel extends JPanel implements KeyListener {

  int selectedOption = 0;
  Font menuFont = new Font("Monospaced", Font.PLAIN, 12);
  boolean pressed = false;

  /**
  * Shows the menu options and get the key that user presses
  * 
  * @param g2d 
  */ 
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
  
  /**
  * Shows the arrow on the appropriate option according to user's input
  * 
  * @param g2d 
  */ 
  private void drawMenuArrow(Graphics2D g2d){
    
    int ySpacing = 20; // height between menu option
    g2d.setFont(menuFont);
    g2d.drawString("→", 180, 250+selectedOption*ySpacing);
    
  }

   /**
   * Renders the title in the menu frame.
   * 
   * @param g2d
   */
  void drawTitle(Graphics2D g2d) {
    String titleArt =
        " ________  __                            __                   ______                                   __     \n" + 
        "/        |/  |                          /  |                 /      \\                                 /  |    \n" + 
        "$$$$$$$$/ $$ |____    ______    _______ $$/   _______       /$$$$$$  | __    __   ______    _______  _$$ |_   \n" + 
        "   $$ |   $$      \\  /      \\  /       |/  | /       |      $$ |  $$ |/  |  /  | /      \\  /       |/ $$   |  \n" + 
        "   $$ |   $$$$$$$  |/$$$$$$  |/$$$$$$$/ $$ |/$$$$$$$/       $$ |  $$ |$$ |  $$ |/$$$$$$  |/$$$$$$$/ $$$$$$/   \n" + 
        "   $$ |   $$ |  $$ |$$    $$ |$$      \\ $$ |$$      \\       $$ |_ $$ |$$ |  $$ |$$    $$ |$$      \\   $$ | __ \n" + 
        "   $$ |   $$ |  $$ |$$$$$$$$/  $$$$$$  |$$ | $$$$$$  |      $$ / \\$$ |$$ \\__$$ |$$$$$$$$/  $$$$$$  |  $$ |/  |\n" + 
        "   $$ |   $$ |  $$ |$$       |/     $$/ $$ |/     $$/       $$ $$ $$< $$    $$/ $$       |/     $$/   $$  $$/ \n" + 
        "   $$/    $$/   $$/  $$$$$$$/ $$$$$$$/  $$/ $$$$$$$/         $$$$$$  | $$$$$$/   $$$$$$$/ $$$$$$$/     $$$$/  \n" + 
        "                                                                 $$$/                                         ";

    Font titleFont = new Font("Monospaced", Font.BOLD, 6);
    g2d.setFont(titleFont);

    // Set title draw coordinates
    int x = 30;
    int y = 100;

    // Print line by line; N.B. Graphics.drawString method does not break
    // across lines, so we must do it for it.
    for (String line : titleArt.split("\n")) {
      g2d.drawString(line, x, y += g2d.getFontMetrics().getHeight());
    }
  }


  /**
  * Renders all the menu items (title, options, arrow on specified option)
  * 
  * @param g 
  */  
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
        
      }else if (selectedOption == 0 && event.getKeyCode()== KeyEvent.VK_ENTER) {
        
        InputNameFrame ex = new InputNameFrame();
        ex.setVisible(true);

      } 
      
    }
  }

  public void keyReleased(KeyEvent event){
    // set pressed to false so that keyPressed is not called twice (bug)
    pressed = false;  
  }
  
}
