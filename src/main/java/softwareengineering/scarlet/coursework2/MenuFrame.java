package softwareengineering.scarlet.coursework2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;


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

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                MenuFrame menu = new MenuFrame();
                menu.setVisible(true);

            }

        });
    }
}

class MenuPanel extends JPanel {
  
    private void drawOptions(Graphics2D g2d) {
       
        Font menuFont = new Font("Monospaced", Font.PLAIN, 12);
        g2d.setFont(menuFont);
        
        g2d.drawString("→ New Game", 180, 250);
        g2d.drawString("  View Leaderboard", 180, 270);
        g2d.drawString("  Quit", 180, 290);

    }
    
    void drawTitle(Graphics2D g2d) {
      String titleArt = 
          "  ______                                                  ______                                   __     \n" + 
          " /      \\                                                /      \\                                 /  |    \n" + 
          "/$$$$$$  | __    __   ______    ______    ______        /$$$$$$  | __    __   ______    _______  _$$ |_   \n" + 
          "$$ \\__$$/ /  |  /  | /      \\  /      \\  /      \\       $$ |  $$ |/  |  /  | /      \\  /       |/ $$   |  \n" + 
          "$$      \\ $$ |  $$ |/$$$$$$  |/$$$$$$  |/$$$$$$  |      $$ |  $$ |$$ |  $$ |/$$$$$$  |/$$$$$$$/ $$$$$$/   \n" + 
          " $$$$$$  |$$ |  $$ |$$ |  $$ |$$    $$ |$$ |  $$/       $$ |_ $$ |$$ |  $$ |$$    $$ |$$      \\   $$ | __ \n" + 
          "/  \\__$$ |$$ \\__$$ |$$ |__$$ |$$$$$$$$/ $$ |            $$ / \\$$ |$$ \\__$$ |$$$$$$$$/  $$$$$$  |  $$ |/  |\n" + 
          "$$    $$/ $$    $$/ $$    $$/ $$       |$$ |            $$ $$ $$< $$    $$/ $$       |/     $$/   $$  $$/ \n" + 
          " $$$$$$/   $$$$$$/  $$$$$$$/   $$$$$$$/ $$/              $$$$$$  | $$$$$$/   $$$$$$$/ $$$$$$$/     $$$$/  \n" + 
          "                    $$ |                                     $$$/                                         \n" + 
          "                    $$ |                                                                                  \n" + 
          "                    $$/                                                                                   ";
      
      
      Font titleFont = new Font("Monospaced", Font.BOLD, 6);
      g2d.setFont(titleFont);
      
      // set title draw coordinates
      int x = 50;
      int y = 100;
      
      // print line by line; N.B. Graphics.drawString method does not break
      //    across lines, so we must do it for it.
      for (String line : titleArt.split("\n")) {
          g2d.drawString(line, x, y += g2d.getFontMetrics().getHeight());
      }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;

        drawOptions(g2d);
        drawTitle(g2d);
        
    }

}
