package projets2.affichage;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class Perdu extends BasicGameState {
	private int id, difficulte;
	private String nomPartie;

	public Perdu(int id, int difficulte, String nomPartie) {
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Vous avez perdu! Dommage!", 100, 100);
		g.drawString("Appuyer sur echap pour retourner au menu", 300, 300);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			sbg.enterState(Game.menu);
		}
	}

	@Override
	public int getID() {
		return Game.perdu;
	}
}