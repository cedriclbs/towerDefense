package scenes;

import java.awt.Graphics;

import helper.Sauvegarde;
import interfaceUser.ActionBar;
import main.Game;
import java.awt.image.BufferedImage;

public class Jouer extends GameScene implements interfaceScenes {
    private int[][] niveau;
    private ActionBar bottomBar;
    private int xMoved, yMoved; 

    public Jouer(Game game) {
        super(game);
        chargerNivParDefault();
        bottomBar = new ActionBar(0,640,640,100,this);
  
    }

    private void chargerNivParDefault() {
        niveau = Sauvegarde.getNiveau("Nouveau_niveau");
    }

    public void setNiveau(int[][] niveau) {
        this.niveau=niveau;
    }


    @Override
    public void render(Graphics graphics) {
        ChargerNiveau(graphics);
        bottomBar.affiche(graphics);
    }

    private void ChargerNiveau(Graphics graphics) {
        for(int y=0; y<niveau.length; y++) {
            for(int x=0; x<niveau[y].length;x++){
                int id = niveau[y][x];
                graphics.drawImage(getSprite(id),x*32,y*32,null);
            }   
        }
    }

    private BufferedImage getSprite(int spriteid){
        return game.getImageManagement().getSprite(spriteid);
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
        } else {
            xMoved = (x/32)*32;
            yMoved = (y/32)*32;
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
        bottomBar.mouseReleased(x, y);
    }

	@Override
	public void mouseDragged(int x, int y) {

	} 
}
