package management;

import scenes.Jouer;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Graphics2D;


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
        int distancex = (int)(h.getX() - m.getX());
        int distancey = (int)(h.getY() - m.getY());
        int distanceTotale = Math.abs(distancex) + Math.abs(distancey);
        
        float xPer = (float) Math.abs(distancex)/distanceTotale;
        float vitessex  = xPer * helper.Constante.Missiles.getVitesse(type);
        float vitessey = helper.Constante.Missiles.getVitesse(type)-vitessex;
        
        if(h.getX()>m.getX()){//tire vers la gauche
            vitessex *=-1; //change la direc
        }
        if(h.getY()>m.getY()){
            vitessey *=-1; 
        }
        float arcValue = (float) Math.atan(distancey / (float) distancex);
		float rotate = (float) Math.toDegrees(arcValue);

        if(distancex<0){
            rotate +=180;
        }
        missiles.add(new Missile(h.getX()+16, h.getY()+16, vitessex, vitessey,h.getDegats(),rotate,missileid++,type));
    }

    public void reset(){
        missiles.clear();
        missileid = 0;
    }

    public void update(){
        for(Missile miss : missiles){
            if(miss.isActive()){
                miss.Bouger();
                if(MissileToucheMonstre(miss)){
                    miss.setActive(false);
                }else{
                    
                }
            }
                
        }

    }

    private boolean MissileToucheMonstre(Missile miss) {
        for(Monstres m : jouer.getMonsterManagement().getMonstres()){
            if(m.getBounds().contains(miss.getPos())){
                m.damage(miss.getDegats());
                return true;
            }
        }
        return false;
    }

    public void affiche(Graphics graphics){
        Graphics2D g2d = (Graphics2D)graphics;
        
        for(Missile miss : missiles){
            if(miss.isActive()){
                g2d.translate(miss.getPos().x,miss.getPos().y );
                g2d.rotate(Math.toRadians(miss.getRotation()));
                g2d.drawImage(missileimages[miss.getMissileType()], -16, -16, null);
                g2d.rotate(-Math.toRadians(miss.getRotation()));
                g2d.translate(-miss.getPos().x,-miss.getPos().y );
            }
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
