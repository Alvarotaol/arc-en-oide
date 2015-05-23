package logica;

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
				g.fill(grade[i][j].getRec());
			}
		}
	}
}
