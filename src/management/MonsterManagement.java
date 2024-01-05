package management;

import scenes.Jouer;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Monster.*;
import helper.Sauvegarde;
import static helper.Constante.Direction.*;
import static helper.Constante.Images.*;
import static helper.Constante.Monstres.*;

public class MonsterManagement {
    private Jouer jouer;
    private BufferedImage[] monstreimg;
    private ArrayList<Monstres> monstre = new ArrayList<>();
    private float vitesse = 0.5f;
    
    public MonsterManagement(Jouer jouer){
        this.jouer = jouer;
        monstreimg = new BufferedImage[4];
        AjouterMonstres(0*32, 19*32,ARAIGNEE);
        AjouterMonstres(2*32, 8*32,COCHON);
        AjouterMonstres(8*32, 8*32,MONSTREVERT);
        AjouterMonstres(8*32, 14*32,RHINO);

        ChargerMonstresimg();
    }
    
    private void ChargerMonstresimg() {
        BufferedImage res = Sauvegarde.getSpriteAtlas();

        for (int i = 0 ; i< 4 ;i++){
            monstreimg[i] = res.getSubimage(i*32, 32,32, 32);
        }
    }

    public void AjouterMonstres(int x, int y, int type){
        
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

        if (m.getLastdirection()==-1){
            setNewDirectionMove(m);
        }

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
        graphics.drawImage(monstreimg[m.getTypeMonstre()], (int)m.getX(), (int)m.getY(), null);
    }
}
