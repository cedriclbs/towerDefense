package Monster;

import java.awt.Rectangle;
import static helper.Constante.Direction.*;

public abstract class Monstres {
    protected float x;
    protected float y;
    protected Rectangle bounds;
    protected int sante;
    protected int ID;
    protected int typeDeMonstre;
    protected int lastDirection;
    protected int maxSante;
    protected boolean vivant = true;
    
    public Monstres(float x, float y, int id, int typeDeMonstre) {
        this.x = x;
        this.y = y;
        this.ID = id;
        this.typeDeMonstre = typeDeMonstre;
        bounds = new Rectangle((int) x, (int) y, 32, 32);
        lastDirection = -1;
        setDefaultHealth();
    }

    public void MoveMonster(float vitesse, int direction) {
        lastDirection = direction;
        switch(direction){
            case LEFT:
                this.x -= vitesse;
            break;
            case UP:
                this.y -= vitesse;
            break;
            case RIGHT:
                this.x += vitesse;
            break;
            case DOWN:
                this.y += vitesse;
            break;
        }
        updateDegats();
    }


    private void updateDegats() {
        bounds.x = (int) x;
        bounds.y = (int) y;
    }

    private void setDefaultHealth () {
        sante = helper.Constante.Monstres.getDefaultHealth(typeDeMonstre);
        maxSante = sante;
    }

    public float getBarreDeSante () {
        return (float)sante/(float)maxSante;
    }

    public void setPosition(int x, int y) { //pour la position des monstres
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getSante(){
        return sante;
    }

    public int getID(){
        return ID;
    }

    public int getTypeMonstre(){
        return typeDeMonstre;
    }

    public int getLastDirection(){
        return lastDirection;
    }

    public void damage(int damage) {
        this.sante -= damage;
        if(sante <= 0){
            vivant = false;
        }
    }

    public boolean estVivant(){
        return vivant;
    }
}
