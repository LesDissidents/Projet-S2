package projets2;

import java.io.BufferedReader;
import java.io.File;
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
	private int motifDeSol;
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
		this.motifDeSol = Integer.parseInt(longueurLargeur[2]);
		
		this.cases = new Case[this.longueur*this.largeur];
		
		
		String[] id = fichier.readLine().split(" ");
		for(int i = 0;i<id.length;i++){
			int identifiant=Integer.parseInt(id[i]);
			switch (identifiant/100) {
			case 0 : 
				this.cases[i] = new Case(new Mur(identifiant));
			break;
			
			case 10 : case 11 :
				this.cases[i] = new Case(new Porte(identifiant));
			break;
			
			case 20: case 21: case 22: case 23: case 24: case 25: case 26: case 27: case 28: case 29: 
				this.cases[i] = new Case(new Outil(identifiant));
			break;
			
			case 30 : case 31 :
				this.cases[i] = new Case(new Piege(identifiant));
			break;
			
			case 40 : case 41:
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
				this.cases[i] = new Case(null);
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
		return this.cases[(y*this.longueur+x)];
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
	
	public int getMotif(){
		return this.motifDeSol;
	}
}