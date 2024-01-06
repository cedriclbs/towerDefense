package management;

import scenes.Jouer;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helper.Sauvegarde;
import object.Hero;
import java.awt.Graphics;
import static helper.Constante.Heros.*;

public class HeroManagement {
    private Jouer jouer;
    private BufferedImage[] heroimage;
    private ArrayList<Hero> heros = new ArrayList<>();
    private int acc = 0;
    
    public HeroManagement(Jouer jouer){
        this.jouer = jouer;

        chargerHeroimg();
    }

    public BufferedImage[] getHeroimage() {
        return heroimage;
    }

    
    private void chargerHeroimg() {
        BufferedImage atlas = Sauvegarde.getSpriteAtlas();
        heroimage = new BufferedImage[3];
        for(int i = 0; i<3;i++){
            heroimage[i] = atlas.getSubimage((4+i)*32,32,32, 32);
        }
    }

    public void affiche(Graphics graphics){
        for (Hero hero : heros){
            graphics.drawImage(heroimage[hero.getHeroType()], hero.getX(), hero.getY(), null);
        }
        //
    }

    public void update(){
        
    }

    public void ajouteHero(Hero choosedHero, int x, int y) {
        heros.add(new Hero(x,y,acc++,choosedHero.getHeroType()));
    }





    
}
