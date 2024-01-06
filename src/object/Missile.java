package object;

import java.awt.geom.Point2D;

public class Missile {
    private Point2D.Float pos;
    private boolean activer = true;
    private int id, typeMissile;

    public Missile(float x, float y, int id, int typeMissile){
        pos = new Point2D.Float(x, y);
        this.id = id;
        this.typeMissile = typeMissile;
    }

    public void Bouger(float x,float y){
        pos.x = x;
        pos.y = y;
    }

    public Point2D.Float getPos() {
        return pos;
    }

    public void setPos(Point2D.Float pos) {
        this.pos = pos;
    }

    public boolean isActiver() {
        return activer;
    }

    public void setActiver(boolean activer) {
        this.activer = activer;
    }    
}
