package projets2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Partie extends BasicGameState {
	private Joueur joueur;
	private Etage[] immeuble;
	private int difficulte;
	private int nbDeplacements;
	private String nomPartie;

	public static final String pathMaps = "ressources/map/";
	private int id;

	public Partie(int id, int difficulte, String nom) {
		this.id = id;
		this.difficulte = difficulte;
		this.nomPartie = nom;
		
		File[] files = new File("ressources/map/immeuble1").listFiles();
		this.immeuble = new Etage[files.length];
		
		for(int i = 0; i < this.immeuble.length; i++) {
			System.out.println(files[i].getName());
			
			try {
				this.immeuble[i] = new Etage(Partie.pathMaps + "immeuble1/etage" + i + ".txt");
			} catch (IOException e) {
				System.out.println("Fichier introuvable ou corrompu");
				System.exit(0);
			}
		}
		
		for(Etage e : this.immeuble) System.out.println(e);
		
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
		
		this.joueur = new Joueur(new Point(Integer.parseInt(coordDepart[0]),Integer.parseInt(coordDepart[1])), 5, etageDepart);
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		RessourceLoader.initRessources();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		Etage courant = this.immeuble[this.joueur.getEtageCourant()];
		for (int i = 0; i < courant.getLongueur(); i++) {
			for (int j = 0; j < courant.getLargeur(); j++) {
				Case caseCourante = courant.getCase(i, j);
				g.drawImage(RessourceLoader.getImageEntite(7),i * Case.SIZE, j * Case.SIZE);
				if (caseCourante.getEntite() != null) {
					caseCourante.getEntite().afficher(new Point(i * Case.SIZE, j * Case.SIZE), g);
				}
			}
		}
		this.joueur.afficher(this.joueur.getPosition(), g);
		
		//Affichage de l'inventaire
		Point p = new Point(100,600);
		g.drawImage(RessourceLoader.getImageInventaire(), 100, 600);
		for(Ramassable r : this.joueur.getInventaire()) {
			((Entite)r).afficher(p, g);
			p.move((int)p.getX() + 38, (int)p.getY());
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
	}

	/**
	 * Constructeur par défaut, initialise le joueur, le batiment et la
	 * difficulté
	 * 
	 * @param Joueur - le joueur
	 * @param nomBatiment - le nom de l'immeuble
	 * @param difficulte - la difficulté
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
			Etage courant = immeuble[joueur.getEtageCourant()];
			courant.getCase(x, y).affecterPersonnage(null);
			switch (key) {
			case Input.KEY_UP:
				y--;
				break;
			case Input.KEY_LEFT:
				x--;
				break;
			case Input.KEY_DOWN:
				y++;
				break;
			case Input.KEY_RIGHT:
				x++;
				break;
			}
			joueur.deplacer(key,courant.getCase(x, y).deplacementPossible(joueur));
			Case tuile = courant.getCase(x, y);
			tuile.affecterPersonnage(this.joueur);
			Entite e = tuile.getEntite();
			if(e instanceof Ramassable){
				this.joueur.ramasserObjet((Ramassable)e);
				tuile.viderCase();
			}else if(e instanceof Piege){
				Piege piege = (Piege)e;
				if(piege.appliquerEffet(this.joueur)){
					// GAME OVER !!!!!!!!!!!!!!!
				}
			}else if(e instanceof Escalier){
				
				//////////////////////////////////////////// TODO /////////////////////////////////
			}
		}
	}

	@Override
	public int getID() {
		return this.id;
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
