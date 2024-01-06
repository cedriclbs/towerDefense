package object;

import java.awt.geom.Point2D;

public class Missile {
    private Point2D.Float pos;
    private boolean activer = true;
    private int id;
    private int typeMissile;
    private float vitessex;
    private float vitessey;

    public Missile(float x, float y,float vitessex, float vitessey, int id, int typeMissile){
        pos = new Point2D.Float(x, y);
        this.id = id;
        this.vitessex = vitessex;
        this.vitessey = vitessey;
        this.typeMissile = typeMissile;
    }

    public void Bouger(){
        pos.x = vitessex;
        pos.y = vitessey;
    }

    public int getMissType(){
        return typeMissile;
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
