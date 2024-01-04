package management;

import scenes.Jouer;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Monster.Monstres;
import helper.Sauvegarde;
import static helper.Constante.Direction.*;
import static helper.Constante.Images.*;

public class MonsterManagement {
    private Jouer jouer;
    private BufferedImage[] monstreimg;
    private ArrayList<Monstres> monstre = new ArrayList<>();
    private float vitesse = 0.5f;
    
    public MonsterManagement(Jouer jouer){
        this.jouer = jouer;
        monstreimg = new BufferedImage[4];
        AjouterMonstres(3*32, 9*32);
        ChargerMonstresimg();
    }
    
    private void ChargerMonstresimg() {
        BufferedImage res = Sauvegarde.getSpriteAtlas();
        monstreimg[0] = res.getSubimage(0, 32,32, 32);
        monstreimg[1] = res.getSubimage(32, 32,32, 32);
        monstreimg[2] = res.getSubimage(2*32, 32,32, 32);
        monstreimg[3] = res.getSubimage(3*32, 32,32, 32);
    }

    public void AjouterMonstres(int x, int y){
        monstre.add(new Monstres(x, y, 0, 0));
    }

    public void update(){
        for(Monstres m: monstre){
            if(isNextImageRoad(m)){
                
            }
        }

    }

    private boolean isNextImageRoad(Monstres m) {
        int newX = (int)(m.getX() + getSpeedH(m.getLastdirection()));
        int newY = (int)(m.getY() + getSpeedW(m.getLastdirection()));

        if(getImageType(newX, newY) == ROUTE_IMAGE){
            //continue sur la meme dir
            m.MoveMonster(vitesse,m.getLastdirection());
        }
        else if(EstFin(m)){
            //est à la fin
        }
        else{
            //cherche une new dir
            setNewDirectionMove(m);
        }
       
        return false;
    }

    private void setNewDirectionMove(Monstres m) {
        int dir = m.getLastdirection();
        int CorX = (int) (m.getX()/32);
        int CorY = (int) (m.getY()/32);

        MonstreCoordoCorrect(m,dir,CorX,CorY);

        if(dir == LEFT || dir == RIGHT){
            int newY = (int)(m.getY() + getSpeedW(UP));
            if(getImageType((int)m.getX(), newY) == ROUTE_IMAGE){
                m.MoveMonster(vitesse, UP);
            }
            else{
                m.MoveMonster(vitesse, DOWN);
            }
        }
        else{
            int newX = (int)(m.getX() + getSpeedH(RIGHT));
            if(getImageType(newX, (int)m.getY()) == ROUTE_IMAGE ){
                m.MoveMonster(vitesse, RIGHT);
            }
            else{
                m.MoveMonster(vitesse, LEFT);
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
        return false;
    }

    private int getImageType(int x, int y) {
        return jouer.getImageType(x,y);
    }

    private float getSpeedW(int direc) {
        if(direc == UP){
            return -vitesse;
        }
        else if(direc == DOWN){
            return vitesse + 32;
        }
        return 0;
    }

    private float getSpeedH(int direc) {
        if(direc == LEFT){
            return -vitesse;
        }
        else if(direc == RIGHT){
            return vitesse +32;
        }
        return 0;
    }

    public void affiche(Graphics graphics){
        for(Monstres m: monstre){
           afficheMonstre(m, graphics);
        }
    }

    private void afficheMonstre(Monstres m, Graphics graphics) {
        graphics.drawImage(monstreimg[0], (int)m.getX(), (int)m.getY(), null);
    }
}
