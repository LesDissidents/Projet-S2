package projets2;

import java.awt.Point;
import java.util.LinkedList;

import org.newdawn.slick.Graphics;

public class Joueur extends Personnage{
	
	private LinkedList<Ramassable> inventaire;
	private int etageCourant;
	private boolean moving;
	
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
		this.inventaire = new LinkedList<Ramassable>();
		this.etageCourant = 0;
	}
	
	/**
	 * Retourne l'etage actuel du personnage
	 *
	 * @return l'etage actuel
	 */
	public int getEtageCourant() {
		return this.etageCourant;
	}
	
	/**
	 * Renvoye l'inventaire sous forme de liste chainée
	 * @return (LinkedList) une liste remplie seulement de Ramassable
	 */
	public LinkedList<Ramassable> getInventaire(){
		return this.inventaire;
	}
	
	/**
	 * Permet d'ajouter un objet a l'inventaire du Joueur
	 * @param entite l'objet a ajouter
	 * @return (boolean) Savoir si l'objet a été ajouté avec succés
	 */
	public boolean ramasserObjet(Ramassable entite){
		this.inventaire.add(entite);
		return true;
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
		for(Ramassable e : this.inventaire){
			if(((Entite)e).getReference() == porte.getReference()){
				b = true;
			}
		}
		return b;
	}
	
	public void isMoving(boolean moving){
		this.moving = moving;
	}

	@Override
	public void afficher(Point point, Graphics graphic) {
		graphic.drawImage(RessourceLoader.getImageJoueur(), (int)point.getX() * Case.SIZE, (int)point.getY() * Case.SIZE);
	}
}
