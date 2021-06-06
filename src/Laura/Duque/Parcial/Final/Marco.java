package Laura.Duque.Parcial.Final;

import java.util.ArrayList;

import processing.core.PApplet;

public class Marco extends Automata implements Runnable {

	private boolean isSayingMarco = false;
	private ArrayList<Polo> polos = null;

	public Marco(PApplet app) {
		super(app);
		// TODO Auto-generated constructor stub
		rad = 15;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		app.fill(20, 20, 20, 30);
		app.ellipse(pos.x, pos.y, rad * 2, rad * 2);
		if (isSayingMarco) {
			app.fill(0);
			app.text("Marco", pos.x, pos.y + rad * 2);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isALive) {
			try {
				Thread.sleep(2000);
				isSayingMarco = !isSayingMarco;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void mover(float x, float y) {
		vel.x= x-pos.x;
		vel.y= y-pos.y;
		vel.normalize();
		vel.x *= 3;
		vel.y *= 3;
		pos.add(vel);
		System.out.println(vel.x);
		System.out.println(vel.y);
	}
	
	public boolean isSayingMarco() {
		return isSayingMarco;
	}

	public void setSayingMarco(boolean isSayingMarco) {
		this.isSayingMarco = isSayingMarco;
	}

	public ArrayList<Polo> getPolos() {
		return polos;
	}

	public void setPolos(ArrayList<Polo> polos) {
		this.polos = polos;
	}

}
