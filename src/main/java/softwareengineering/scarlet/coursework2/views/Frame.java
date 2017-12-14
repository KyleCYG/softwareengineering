package softwareengineering.scarlet.coursework2.views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Wrapper around JFrame.
 *
 * Used purely as a point to hang the Panel on.
 *
 * @author Gordon Rennie
 * @author Dan Cosser
 */
public class Frame extends JFrame {
  private static final long serialVersionUID = 1L;

  public Frame(Panel panel, JTextArea textArea) {
    this.build(panel,textArea);
  }

  /**
   * Instantiates the Frame, setting various global window options
   *
   * @param panel
   */
  public void build(Panel panel, JTextArea textArea) {
    this.add(panel, BorderLayout.CENTER);
    this.add(textArea,BorderLayout.SOUTH);
    setSize(700, 730);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setFocusTraversalKeysEnabled(false); // stops treating arrow keys/tabs as changing focus
  }
}
