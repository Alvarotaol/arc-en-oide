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
	
	public void mover(int delta){
		Vector2f d = new Vector2f(direc);
		pos.setLocation(pos.getLocation().add(d.scale(2)));
	}
	
	public void rebater(double ang){
		//System.out.print("Antes: (" + direc.x + ", " + direc.y + ") ");
		direc.setTheta(360 + 2*ang - direc.getTheta());
		//System.out.println("Depos: (" + direc.x + ", " + direc.y + ")");
	}
	
	public Circle getRec() {
		return pos;
	}
}
