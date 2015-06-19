package projets2.affichage;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.*;

import projets2.Partie;

public class NewGame extends BasicGameState {
	private int id;
	private boolean selectedDF, selectedDN, selectedDD, selectedGame;
	Image largeButton, largeButtonActive, largeButtonPressed, mainMenuBox,
			background;
	private boolean mouseLeft = false;
	private int difficulte;

	public NewGame(int id) {
		this.id = id;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.largeButton = new Image(
				"ressources/images/buttons/largeButton.png");
		this.largeButtonActive = new Image(
				"ressources/images/buttons/largeButtonActive.png");
		this.largeButtonPressed = new Image(
				"ressources/images/buttons/largeButtonPressed.png");
		this.mainMenuBox = new Image(
				"ressources/images/dialogs/mainMenuBox.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString("Difficulté", Game.DimX / 2 - 100, 50);
		if (selectedDF) {
			if (mouseLeft) {
				g.drawImage(largeButtonPressed, 100, 100);
			} else {
				g.drawImage(largeButtonActive, 100, 100);
			}
		} else {
			g.drawImage(largeButton, 100, 100);
		}
		g.drawString("Facile", 115, 115);
		if (selectedDN) {
			if (mouseLeft) {
				g.drawImage(largeButtonPressed, 350, 100);
			} else {
				g.drawImage(largeButtonActive, 350, 100);
			}
		} else {
			g.drawImage(largeButton, 350, 100);
		}
		g.drawString("Normale", 365, 115);
		if (selectedDD) {
			if (mouseLeft) {
				g.drawImage(largeButtonPressed, 650, 100);
			} else {
				g.drawImage(largeButtonActive, 650, 100);
			}
		} else {
			g.drawImage(largeButton, 650, 100);
		}
		g.drawString("Difficile", 665, 115);
		if (selectedGame) {
			if (mouseLeft) {
				g.drawImage(largeButtonPressed, 300, 300);
			} else {
				g.drawImage(largeButtonActive, 300, 300);
			}
		} else {
			g.drawImage(largeButton, 300, 300);
		}
		g.drawString("Lancer Partie", 315, 315);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		int posX = Mouse.getX(); // 0,0 bottom corner
		int posY = Game.DimY - Mouse.getY(); // résolution de cela
		Input input = gc.getInput();
		if (posX > 100 && posX < 300 && posY > 100 && posY < 154) {
			selectedDF = true;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				mouseLeft = true;
			} else {
				if (mouseLeft) {
					mouseLeft = false;
					difficulte = 0;
				}
			}
		} else {
			selectedDF = false;
		}
		if (posX > 350 && posX < 550 && posY > 100 && posY < 154) {
			selectedDN = true;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				mouseLeft = true;
			} else {
				if (mouseLeft) {
					mouseLeft = false;
					difficulte = 1;
				}
			}
		} else {
			selectedDN = false;
		}
		if (posX > 600 && posX < 800 && posY > 100 && posY < 154) {
			selectedDD = true;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				mouseLeft = true;
			} else {
				if (mouseLeft) {
					mouseLeft = false;
					difficulte = 2;
				}
			}
		} else {
			selectedDD = false;
		}
		if (posX > 300 && posX < 500 && posY > 300 && posY < 354) {
			selectedGame = true;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				mouseLeft = true;
			} else {
				if (mouseLeft) {
					mouseLeft = false;
					sbg.addState(new Partie(Game.game, difficulte, "NOM"));
					sbg.getState(Game.game).init(gc, sbg);
					sbg.enterState(Game.game);
				}
			}
		} else {
			selectedGame = false;
		}
	}

	@Override
	public int getID() {
		return this.id;
	}
}