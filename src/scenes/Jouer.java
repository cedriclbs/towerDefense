package scenes;

import java.awt.Graphics;

import helper.Sauvegarde;
import interfaceUser.ActionBar;
import main.Game;
import management.MonsterManagement;
import object.Point;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Jouer extends GameScene implements interfaceScenes {
    private int[][] niveau;
    private ActionBar bottomBar;
    private int xMoved, yMoved; 
    private MonsterManagement monsterManagement;
    private Point start, end;


    public Jouer(Game game) {
        super(game);
        chargerNivParDefault();
        bottomBar = new ActionBar(0,640,640,160,this);
        monsterManagement = new MonsterManagement(this, start, end);
    }


    private void chargerNivParDefault() {
        niveau = Sauvegarde.getNiveau("Nouveau_niveau");
        ArrayList<Point> nivpoints = Sauvegarde.getNiveauPoint("Nouveau_niveau");
        start = nivpoints.get(0);
        end = nivpoints.get(1);
    }

    public void setNiveau(int[][] niveau) {
        this.niveau=niveau;
    }
    
    public void update(){
        monsterManagement.update();
    }

    @Override
    public void render(Graphics graphics) {
        ChargerNiveau(graphics);
        bottomBar.affiche(graphics);
        monsterManagement.affiche(graphics);
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

    public int getImageType(int x, int y){
        int xTemp = x / 32;
		int yTemp = y / 32;
		
		if(xTemp < 0 || xTemp > 19)
			return 0;
		if(yTemp < 0 || yTemp > 19)
			return 0;
            
        int id = niveau[y/32][x/32];
        return game.getImageManagement().getImage(id).getImageType();
    }


    @Override
	public void mouseClicked(int x, int y) {
        if(y>=640){
            bottomBar.mouseClicked(x, y);
        }else{
            //monsterManagement.AjouterMonstres(x, y,0);
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
