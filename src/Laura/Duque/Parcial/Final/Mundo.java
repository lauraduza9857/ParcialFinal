package Laura.Duque.Parcial.Final;

import java.util.ArrayList;

import processing.core.PApplet;

public class Mundo extends Thread {

	private PApplet app;
	private Marco marco;
	private ArrayList<Polo> polos;
	int poloIndex = -1;

	public Mundo(PApplet app) {
		// TODO Auto-generated constructor stub
		this.app = app;
		polos = new ArrayList<>();
		marco = new Marco(app);
		Thread newTread = new Thread(marco);
		newTread.start();
		for (int i = 0; i < 20; i++) {
			Polo polo = new Polo(app);
			polos.add(polo);
			polo.setMarco(marco);
			Thread threadPolo = new Thread(polo);
			threadPolo.start();
		}
		marco.setPolos(polos);

	}

	public void show() {
		marco.show();
		for (int i = 0; i < polos.size(); i++) {
			polos.get(i).show();
		}
	}

	public void validateDistance() {
		for (int i = 0; i < polos.size(); i++) {
			if (polos.get(i).isALive == false) {
				polos.remove(i);
				return;
			}
		}
		
		int newIndex = -1;
		float poloDist = 0;
		for (int i = 0; i < polos.size(); i++) {
			float dist = app.dist(polos.get(i).getPosX(), polos.get(i).getPosY(), marco.getPosX(), marco.getPosY());
			if (newIndex == -1) {
				poloDist = dist;
				newIndex = i;
			} else if (dist < poloDist) {
				poloDist = dist;
				newIndex = i;
			}
		}
		
		poloIndex = newIndex;
	}

	public void moveMarco() {
		if (poloIndex != -1) {
			if (polos.get(poloIndex).isSayingPolo()) {
				marco.mover(polos.get(poloIndex).getPosX(), polos.get(poloIndex).getPosY());
				for (int i = 0; i < polos.size(); i++) {
					if (app.dist(polos.get(i).getPosX(), polos.get(i).getPosY(), marco.getPosX(),
							marco.getPosY()) < marco.getRad()) {
						polos.get(i).setALive(false);
					}
				}
			}
		}
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(25);
				for (int i = 0; i < polos.size(); i++) {
					validateDistance();
					polos.get(i).mover();
				}
				moveMarco();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
