package scenes;

import java.awt.Color;
import java.awt.Graphics;

import helper.Sauvegarde;
import interfaceUser.Button;
import main.Game;
import static main.States.*;


public class GameOver extends GameScene implements interfaceScenes {

    private Button buttonRejouer, buttonMenu;
    private Jouer jouer;

    public GameOver(Game game, Jouer jouer) {
        super(game);
        this.jouer = jouer;
        int widthForText = 150;
		int x = 640 / 2 - widthForText / 2;
		int y = 260;
		int yOffset = 100;
		int heightForText = widthForText / 3;

        buttonRejouer = new Button("Rejouer", x, y+100, widthForText, heightForText);
        buttonMenu = new Button("Menu", x, y+yOffset+100,widthForText,heightForText); 
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (buttonMenu.getRectangle().contains(x,y)){
            jouer.reset(jouer.getCurrentDifficulty());
            setStates(MENU);
        } else if (buttonRejouer.getRectangle().contains(x,y)){
            jouer.reset(jouer.getCurrentDifficulty());
            setStates(JOUER);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        buttonMenu.setMouseOnIt(false);
        buttonRejouer.setMouseOnIt(false);

        if (buttonMenu.getRectangle().contains(x,y)){
            buttonMenu.setMouseOnIt(true);
        } else if (buttonRejouer.getRectangle().contains(x,y)){
            buttonRejouer.setMouseOnIt(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        buttonMenu.setMousePressed(false);
        buttonRejouer.setMousePressed(false);

        if (buttonMenu.getRectangle().contains(x,y)){
            buttonMenu.setMousePressed(true);
        } else if (buttonRejouer.getRectangle().contains(x,y)){
            buttonRejouer.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        buttonMenu.resetBooleans();
        buttonRejouer.resetBooleans();
    }

    @Override
    public void mouseDragged(int x, int y) {
        
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Sauvegarde.getFondGameOver(), 0, 0,null);
        buttonRejouer.draw(graphics);
        buttonMenu.draw(graphics);
    }
    
}
