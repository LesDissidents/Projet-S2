package projets2;

import java.awt.Point;
import java.util.LinkedList;

import org.newdawn.slick.Graphics;

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
		inventaire= new LinkedList<>();
	}
	
	/**
	 * Renvoye l'inventaire sous forme de liste chainée
	 * @return (LinkedList) une liste remplie seulement de Ramassable
	 */
	public LinkedList<Ramassable> getInventaire(){
		return new LinkedList<Ramassable>(this.inventaire);
	}
	
	/**
	 * Permet d'ajouter un objet a l'inventaire du Joueur
	 * @param entite l'objet a ajouter
	 * @return (boolean) Savoir si l'objet a été ajouté avec succés
	 */
	public boolean ramasserObjet(Ramassable entite){
		boolean b=false;
		this.inventaire.add(entite);
		b=true;
		return b;
	}
	
	/**
	 * Permet d'utiliser un objet dans l'inventaire.
	 * si l'objet est un outil, il est conservé.
	 * si l'objet n'est pas un outil, il est supprimé.
	 * @param reference un emplacement dans la liste chainée Inventaire
	 */
	public void utiliserObjet(int reference){
		Ramassable e=this.inventaire.get(reference);
		if(!(e instanceof Outil)){
			((Applicable) e).appliquerEffet(this);
			inventaire.remove(reference);
		}else{
			//valentin c'est tes clés c'est ton bordel
		}
	
	}
	
	/**
	 * Verifie si le joueur a l'outil necessaire pour ouvrir la porte passée en parametres.
	 * @param porte Une porte sur la case ou le joueur veut aller
	 * @return un boolean pour savoir si c'est portes ouvertes aujourdhui
	 */
	public boolean ouvrirPorte(Porte porte){
		Boolean b=false;
		//Valentin a toi de jouer
		return b;
	}

	@Override
	public void afficher(Point point, Graphics graphic) {
		
	}
}
