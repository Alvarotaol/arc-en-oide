package logica;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

class Bloco {
	private Rectangle pos;
	private int acertos;
	public Bloco(int x, int y, int larg, int alt, int acertos) {
		pos = new Rectangle(x, y, larg, alt);
		this.acertos = acertos;
	}
	
	public Rectangle getRec() {
		return pos;
	}
	
	public void bater(){
		acertos--;
	}
	
	public void desenhar(Graphics g){
		if(acertos > 0 ){
			g.setColor(Color.blue);
			g.fill(pos);
		}
	}
	
	public boolean quebrado() {
		return acertos == 0;
	}
}

public class Grade {
	private Bloco grade[][];
	
	public Grade(int nx, int ny, int tx, int ty, int inter) {
		grade = new Bloco[nx][ny];
		//TODO Depois transformar isso num método de carregar fase
		for(int i = 0; i < nx; i++){
			for (int j = 0; j < ny; j++) {
				grade[i][j] = new Bloco(i*(tx + inter) + inter,
										j*(ty + inter) + inter, tx, ty, 1);
			}
		}
	}
	
	public void desenhar(Graphics g){
		for(int i = 0; i < grade.length; i++){
			for (int j = 0; j < grade[i].length; j++) {
				grade[i][j].desenhar(g);
			}
		}
	}
	
	public void colidir(Bola bol){
		for(int i = 0; i < grade.length; i++){
			for (int j = 0; j < grade[i].length; j++) {
				if(!grade[i][j].quebrado() && grade[i][j].getRec().intersects(bol.getRec())){
					grade[i][j].bater();
					boolean d = bol.getRec().getCenterX() > grade[i][j].getRec().getMaxX(),
							e = bol.getRec().getCenterX() < grade[i][j].getRec().getMinX(),
							c = bol.getRec().getCenterY() < grade[i][j].getRec().getMinY(),
							b = bol.getRec().getCenterY() > grade[i][j].getRec().getMaxY();
					if(d){
						if(c) bol.rebater(45);
						else if(b) bol.rebater(135);
						else bol.rebater(90);
					} else if(e){
						if(c) bol.rebater(135);
						else if(b) bol.rebater(45);
						else bol.rebater(90);
					} else {
						bol.rebater(0);
					}
				}
			}
		}
	}
}
