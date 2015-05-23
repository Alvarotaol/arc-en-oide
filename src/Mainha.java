import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import controle.JogoEstado;


public class Mainha extends StateBasedGame {
	public static AppGameContainer app;
	public static int largura = 480, altura = 640, limiteFps = 50;
	
	public Mainha(String titulo){
		super(titulo);
		this.addState(new JogoEstado(0));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean telaCheia = false;
		try {
			app = new AppGameContainer(new Mainha("Janela"));
			app.setDisplayMode(largura, altura, telaCheia);
		    app.setTargetFrameRate(limiteFps);
		    app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		
	}

}
