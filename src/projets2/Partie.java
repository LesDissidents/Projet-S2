package projets2;

import java.util.LinkedList;

/**
 * Classe Partie représenté par : 
 * <ul>
 * 	<li> difficulté : int
 *  <li> nbDeplacements : int
 *  <li> immeuble : Etage[]
 *  <li> joueur : Joueur
 *  <li> ennemis : LinkedList<Ennemie>
 * </ul>
 * @author mezen002
 *
 */
public class Partie {

	private int difficulte;
	private int nbDeplacements;
	private Etage[] immeuble;
	private Joueur joueur;
	private LinkedList<Ennemi> ennemis;
	
	/**
	 * Constructeur par défaut, initialise le joueur, le batiment et la difficulté
	 * @param Joueur - le joueur
	 * @param nomBatiment - le nom de l'immeuble
	 * @param difficulte - la difficulté
	 */
	public Partie(Joueur joueur, String nomBatiment, int difficulte) {
		this.joueur = joueur;
		this.difficulte = difficulte;
		
	}
	
	
	/**
	 * Modifie le nombre de déplacement
	 * 
	 * @param nbDeplacement - le nombre de déplacement
	 * @return le nombre de déplacement
	 */
	public int changerNbDeplacement(int nbDeplacements) {
		this.nbDeplacements = nbDeplacements;
		return this.nbDeplacements;
	}
}
