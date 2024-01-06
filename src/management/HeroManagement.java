package management;

import scenes.Jouer;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helper.Sauvegarde;
import object.Hero;
import java.awt.Graphics;
import static helper.Constante.Heros.*;
import Monster.*;

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
        AttaqueMonstre();
    }

    private void AttaqueMonstre() {
        for(Hero h: heros){
            for(Monstres m : jouer.getMonsterManagement().getMonstres()){
                if(m.estVivant()){
                    if(MonstreAPortee(h,m)){
                        m.damage(1);
                    }else{

                    }
                }
            }
        }
    }

    private boolean MonstreAPortee(Hero h, Monstres m) {
        int distance = helper.Conversion.getHypDistance(h.getX(), h.getY(), m.getX(), m.getY());
         
        return distance < h.getPortee();
    }

    public void ajouteHero(Hero choosedHero, int x, int y) {
        heros.add(new Hero(x,y,acc++,choosedHero.getHeroType()));
    }

    public Hero getHeroAt(int x, int y) {
        for(Hero h : heros){
            if(h.getX()==x){
                if(h.getY()==y){
                    return h;
                }
            }
        }
        return null;
    }

}
