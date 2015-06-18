package projets2;

import java.awt.Point;

public abstract class Personnage extends Affichable{
	protected Point position;
	protected int pointsDeVie;
	protected int pointsDeVieMax;
	protected int orientation;
	protected int etageCourant;
	/**
	 * Constructeur 
	 * orientation initialisée par défaut
	 * pointsDeVie initialisé a pointsDeVieMax
	 * etageCourant initialisé a 0
	 * L'image est initialisé a selon la classe (a implementer plus tard.)
	 * @param position Point pour initialiser position
	 * @param pdvMax int pour decider du nombre de points de vie  maximum 
	 */
	public Personnage(Point position,int pdvMax){
		this.position= new Point(position);
		this.pointsDeVie=pdvMax;
		this.pointsDeVieMax=pdvMax;
		this.orientation=0;
		this.etageCourant=0;
	}
	
	/**
	 * Retourne la position du Personnage
	 * @return (point)La position du Personnage 
	 */
	public Point getPosition(){
		return this.position;
	}
	
	/**
	 * Renvoye les points de vie maximums
	 * @return (int) Les points de vie max
	 */
	public int getPointDeVieMax(){
		return this.pointsDeVieMax;
	}
	
	/**
	 * Retourne le sens dans lequel le Personnage est tourné
	 * @return (int) int representant l'orientation du personnage
	 */
	public int getOrientation(){
		return this.orientation;
	}
	
	/**
	 * Permet de changer les points de vie avec un int tel que pointsDeVie=pointsDeVie-nbPointsDeVie
	 * Renvoye false quand pointsDeVie apsse en dessous de 0
	 * @param nbPointsDeVie (int) nombre de points de vie ajouté ou retiré 
	 * @return (boolean) Faux si Personnage mort
	 */
	public boolean modifierPointsDeVie(int nbPointsDeVie){
		this.pointsDeVie += nbPointsDeVie;
		if(this.pointsDeVie <= 0) return false;
		else return true;
	}
	
	/**
	 * Permet de changer la limite de points de vie
	 * @param newPDVMax (int) les nouveaux points de vie maximum
	 */
	public void setPointsDeVieMax(int newPDVMax){
		this.pointsDeVie = newPDVMax;
	}
	
	/**
	 * Tourne le joueur dans une direction et le fait avancer ou non en fonction des parametres.
	 * @param direction (int) code pour le sens dans lequel le Personnage se tourne et se déplace
	 * @param deplacementPossible (boolean) boolean indiquant si le personnage va su la case vers laquelle il est orienté
	 * @return La nouvelle position du joueur
	 */
	public Point deplacer(int direction,boolean deplacementPossible){
		
		return null;
	}
	
	
}
