package Monster;

import java.awt.Rectangle;
import static helper.Constante.Direction.*;

public class Monstres {
    private float x;
    private float y;
    private Rectangle bounds;
    private int pv;
    private int id;
    private int typedemonstre;
    private int lastdirection;
    
    public Monstres(float x, float y, int id, int typedemonstre) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.typedemonstre = typedemonstre;
        bounds = new Rectangle((int) x, (int) y, 32, 32);
        lastdirection = RIGHT;
    }

    public void MoveMonster(float vitesse, int direction) {
        lastdirection = direction;
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

    public int getPv(){
        return pv;
    }

    public int getId(){
        return id;
    }

    public int getTypeMonstre(){
        return typedemonstre;
    }

    public int getLastdirection(){
        return lastdirection;
    }

}
