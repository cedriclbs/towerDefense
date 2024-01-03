package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

public class Jouer extends GameScene implements interfaceScenes {

    public Jouer(Game game) {
        super(game);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void render(Graphics graphics) {
        // TODO Auto-generated method stub
        graphics.setColor(Color.red);
        graphics.fillRect(0,0,640,640);
    }
    
}
