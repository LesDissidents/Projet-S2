package projets2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Etage représenté par des cases et un motif de sol
 * 
 * @author mezen002
 *
 */
public class Etage {

	private Case[] cases;
	private String motifDeSol;
	private int longueur;
	private int largeur;
	
	/**
	 * Constructeur par defaut. initialise le chemin du fichier de l'étage
	 * 
	 * @param cheminFichierEtage - Le chemin du fichier de l'étage
	 */
	public Etage(String cheminFichierEtage) throws FileNotFoundException, IOException {
		BufferedReader fichier = new BufferedReader(new FileReader(cheminFichierEtage));
		String[] longueurLargeur = fichier.readLine().split(" ");
		this.longueur = Integer.parseInt(longueurLargeur[0]);
		this.largeur = Integer.parseInt(longueurLargeur[1]);
		this.cases = new Case[this.longueur*this.largeur] ;
		
		String[] id = fichier.readLine().split(" ");
		for(int i = 0;i<id.length-1;i++){
			int identifiant=Integer.parseInt(id[i]);
			switch (identifiant/1000) {
			case 0 : 
				this.cases[i] = new Case(new Mur(identifiant));
			break;
			
			case 1 : 
				this.cases[i] = new Case(new Porte(identifiant));
			break;
			
			case 2 : 
				this.cases[i] = new Case(new Outil(identifiant));
			break;
			
			case 3 : 
				this.cases[i] = new Case(new Piege(identifiant));
			break;
			
			case 4 : 
				this.cases[i] = new Case(new Escalier(identifiant));
			break;
			
			case 5 : 
				this.cases[i] = new Case(new Consommable(identifiant));
			break;
			
			case 6 : 
				int effet = new Random().nextInt(3)*10;
				int valeur = new Random().nextInt(6)-3;
				identifiant = 6*100+ effet + valeur;
				this.cases[i] = new Case(new Surprise(identifiant));
			break;
			default :
				this.cases[i] = null;
			}
		}
	}	

	
	/**
	 * Retourne la case de coordonnées (x,y)
	 * @param x - la position en x
	 * @param y - la position en y
	 * @return - la case de coordonnées (x,y)
	 */
	public Case getCase(int x, int y) {
		return this.cases[(y*this.largeur+x)];
	}
	
	/**
	 * Donne la longueur
	 * @return la longueur
	 */ 
	public int getLongueur() {
		return this.longueur;
	}
	
	/**
	 * Donne la largeur
	 * @return la largeur
	 */
	public int getLargeur() {
		return this.largeur;
	}
	
	public static void main(String[] args) {
		Etage etage = null;
		try {
			etage = new Etage("src/immeuble1/etage1.txt");
		} catch (IOException e) {
			System.out.println("Erreur lecture de fichier");
		}
		Case caseyolo = etage.getCase(0,0);
		System.out.println(caseyolo);
	}
}

