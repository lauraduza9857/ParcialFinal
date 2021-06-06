package Laura.Duque.Parcial.Final;

import processing.core.PApplet;

public class Polo extends Automata implements Runnable {

	private boolean isSayingPolo = false;
	private Marco marco = null;
	private float r = 0; 
	private float g = 0;
	private float b = 0;
	public Polo(PApplet app) {
		super(app);
		// TODO Auto-generated constructor stub
		rad = 15;
		r = app.random(255);
		g = app.random(255);
		b = app.random(255);
		float r = app.random(1);
		if (r >= 0.5) {
			vel.x = 1;
		} else {
			vel.x = -1;
		};
		r = app.random(1);
		if (r >= 0.5) {
			vel.y = 1;
		} else {
			vel.y = -1;
		};
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		app.fill(r, g, b, 80);
		app.ellipse(pos.x, pos.y, rad * 2, rad * 2);
		if (isSayingPolo) {
			app.fill(0);
			app.text("Polo "+ (int)pos.x + " " + (int)pos.y, pos.x, pos.y + rad * 2);
		}
	}
	
	public void mover() {
		if (pos.x < rad || pos.x > app.width - rad) {
			vel.x *= -1;
		}
		if (pos.y < rad || pos.y > app.height - rad) {
			vel.y *= -1;
		}
		pos.add(vel);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isALive) {
			try {
				Thread.sleep(25);
				if (marco != null) {
					if (marco.isSayingMarco()) {
						Thread.sleep(500);
						isSayingPolo = true;
					} else {
						isSayingPolo = false;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public boolean isSayingPolo() {
		return isSayingPolo;
	}

	public void setSayingPolo(boolean isSayingPolo) {
		this.isSayingPolo = isSayingPolo;
	}

	public Marco getMarco() {
		return marco;
	}

	public void setMarco(Marco marco) {
		this.marco = marco;
	}

}
