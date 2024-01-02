package main;

import javax.swing.JFrame;

public class Game extends JFrame {

  private GamePanel gamePanel;


  public Game() {
    setVisible(true);
    setSize(600,600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    gamePanel = new GamePanel();
    add(gamePanel);
  }

  public static void main(String[] args) {
    System.out.println("Début du jeu");
    Game towerdefense = new Game();
    System.out.println("Fin du jeu");

  }

}
