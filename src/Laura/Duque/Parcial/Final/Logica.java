package Laura.Duque.Parcial.Final;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {

	private PApplet app;
	private Mundo mundo;
	
	public Logica(PApplet app) {
		this.app = app;
		mundo = new Mundo(app);
		mundo.start();
		}
	
	public void pintar () {
		mundo.show();
	}
	
	public void click () {

	}

}
