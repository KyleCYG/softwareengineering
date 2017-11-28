package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import softwareengineering.scarlet.coursework2.controllers.GameController;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.views.game.GameView;

public class InputNamePanel extends JPanel implements KeyListener, ActionListener {
  private static final long serialVersionUID = 1L;
  private JTextField name;
  private JLabel lblName;
  private JButton btnEnter;

  public InputNamePanel() {
    InitInputNamePanel();
  }

  private void InitInputNamePanel() {
    name = new JTextField(20);
    lblName = new JLabel();
    btnEnter = new JButton();
    name.requestFocus();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    lblName.setText("Enter Player Name: ");
    lblName.setBounds(100, 250, 200, 25);
    btnEnter.setText("Enter");
    btnEnter.setBounds(170, 300, 100, 25);
    btnEnter.addActionListener(this);
    name.setBounds(250, 250, 200, 25);
    name.addKeyListener(this);
    this.add(lblName);
    this.add(name);
    this.add(btnEnter);

    addKeyListener(this);
    setFocusable(true);

    // does not get arrow keys as input
    setFocusTraversalKeysEnabled(false);
  }

  /**
   * Implements logic for key presses when on menu screen.
   * 
   * @param event An event generated when user presses key.
   */
  public void keyPressed(KeyEvent event) {
    if (event.getKeyCode() == KeyEvent.VK_ENTER) {
      if (validateName())
        createGame();
    }
  }

  private void createGame() {
    Dungeon dungeon = new Dungeon(25, 25, 1);
    GameController controller = new GameController("Scarlet Pimpernel");
    new GameView(controller, dungeon);
  }

  private boolean validateName() {
    boolean validate = false;
    String n = this.name.getText();
    String regex = "^[a-zA-Z0-9]*$";

    if (n.matches(regex) && !n.isEmpty()) {
      validate = true;
    } else {
      validate = false;
    }
    return validate;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (validateName())
      createGame();
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // Unnecessary override
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // Unnecessary override
  }
}
