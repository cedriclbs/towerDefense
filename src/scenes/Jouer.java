package scenes;


import java.awt.Graphics;

import helper.NiveauConstruction;
import interfaceUser.Button;
import main.Game;
import management.ImageManagement;
import static main.States.*;


public class Jouer extends GameScene implements interfaceScenes {
    private int[][] niveau;
    private ImageManagement imageManagement;
    private Button menuButton;

    public Jouer(Game game) {
        super(game);
        menuButton = new Button("Menu", 2, 2, 100, 30);
        niveau = NiveauConstruction.getNiveauData();
        imageManagement = new ImageManagement();
    }

    @Override
    public void render(Graphics graphics) {
        for(int y=0; y<niveau.length; y++) {
            for(int x=0; x<niveau[y].length;x++){
                int id = niveau[y][x];
                graphics.drawImage(imageManagement.getSprite(id),x*32,y*32,null);
            }   
        }
        menuButton.draw(graphics);
    }

    @Override
	public void mouseClicked(int x, int y) {
		if (menuButton.getRectangle().contains(x, y)){ 
			setStates(MENU);
        }

	}

	@Override
	public void mouseMoved(int x, int y) {
		menuButton.setMouseOnIt(false);
		if (menuButton.getRectangle().contains(x, y)){
			menuButton.setMouseOnIt(true);
        }

	}

	@Override
	public void mousePressed(int x, int y) {
		if (menuButton.getRectangle().contains(x, y)){
			menuButton.setMousePressed(true);
        }

	}

	@Override
	public void mouseReleased(int x, int y) {
		menuButton.resetBooleans();

	}
    
}
