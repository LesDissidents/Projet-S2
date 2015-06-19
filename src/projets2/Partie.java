package projets2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import projets2.affichage.Gagne;
import projets2.affichage.Game;
import projets2.affichage.Perdu;
import projets2.affichage.Rendu;
import projets2.affichage.RessourceLoader;
import projets2.utils.Controleur;

public class Partie extends BasicGameState {
	private Joueur joueur;
	private Etage[] immeuble;
	private String nomPartie;
	
	private int difficulte;
	private int nbDeplacements;
	private int id;
	
	private boolean perdu = false;
	private boolean gagne = false;

	public static final String pathMaps = "ressources/map/";

	/**
	 * Créé une partie de la difficulté choisi avec un nom donné
	 * @param id - identifiant de la fenetre de Slick2D
	 * @param difficulte - difficulté de la partie
	 * @param nom - nom de la partie
	 */
	public Partie(int id, int difficulte, String nom) {
		this.id = id;
		this.difficulte = difficulte;
		this.nomPartie = nom;

		File[] files = new File("ressources/map/immeuble1").listFiles();
		this.immeuble = new Etage[files.length];

		for (int i = 0; i < this.immeuble.length; i++) {
			try {
				this.immeuble[i] = new Etage(Partie.pathMaps + "immeuble1/etage" + i + ".txt");
			} catch (IOException e) {
				System.out.println("Fichier introuvable ou corrompu");
				System.exit(0);
			}
		}

		int etageDepart = 0;
		String[] coordDepart = null;

		try {
			BufferedReader fichier = new BufferedReader(new FileReader("ressources/map/spawn/spawn1.txt"));
			etageDepart = Integer.parseInt(fichier.readLine());
			coordDepart = fichier.readLine().split(" ");
		} catch (IOException e) {
			System.out.println("Fichier introuvable ou corrompu");
			System.exit(0);
		}

		this.joueur = new Joueur(new Point(Integer.parseInt(coordDepart[0]), Integer.parseInt(coordDepart[1])), 5, etageDepart);
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		RessourceLoader.initRessources();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		Rendu.afficherEtage(this, g);
		Rendu.afficherJoueur(this, g);
		Rendu.afficherInventaire(this, g);
		Rendu.afficherInformationsJoueur(this, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		if(this.perdu){
			sbg.addState(new Perdu(Game.perdu, this.difficulte, this.nomPartie));
			sbg.getState(Game.perdu);
			sbg.enterState(Game.perdu);
		}else if(this.gagne){
			sbg.addState(new Gagne(Game.gagne, this.difficulte, this.nomPartie, this.nbDeplacements));
			sbg.getState(Game.gagne);
			sbg.enterState(Game.gagne);
		}
	}

	@Override
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_UP || key == Input.KEY_RIGHT || key == Input.KEY_LEFT || key == Input.KEY_DOWN) {
			Controleur.informerDeplacement(this, key);
			Controleur.activerCase(this);
		}
	}

	@Override
	public int getID() {
		return this.id;
	}

	/**
	 * Modifie le nombre de déplacement
	 *
	 * @param nbDeplacement - le nombre de déplacement
	 */
	public void changerNbDeplacement(int nbDeplacements) {
		this.nbDeplacements = nbDeplacements;
	}
	
	/**
	 * Retourne le nombre de déplacement qu'a effectué le joueur
	 * depuis le début de la partie
	 * 
	 * @return nombre de déplacement
	 */
	public int getNbDeplacement() {
		return this.nbDeplacements;
	}
	
	/**
	 * Retourne l'instance du joueur de la partie
	 * 
	 * @return le joueur
	 */
	public Joueur getJoueur() {
		return this.joueur;
	}
	
	/**
	 * Retourne l'instance de l'étage demandé
	 * 
	 * @param i - l'étage
	 * @return l'instance de l'étage
	 */
	public Etage getEtage(int i) {
		return this.immeuble[i];
	}
	
	/**
	 * Donne un état à la partie
	 * 
	 * @param gagne - true si la partie est gagné, false si la partie est perdu
	 */
	public void setEtatPartie(boolean gagne) {
		this.gagne = gagne;
		this.perdu = !gagne;
	}
}
