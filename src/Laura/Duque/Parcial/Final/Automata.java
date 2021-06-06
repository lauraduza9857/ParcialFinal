package Laura.Duque.Parcial.Final;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Automata{

	protected PApplet app;
	protected PVector pos;
	protected PVector vel;
	protected float rad;
	protected boolean isALive = true;

	public Automata(PApplet app) {
		// TODO Auto-generated constructor stub
		this.app = app;
		pos = new PVector(app.random(rad, app.width + rad),app.random(rad, app.height + rad));
		vel = new PVector(0,0);
	}

	public abstract void show();

	public float getPosX() {
		return pos.x;
	}

	public void setPosX(float posX) {
		this.pos.x = posX;
	}

	public float getPosY() {
		return pos.y;
	}

	public void setPosY(float posY) {
		this.pos.y = posY;
	}

	public boolean isALive() {
		return isALive;
	}

	public void setALive(boolean isALive) {
		this.isALive = isALive;
	}
	
	public float getRad() {
		return rad;
	}

	public void setRad(float rad) {
		this.rad = rad;
	}

}
