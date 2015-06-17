package projets2;

import java.awt.Point;
import java.util.LinkedList;

public class Joueur extends Personnage{
	private LinkedList<Ramassable> inventaire;
	/**
	 * Constructeur 
	 * Inventaire LinketList initialisé et vide.
	 * orientation initialisée par défaut
	 * pointsDeVie initialisé a pointsDeVieMax
	 * etageCourant initialisé a 0
	 * @param position Point pour initialiser position
	 * @param pdvMax int pour decider du nombre de points de vie  maximum 
	 */
	public Joueur(Point position,int pdvMax){
		super(position,pdvMax);
	}
	
	/**
	 * Renvoye l'inventaire sous forme de liste chainée
	 * @return (LinkedList) une liste remplie seulement de Ramassable
	 */
	public LinkedList<Ramassable> getInventaire(){
		return null;
	}
	
	/**
	 * Permet d'ajoute run objet a l'inventaire du Joueur
	 * @param entite l'objet a ajouter
	 * @return (boolean) Savoir si l'objet a été ajouté avec succés
	 */
	public boolean ramasserObjet(Ramassable entite){
		return false;
	}
	
	/**
	 * Permet d'utiliser un objet dans l'inventaire.
	 * si l'objet est un outil, il est conservé.
	 * si l'objet n'est pas un outil, il est supprimé.
	 * @param reference un emplacement dans la liste chainée Inventaire
	 */
	public void utiliserObjet(int reference){

	}
	
	/**
	 * Verifie si le joueur a l'outil necessaire pour ouvrir la porte passée en parametres.
	 * @param porte Une porte sur la case ou le joueur veut aller
	 * @return un boolean pour savoir si c'est portes ouvertes aujourdhui
	 */
	public boolean ouvrirPorte(Porte porte){
		return false;
	}
}
