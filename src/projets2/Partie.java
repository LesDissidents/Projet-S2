package projets2;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class Partie extends BasicGameState {
	private boolean console;
	private Joueur joueur;
	private Etage[] immeuble;
	private int difficulte;
	private int nbDeplacements;
	private String nomPartie;
	private Etage etageCourant;
	public static final String pathMaps = "/ressources/maps/";

	public Partie(int difficulte, String nomPartie, boolean console) throws FileNotFoundException, IOException {
		this.difficulte = difficulte;
		this.nomPartie = nomPartie;
		this.console = console;
		this.immeuble = new Etage[3];
		try {
			for (int i = 0; i < this.immeuble.length; i++) {
				this.immeuble[i] = new Etage(pathMaps + "etage" + i + ".txt");
			}
		} catch (FileNotFoundException e) {
			System.exit(0);
		} catch (IOException e) {
			System.exit(0);
		}
		this.joueur = new Joueur(new Point(0, 0), 5);
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		etageCourant = immeuble[joueur.getEtageCourant()];
		if (console) {
			for (int i = 0; i < etageCourant.getLongueur(); i++) {
				for (int j = 0; j < etageCourant.getLargeur(); j++) {
					Case caseCourante = etageCourant.getCase(i, j);
					int clef = caseCourante.getEntite().getClef();
					if (caseCourante.getEntite() != null) {
						System.out.println();
					}
					if (caseCourante.getPersonnage() != null) {
						System.out.println();
					}
				}
			}
		} else {
			for (int i = 0; i < etageCourant.getLongueur(); i++) {
				for (int j = 0; j < etageCourant.getLargeur(); j++) {
					Case caseCourante = etageCourant.getCase(i, j);
					if (caseCourante.getEntite() != null) {
						g.drawImage(RessourceLoader.getImageEntite(caseCourante
								.getEntite().getClef()), i * Case.SIZE, j
								* Case.SIZE);
					}
					if (caseCourante.getPersonnage() != null) {
						g.drawImage(RessourceLoader.getImageJoueur(), i
								* Case.SIZE, j * Case.SIZE);
					}
				}
			}
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
	}

	/**
	 * Constructeur par défaut, initialise le joueur, le batiment et la
	 * difficulté
	 * 
	 * @param Joueur
	 *            - le joueur
	 * @param nomBatiment
	 *            - le nom de l'immeuble
	 * @param difficulte
	 *            - la difficulté
	 */
	public Partie(Joueur joueur, String nomBatiment, int difficulte) {
		this.joueur = joueur;
		this.difficulte = difficulte;
	}

	@Override
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_UP || key == Input.KEY_RIGHT
				|| key == Input.KEY_LEFT || key == Input.KEY_DOWN) {
			Point position = joueur.getPosition();
			int x = (int) position.getX();
			int y = (int) position.getY();
			switch (key) {
			case Input.KEY_UP:
				y--;
			case Input.KEY_LEFT:
				x++;
			case Input.KEY_DOWN:
				y++;
			case Input.KEY_RIGHT:
				x--;
				break;
			}
			joueur.deplacer(key, etageCourant.getCase(x, y)
					.deplacementPossible(joueur));
		}
	}

	@Override
	public int getID() {
		return Game.gameConsole;
	}

	/**
	 * Modifie le nombre de déplacement
	 *
	 * @param nbDeplacement
	 *            - le nombre de déplacement
	 * @return le nombre de déplacement
	 */
	public int changerNbDeplacement(int nbDeplacements) {
		this.nbDeplacements = nbDeplacements;
		return this.nbDeplacements;
	}
}