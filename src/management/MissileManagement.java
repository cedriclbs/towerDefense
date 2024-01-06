package management;

import scenes.Jouer;
import java.awt.Graphics;
import java.util.ArrayList;

import Monster.Monstres;
import helper.Sauvegarde;

import java.awt.image.BufferedImage;

import object.Hero;
import object.Missile;
import static helper.Constante.Heros.*;
import static helper.Constante.Missiles.*;

public class MissileManagement {
    private Jouer jouer;
    private ArrayList<Missile> missiles = new ArrayList<>();
    private BufferedImage[] missileimages;
    private int missileid=0;

    public MissileManagement(Jouer jouer){
        this.jouer = jouer;
        importImages();
    }

    private void importImages(){
        BufferedImage atlas = Sauvegarde.getSpriteAtlas();
        missileimages = new BufferedImage[3];

        for(int i=0; i<3;i++){
            missileimages[i] =atlas.getSubimage((7+i)*32,32 , 32, 32);
        }
    }

    public void NouveauMissile(Hero h, Monstres m){
        int type = getMissileType(h);
        int distancex = (int)Math.abs(h.getX() - m.getX());
        int distancey = (int)Math.abs(h.getY() - m.getY());
        int distanceTotale = distancex + distancey;
        
        float xPer = (float) distancex/distanceTotale;
        float vitessex  = xPer * helper.Constante.Missiles.getVitesse(type);
        float vitessey = helper.Constante.Missiles.getVitesse(type)-vitessex;
        
        if(h.getX()>m.getX()){//tire vers la gauche
            vitessex *=-1; //change la direc
        }
        if(h.getY()>m.getY()){
            vitessey *=-1; 
        }
        System.out.println(h.getX());
        missiles.add(new Missile(h.getX()+16, h.getY()+16, vitessex, vitessey,missileid++,type));
    }

    public void update(){
        for(Missile miss : missiles){
            miss.Bouger();
        }

    }

    public void affiche(Graphics graphics){
        for(Missile miss : missiles){
            graphics.drawImage(missileimages[miss.getMissType()], (int)miss.getPos().x, (int)miss.getPos().y, null);
        }
    }

    private int getMissileType(Hero h) {
        switch(h.getHeroType()){
            case ARCHER:
                return FLECHE;
            case CANNON:   
                return BOMBE; 
            case MAGE:
                return GIVRE;
        }
        return 0;
    }

}
