package projets2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {
	public static final int gameConsole = 0;
	public static final int game = 1;

	public Game(String title) {
		super(title);
		try {
			this.addState(new Partie(1, "Test", false));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(
					new Game("OfficeEscape"));
			app.setDisplayMode(500, 400, false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(gameConsole).init(gc, this);
		this.getState(game).init(gc, this);
		this.enterState(gameConsole);
	}
}
