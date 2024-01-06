package scenes;

import java.awt.Graphics;

import helper.Sauvegarde;
import interfaceUser.ActionBar;
import main.Game;
import management.HeroManagement;
import management.MonsterManagement;
import object.Hero;
import object.Point;
import static helper.Constante.Images.*;


import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Jouer extends GameScene implements interfaceScenes {


    private int[][] niveau;
    private ActionBar bottomBar;
    private int xMoved, yMoved; 
    private MonsterManagement monsterManagement;
    private HeroManagement heroManagement;
    private Point start, end;
    private Hero choosedHero;


    public Jouer(Game game) {
        super(game);
        chargerNivParDefault();
        bottomBar = new ActionBar(0,640,640,160,this);
        monsterManagement = new MonsterManagement(this, start, end);
        heroManagement = new HeroManagement(this);
    }


    private void chargerNivParDefault() {
        niveau = Sauvegarde.getNiveau("Nouveau_niveau");
        ArrayList<Point> nivpoints = Sauvegarde.getNiveauPoint("Nouveau_niveau");
        start = nivpoints.get(0);
        end = nivpoints.get(1);
    }

    public MonsterManagement getMonsterManagement() {
        return monsterManagement;
    }


    public HeroManagement getHeroManagement() {
        return heroManagement;
    }
    
    public void setNiveau(int[][] niveau) {
        this.niveau=niveau;
    }
    
    public void update(){
        monsterManagement.update();
        heroManagement.update();
    }

    @Override
    public void render(Graphics graphics) {
        ChargerNiveau(graphics);
        bottomBar.affiche(graphics);
        monsterManagement.affiche(graphics);
        heroManagement.affiche(graphics);
        afficheChoosedHero(graphics);
    }

    private void afficheChoosedHero(Graphics graphics) {
        if (choosedHero != null){
            graphics.drawImage(heroManagement.getHeroimage()[choosedHero.getHeroType()], xMoved, yMoved,game);
        }
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
            if(this.choosedHero!=null && EstSurHerbe(xMoved,yMoved)){
                heroManagement.ajouteHero(choosedHero, xMoved, yMoved);
                choosedHero = null;
            }
        }
	}


    private boolean EstSurHerbe(int x, int y) {
        return game.getImageManagement().getImage(niveau[y/32][x/32]).getImageType()==HERBE_IMAGE;
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


    public void setChoosenHero(Hero choosedHero) {
        this.choosedHero = choosedHero;
    } 
}
