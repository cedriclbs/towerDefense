package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

public class Parametres extends GameScene implements interfaceScenes {

    public Parametres(Game game) {
        super(game);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void render(Graphics graphics) {
        // TODO Auto-generated method stub
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0,0,640,640);
    }
    
}
