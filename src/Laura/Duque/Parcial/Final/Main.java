package Laura.Duque.Parcial.Final;

import processing.core.PApplet;

public class Main extends PApplet {

	private Logica log;
	
	public static void main(String[] args) {
		PApplet.main("Laura.Duque.Parcial.Final.Main");
	}
	
	public void settings() {
		size(1300,700);
	}
	public void setup() {
		log = new Logica(this);
		noStroke();
		textAlign(CENTER);
		ellipseMode(CENTER);
	}
	public void draw() {
		background(255);
		log.pintar();
	}
	public void mouseReleased() {
		log.click();
	}
}
