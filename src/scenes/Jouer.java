package scenes;


import java.awt.Graphics;

import helper.NiveauConstruction;
import interfaceUser.Bar;
import main.Game;
import management.ImageManagement;
import static main.States.*;



public class Jouer extends GameScene implements interfaceScenes {
    private int[][] niveau;
    private ImageManagement imageManagement;
    private Bar bottomBar;

    public Jouer(Game game) {
        super(game);
        niveau = NiveauConstruction.getNiveauData();
        imageManagement = new ImageManagement();
        bottomBar = new Bar(0,640,640,100,this);
    }

    @Override
    public void render(Graphics graphics) {
        for(int y=0; y<niveau.length; y++) {
            for(int x=0; x<niveau[y].length;x++){
                int id = niveau[y][x];
                graphics.drawImage(imageManagement.getSprite(id),x*32,y*32,null);
            }   
        }
        bottomBar.affiche(graphics);
    }

    public ImageManagement getImageManagement() {
        return imageManagement;
    }

    @Override
	public void mouseClicked(int x, int y) {
        if(y>=640){
            bottomBar.mouseClicked(x, y);
        }

	}

	@Override
	public void mouseMoved(int x, int y) {
        if(y>=640){
            bottomBar.mouseMoved(x, y);
        }

	}

	@Override
	public void mousePressed(int x, int y) {
        if(y>=640){
            bottomBar.mousePressed(x, y);
        }

	}

	@Override
	public void mouseReleased(int x, int y) {
        if(y>=640){
            bottomBar.mouseReleased(x, y);

	    }
    }    
    
}
