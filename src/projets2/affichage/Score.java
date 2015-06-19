package projets2.affichage;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Score extends BasicGameState {
	private int id;

	public Score(int id) {
		this.id = id;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString("Ceci est la fenetre de score", 100, 100);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			sbg.enterState(Game.menu);
		}
	}

	@Override
	public int getID() {
		return this.id;
	}
}