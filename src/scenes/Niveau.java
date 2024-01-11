package scenes;

import java.awt.Color;
import java.awt.Graphics;

import interfaceUser.Button;
import main.Game;
import static main.States.*;


public class Niveau extends GameScene implements interfaceScenes {

    private Button menuButton;

    public Niveau(Game game) {
        super(game);
        menuButton = new Button("Menu", 2, 2, 100, 30);
    }

    @Override
    public void render(Graphics graphics) {
        // TODO Auto-generated method stub
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0,0,640,640);
        menuButton.draw(graphics);
    }

    @Override
    public void mouseClicked(int x, int y) {
        // TODO Auto-generated method stub
        if(menuButton.getRectangle().contains(x,y)){
            setStates(MENU);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        // TODO Auto-generated method stub
        menuButton.setMouseOnIt(false);
		if (menuButton.getRectangle().contains(x, y)){
			menuButton.setMouseOnIt(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        // TODO Auto-generated method stub
        if(menuButton.getRectangle().contains(x,y)){
            menuButton.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    @Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
	}    

    private void resetButtons() {
        menuButton.resetBooleans();
    }
    
}
