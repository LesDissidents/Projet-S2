package projets2;

import java.awt.Dimension;
import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MainMenu extends BasicGameState {
	private boolean screenChanger = true;
	private boolean selectedNP, selectedC, selectedO, selectedQ;
	private Image largeButton, largeButtonActive, largeButtonPressed,
			mainMenuBox, background;
	private boolean mouseLeft = false;
	private int state;

	public MainMenu(int state) {
		this.state = state;
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
		g.setColor(Color.white);
		g.drawImage(mainMenuBox, 75, 50);
		// bouton nouvelle partie
		if (selectedNP) {
			if (mouseLeft) {
				g.drawImage(largeButtonPressed, 100, 100);
			} else {
				g.drawImage(largeButtonActive, 100, 100);
			}
		} else {
			g.drawImage(largeButton, 100, 100);
		}
		g.drawString("Nouvelle Partie", 115, 115);
		// bouton charger
		if (selectedC) {
			if (mouseLeft) {
				g.drawImage(largeButtonPressed, 100, 200);
			} else {
				g.drawImage(largeButtonActive, 100, 200);
			}
		} else {
			g.drawImage(largeButton, 100, 200);
		}
		g.drawString("Score", 115, 215);
		// bouton option
		if (selectedO) {
			if (mouseLeft) {
				g.drawImage(largeButtonPressed, 100, 300);
			} else {
				g.drawImage(largeButtonActive, 100, 300);
			}
		} else {
			g.drawImage(largeButton, 100, 300);
		}
		g.drawString("Options", 115, 315);
		// bouton quitter
		if (selectedQ) {
			if (mouseLeft) {
				g.drawImage(largeButtonPressed, 100, 400);
			} else {
				g.drawImage(largeButtonActive, 100, 400);
			}
		} else {
			g.drawImage(largeButton, 100, 400);
		}
		g.drawString("Quitter", 135, 415);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		if (screenChanger) {
			Dimension dimension = java.awt.Toolkit.getDefaultToolkit()
					.getScreenSize();
			AppGameContainer appgc = (AppGameContainer) gc;
			Game.DimX = (int) dimension.getWidth();
			Game.DimY = (int) dimension.getHeight();
			appgc.setDisplayMode(Game.DimX, Game.DimY, false);
		}
		int posX = Mouse.getX(); // 0,0 bottom corner
		int posY = Game.DimY - Mouse.getY(); // résolution de cela
		Input input = gc.getInput();
		// gestion bouton nouvelle partie
		if (posX > 100 && posX < 300) {
			if (posY > 100 && posY < 154) {
				selectedNP = true;
				if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
					mouseLeft = true;
				} else {
					if (mouseLeft) {
						mouseLeft = false;
						sbg.enterState(Game.newGame);
					}
				}
			} else {
				selectedNP = false;
			}
			// gestion bouton Score
			if (posY > 200 && posY < 254) {
				selectedC = true;
				if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
					mouseLeft = true;
				} else {
					if (mouseLeft) {
						mouseLeft = false;
						sbg.enterState(Game.score);
					}
				}
			} else {
				selectedC = false;
			}
			// gestion bouton Option
			if (posY > 300 && posY < 354) {
				selectedO = true;
				if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
					mouseLeft = true;
				} else {
					if (mouseLeft) {
						mouseLeft = false;
						sbg.enterState(Game.option);
					}
				}
			} else {
				selectedO = false;
			}
			// Gestion bouton Quitter
			if (posY > 400 && posY < 454) {
				selectedQ = true;
				if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
					mouseLeft = true;
				} else {
					if (mouseLeft) {
						mouseLeft = false;
						gc.exit();
					}
				}
			} else {
				selectedQ = false;
			}
		} else {
			selectedNP = selectedQ = selectedC = selectedO = mouseLeft = false;
		}
	}

	@Override
	public int getID() {
		return this.state;
	}
}