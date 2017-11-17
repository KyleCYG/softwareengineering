package softwareengineering.scarlet.coursework2.coursework2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;

/**
 *
 * @author george
 */
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

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        
        Font titleFont = new Font("Monospaced", Font.PLAIN, 24);
        g2d.setFont(titleFont);
        
        g2d.drawString("GAME TITLE", 180, 180);
        
        Font menuFont = new Font("Monospaced", Font.PLAIN, 12);
        g2d.setFont(menuFont);
        
        g2d.drawString("→ New Game", 180, 250);
        g2d.drawString("  View Leaderboard", 180, 270);
        g2d.drawString("  Quit", 180, 290);
       

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);

    }

}
