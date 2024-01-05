package main;

import javax.swing.JPanel;

import inputs.KeyboardListener;
import inputs.MyMouseListener;

import java.awt.Dimension;
import java.awt.Graphics;

   

public class GameScreen extends JPanel{
    private Game game;
    private KeyboardListener clavier;
    private MyMouseListener souris;
    //private Random random = new Random();
    private Dimension gameScreenDimension = new Dimension (320*2,800);



    public GameScreen(Game game){
        this.game = game;

        setMinimumSize(gameScreenDimension);
        setPreferredSize(gameScreenDimension);
        setMaximumSize(gameScreenDimension);
    }

    public void inputsStart () {
        souris = new MyMouseListener(game);
        addMouseListener(souris);
        addMouseMotionListener(souris);
        clavier=new KeyboardListener();
        addKeyListener(clavier);
        requestFocus();
    }

    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.getRender().render(g);
        //g.drawImage(sprites.get(19), 0, 0, null);
        //g.drawImage(img.getSubimage(32*9, 32, 32, 32), 0, 0,null);
    }
}
