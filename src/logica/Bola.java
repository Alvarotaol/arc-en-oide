package logica;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.geom.Circle;

public class Bola {
	private Circle pos;
	private Vector2f direc;
	
	public Bola(int x, int y, int raio, Vector2f dir) {
		pos = new Circle(x, y, raio);
		direc = dir;
	}
	
	public void mover(){
		pos.getLocation().add(direc); //pos.setLocation(
	}
	
	public void rebater(float ang){
		direc.
	}
}
