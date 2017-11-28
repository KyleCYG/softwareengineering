package softwareengineering.scarlet.coursework2.views;

import java.awt.Font;
import java.awt.Graphics2D;
import softwareengineering.scarlet.coursework2.models.Menu;

public class MenuView implements View {
  private static final Font TITLE_FONT = new Font("Monospaced", Font.BOLD, 6);
  private static final Font MENU_FONT = new Font("Monospaced", Font.PLAIN, 12);
  private static final int ySpacing = 20; // height between menu option
  private Menu model;

  @Override
  public void render(Graphics2D g2d) {
    this.drawTitle(g2d);
    this.drawOptions(g2d);
    this.drawMenuArrow(g2d);
  }
  
  /**
   * Renders the menu options.
   * 
   * @param g2d
   */
  private void drawOptions(Graphics2D g2d) {
    g2d.setFont(MenuView.MENU_FONT);
    g2d.drawString("  New Game", 180, 250);
    g2d.drawString("  View Leaderboard", 180, 270);
    g2d.drawString("  Quit", 180, 290);
  }
  
  /**
   * Renders the menu title.
   * 
   * @param g2d
   */
  private void drawTitle(Graphics2D g2d) {
    String titleArt =
        " ________  __                            __                   ______                                   __     \n"
            + "/        |/  |                          /  |                 /      \\                                 /  |    \n"
            + "$$$$$$$$/ $$ |____    ______    _______ $$/   _______       /$$$$$$  | __    __   ______    _______  _$$ |_   \n"
            + "   $$ |   $$      \\  /      \\  /       |/  | /       |      $$ |  $$ |/  |  /  | /      \\  /       |/ $$   |  \n"
            + "   $$ |   $$$$$$$  |/$$$$$$  |/$$$$$$$/ $$ |/$$$$$$$/       $$ |  $$ |$$ |  $$ |/$$$$$$  |/$$$$$$$/ $$$$$$/   \n"
            + "   $$ |   $$ |  $$ |$$    $$ |$$      \\ $$ |$$      \\       $$ |_ $$ |$$ |  $$ |$$    $$ |$$      \\   $$ | __ \n"
            + "   $$ |   $$ |  $$ |$$$$$$$$/  $$$$$$  |$$ | $$$$$$  |      $$ / \\$$ |$$ \\__$$ |$$$$$$$$/  $$$$$$  |  $$ |/  |\n"
            + "   $$ |   $$ |  $$ |$$       |/     $$/ $$ |/     $$/       $$ $$ $$< $$    $$/ $$       |/     $$/   $$  $$/ \n"
            + "   $$/    $$/   $$/  $$$$$$$/ $$$$$$$/  $$/ $$$$$$$/         $$$$$$  | $$$$$$/   $$$$$$$/ $$$$$$$/     $$$$/  \n"
            + "                                                                 $$$/                                         ";

    g2d.setFont(MenuView.TITLE_FONT);

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
   * Shows the arrow on the appropriate option.
   * 
   * @param g2d
   */
  private void drawMenuArrow(Graphics2D g2d) {
    g2d.setFont(MenuView.MENU_FONT);
    g2d.drawString("→", 180, 250 + model.getOption() * ySpacing);
  }
  
  public void setModel(Menu menu) {
    this.model = menu;
  }
}
