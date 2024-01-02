package main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

  public GamePanel() {
  }


  public void paintComponent (Graphics graphics) {
    super.paintComponent(graphics);

    graphics.setColor(Color.BLUE);
    graphics.fillRect(50,50,100,100);
  }

}
