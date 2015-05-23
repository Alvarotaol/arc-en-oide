package controle;

import logica.Bola;
import logica.Grade;
import logica.Plataforma;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class JogoEstado extends BasicGameState {
	private final int estado;
	private Plataforma plat;
	private Bola bola;
	private Grade grad;
	public JogoEstado(int estado){
		this.estado = estado;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		plat = new Plataforma(gc.getWidth()/2 , gc.getHeight() - 40, 20, 100);
		bola = new Bola(gc.getWidth() / 2, gc.getHeight() - 50, 10, new Vector2f(1, -1));
		grad = new Grade(10, 10, gc.getWidth()/10, gc.getWidth()/15, 5);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.fill(plat.getRec());
		//System.out.println("(" + bola.getRec().getCenterX() + ", " + bola.getRec().getCenterY() + ")");
		g.fill(bola.getRec());
		grad.desenhar(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input in = gc.getInput();
		if(in.isKeyDown(Input.KEY_A)){
			plat.mover(-delta/6);
		}
		if(in.isKeyDown(Input.KEY_D)){
			plat.mover(delta/6);
		}
		bola.mover(1);
		if(bola.getRec().getMaxX() >= gc.getWidth()){
			bola.rebater(90);
		}
		if(bola.getRec().getMinX() <= 0){
			bola.rebater(90);
		}
		if(bola.getRec().getMinY() <= 0){
			bola.rebater(0);
		}
		//Versão simples do rebatimento
		if(bola.getRec().intersects(plat.getRec())){
			bola.rebater(0);
		}
	}

	@Override
	public int getID() {
		return estado;
	}

}
