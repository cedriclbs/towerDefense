package object;

import java.awt.geom.Point2D;

public class Missile {

	private Point2D.Float pos;
	private int id, missileType, degats;
	private float vitesseX, vitesseY, rotation;
	private boolean active = true;

	public Missile(float x, float y, float vitesseX, float vitesseY,int degats,float rotation, int id, int missileType) {
		pos = new Point2D.Float(x, y);
		this.vitesseX = vitesseX;
		this.vitesseY = vitesseY;
        this.degats = degats;
		this.rotation = rotation;
		this.id = id;
		this.missileType = missileType;
	}

	public void Bouger() {
		pos.x += vitesseX;
		pos.y += vitesseY;
	}

	public Point2D.Float getPos() {
		return pos;
	}

	public void setPos(Point2D.Float pos) {
		this.pos = pos;
	}

	public int getId() {
		return id;
	}

	public int getMissileType() {
		return missileType;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

    public int getDegats() {
        return degats;
    }

	public float getRotation(){
		return rotation;
	}

}
