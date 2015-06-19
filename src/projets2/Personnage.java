package projets2;

import java.awt.Point;

public abstract class Personnage extends Affichable {
	protected Point position;
	protected int pointsDeVie;
	protected String Etat;
	protected int compteur;
	protected int pointsDeVieMax;

	/**
	 * ints de slick 2D BAS 208 HAUT 200 GAUCHE 203 DROITE 205
	 */
	protected int orientation;
	private String etat;

	/**
	 * Constructeur orientation initialisée par défaut pointsDeVie initialisé a
	 * pointsDeVieMax etageCourant initialisé a 0 L'image est initialisé a selon
	 * la classe (a implementer plus tard.)
	 *
	 * @param position
	 *            Point pour initialiser position
	 * @param pdvMax
	 *            int pour decider du nombre de points de vie maximum
	 */
	public Personnage(Point position, int pdvMax) {
		this.position = new Point(position);
		this.pointsDeVie = pdvMax;
		this.pointsDeVieMax = pdvMax;
		this.orientation = 205;
		this.compteur = 100;
		this.etat = "";
	}

	/**
	 * Retourne la position du Personnage
	 *
	 * @return (point)La position du Personnage
	 */
	public Point getPosition() {
		return new Point(this.position);
	}

	/**
	 * retourne le compteur
	 * 
	 * @return (int) le nombre de pas restant
	 */
	public int getCompteur() {
		return this.compteur;
	}

	/**
	 * retourne l'etat
	 * 
	 * @return (string) l'etat du joueur
	 */
	public String getEtat() {
		return this.etat;
	}

	/**
	 * permet de changer l'etat et le compteur
	 * 
	 * @param s
	 *            ,l'etat
	 * @param i
	 *            ,le compteur
	 */
	public void setEtat(String s, int i) {
		this.etat = s;
		this.compteur += i;
	}
	/**
	 * Permet de teleporter le joueur (utilisé avec les escaliers)
	 * @param p un point pour changer la position du joueur
	 */
	public void setPosition(Point p){
		this.position.setLocation(p);
	}
	/** 
	 * Renvoye les points de vie maximums
	 *
	 * @return (int) Les points de vie max
	 */
	public int getPointDeVieMax() {
		return pointsDeVieMax;
	}

	/**
	 * Retourne le sens dans lequel le Personnage est tourné
	 *
	 * @return (int) int representant l'orientation du personnage
	 */
	public int getOrientation() {
		return orientation;
	}

	/**
	 * Permet de changer les points de vie avec un int tel que
	 * pointsDeVie=pointsDeVie-nbPointsDeVie Renvoye false quand pointsDeVie
	 * apsse en dessous de 0
	 *
	 * @param nbPointsDeVie
	 *            (int) nombre de points de vie ajouté ou retiré
	 * @return (boolean) Faux si Personnage mort
	 */
	public boolean modifierPointsDeVie(int nbPointsDeVie) {
		boolean b = true;
		if (this.pointsDeVie + nbPointsDeVie < this.pointsDeVieMax) {
			this.pointsDeVie = this.pointsDeVie + nbPointsDeVie;
		} else {
			this.pointsDeVie = this.pointsDeVieMax;
		}
		if (this.pointsDeVie <= 0) {
			b = false;
		}
		return b;
	}

	/**
	 * Permet de changer la limite de points de vie
	 *
	 * @param newPDVMax
	 *            (int) les nouveaux points de vie maximum
	 * @return retourne false si le joueur meurt.
	 */
	public boolean setPointsDeVieMax(int newPDVMax) {
		boolean b = true;
		this.pointsDeVieMax += newPDVMax;
		if(this.pointsDeVie>this.pointsDeVieMax){
			this.pointsDeVie=this.pointsDeVieMax;
		}
		if (this.pointsDeVieMax <= 0) {
			b = false;
		}
		return b;
	}

	/**
	 * Tourne le joueur dans une direction et le fait avancer ou non en fonction
	 * des parametres. enleve des deplacements au compteur
	 * 
	 * @param direction
	 *            (int) code pour le sens dans lequel le Personnage se tourne et
	 *            se déplace
	 * @param deplacementPossible
	 *            (boolean) boolean indiquant si le personnage va su la case
	 *            vers laquelle il est orienté
	 * @return La nouvelle position du joueur
	 */
	public Point deplacer(int direction, boolean deplacementPossible) {
		this.orientation = direction;
		
		if (deplacementPossible) {
			if (direction == 203) {// left
				position.translate(-1, 0);
			}
			if (direction == 205) {// right
				position.translate(1, 0);
			}
			if (direction == 208) {// bottom
				position.translate(0, 1);
			}
			if (direction == 200) {// up
				position.translate(0, -1);
			}
			/*if (this.etat.equals("fatigue")) {
				this.compteur -= 2;
			} else {
				this.compteur -= 1;
			}
			if (compteur <= 0) {
				this.etat = null;
			}*/
		}
		Point p = new Point(position);
		return p;
	}

	public int getPointdeVie() {
		return this.pointsDeVie;
	}
}