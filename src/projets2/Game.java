package projets2;

import java.util.Scanner;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {
	public static final String gameName = "OfficeEscape";
	public static final int menu = 1;
	public static final int newGame = 2;
	public static final int score = 3;
	public static final int game = 4;
	public static final int option = 5;
	public static int DimX, DimY;

	public Game(String gameName) {
		super(gameName);
		this.addState(new MainMenu(menu));
		this.addState(new Score(score));
		this.addState(new Option(option));
		this.addState(new NewGame(newGame));
	}

	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(gameName));
			appgc.setDisplayMode(640, 305, false);
			appgc.setShowFPS(false);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(option).init(gc, this);
		this.getState(score).init(gc, this);
		this.getState(newGame).init(gc, this);
		this.enterState(menu);
	}
}