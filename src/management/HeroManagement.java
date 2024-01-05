package management;

import scenes.Jouer;
import java.awt.image.BufferedImage;
import helper.Sauvegarde;
import object.Hero;
import java.awt.Graphics;
import static helper.Constante.Heros.*;

public class HeroManagement {
    private Jouer jouer;
    private BufferedImage[] heroimage;
    private Hero hero;
    
    public HeroManagement(Jouer jouer){
        this.jouer = jouer;

        chargerHeroimg();
        initTower();
    }

    private void initTower() {
        hero = new Hero(3*32,6*32,0,ARCHER);
    }

    private void chargerHeroimg() {
        BufferedImage atlas = Sauvegarde.getSpriteAtlas();
        heroimage = new BufferedImage[3];
        for(int i = 0; i<3;i++){
            heroimage[i] = atlas.getSubimage((4+i)*32,32,32, 32);
        }
    }

    public void affiche(Graphics graphics){
        graphics.drawImage(heroimage[ARCHER], hero.getX(), hero.getY(), null);
    }

    public void update(){
        
    }
}
