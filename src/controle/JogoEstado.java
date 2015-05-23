package controle;

import java.util.logging.Logger;

import javax.swing.DebugGraphics;

import logica.Plataforma;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class JogoEstado extends BasicGameState {
	private final int estado;
	private Plataforma plat;
	private int de = 1;
	public JogoEstado(int estado){
		this.estado = estado;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		plat = new Plataforma(gc.getWidth()/2 , gc.getHeight() - 40, 20, 100);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.fill(plat.getRec());
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
	}

	@Override
	public int getID() {
		return estado;
	}

}
