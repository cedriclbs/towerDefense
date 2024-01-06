package management;

import scenes.Jouer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Monster.*;
import helper.Sauvegarde;
import object.Point;

import static helper.Constante.Direction.*;
import static helper.Constante.Images.*;
import static helper.Constante.Monstres.*;


public class MonsterManagement {
    private Jouer jouer;
    private BufferedImage[] monstreimg;
    private ArrayList<Monstres> monstre = new ArrayList<>();
    //private float vitesse = 0.5f;
    private Point start, end;
    private int barreDeSanteWidth = 20;

    
    public MonsterManagement(Jouer jouer, Point start, Point end){
        this.jouer = jouer;
        monstreimg = new BufferedImage[4];
        this.start = start;
        this.end=end;
        
        AjouterMonstres(ARAIGNEE);
        AjouterMonstres(COCHON);
        AjouterMonstres(MONSTREVERT);
        AjouterMonstres(RHINO);

        ChargerMonstresimg();
    }
    
    private void ChargerMonstresimg() {
        BufferedImage res = Sauvegarde.getSpriteAtlas();

        for (int i = 0 ; i< 4 ;i++){
            monstreimg[i] = res.getSubimage(i*32, 32,32, 32);
        }
    }

    public void AjouterMonstres(int type){

        int x = start.getxPoint()*32;
        int y = start.getyPoint()*32;
        
        switch (type){
            case ARAIGNEE:
                monstre.add(new Araignee(x, y, 0));
                break;
            case COCHON : 
                monstre.add(new Cochon(x, y, 0));
                break;
            case MONSTREVERT : 
                monstre.add(new MonstreVert(x, y, 0));
                break;
            case RHINO : 
                monstre.add(new Rhino(x, y, 0));
                break;
        }
    }

    public void update(){
        for(Monstres m: monstre){
            updateMouvementMonstre(m);
        }

    }

    private void updateMouvementMonstre (Monstres m) {

        if (m.getLastDirection()==-1){
            setNewDirectionMove(m);
        }

        int newX = (int)(m.getX() + getSpeedH(m.getLastDirection(),m.getTypeMonstre()));
        int newY = (int)(m.getY() + getSpeedW(m.getLastDirection(),m.getTypeMonstre()));

        if(getImageType(newX, newY) == ROUTE_IMAGE){
            //continue sur la meme dir
            m.MoveMonster(getVitesse(m.getTypeMonstre()),m.getLastDirection());
        }
        else if(EstFin(m)){
            System.out.println("Vies perdues");
        }
        else{
            //cherche une new dir
            setNewDirectionMove(m);
        }
       
    }

    private void setNewDirectionMove(Monstres m) {
        int dir = m.getLastDirection();
        int CorX = (int) (m.getX()/32);
        int CorY = (int) (m.getY()/32);

        MonstreCoordoCorrect(m,dir,CorX,CorY);

        if(EstFin(m)){
            return;
        }

        if(dir == LEFT || dir == RIGHT){
            int newY = (int)(m.getY() + getSpeedW(UP,m.getTypeMonstre()));
            if(getImageType((int)m.getX(), newY) == ROUTE_IMAGE){
                m.MoveMonster(getVitesse(m.getTypeMonstre()), UP);
            }
            else{
                m.MoveMonster(getVitesse(m.getTypeMonstre()), DOWN);
            }
        }
        else{
            int newX = (int)(m.getX() + getSpeedH(RIGHT,m.getTypeMonstre()));
            if(getImageType(newX, (int)m.getY()) == ROUTE_IMAGE ){
                m.MoveMonster(getVitesse(m.getTypeMonstre()), RIGHT);
            }
            else{
                m.MoveMonster(getVitesse(m.getTypeMonstre()), LEFT);
            }
        }
    }

    private void MonstreCoordoCorrect(Monstres m, int direction, int corX, int corY) {
        
        switch(direction){
            case RIGHT:
                if(corX<19){
                    corX++;
                }
            break;
            case DOWN:
                if(corY<19){
                    corY++;
                }
            break;
        }
        m.setPosition(corX*32, corY*32);
    }

    private boolean EstFin(Monstres m) {
        if (m.getX()==end.getxPoint()*32){
            if(m.getY()==end.getyPoint()*32){
                return true;
            }
        }
        return false;
    }

    private int getImageType(int x, int y) {
        return jouer.getImageType(x,y);
    }

    private float getSpeedW(int direc, int TypeMonstre) {
        if(direc == UP){
            return -getVitesse(TypeMonstre);
        }
        else if(direc == DOWN){
            return getVitesse(TypeMonstre) + 32;
        }
        return 0;
    }

    private float getSpeedH(int direc, int TypeMonstre) {
        if(direc == LEFT){
            return -getVitesse(TypeMonstre);
        }
        else if(direc == RIGHT){
            return getVitesse(TypeMonstre) +32;
        }
        return 0;
    }

    public void affiche(Graphics graphics){
        for(Monstres m: monstre){
           afficheMonstre(m, graphics);
           afficheBarreDeSante(m, graphics);
        }
    }

    private void afficheBarreDeSante(Monstres m, Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect((int)m.getX()+16-getNewBarreWidth(m)/2, (int)m.getY()-10, getNewBarreWidth(m), 3);
    }


    private int getNewBarreWidth (Monstres m){
        return (int) (this.barreDeSanteWidth*m.getBarreDeSante());
    }

    private void afficheMonstre(Monstres m, Graphics graphics) {
        graphics.drawImage(monstreimg[m.getTypeMonstre()], (int)m.getX(), (int)m.getY(), null);
    }
}
