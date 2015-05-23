package logica;

import org.newdawn.slick.geom.Rectangle;

public class Plataforma {
	Rectangle pos;
	public Plataforma(int x, int y, int alt, int larg) {
		pos = new Rectangle(x, y, larg, alt);
	}
	
	public Rectangle getRec(){
		return pos;
	}
	public void mover(int delta){
		pos.setCenterX(pos.getCenterX() + delta);
	}
}
