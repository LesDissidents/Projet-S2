package projets2;

import java.awt.Point;

public abstract class Personnage extends Affichable{
	protected Point position;
	
	protected int pointsDeVie;
	
	protected int pointsDeVieMax;
	/** ints de slick 2D
	 * 	BAS 208
 	 *  HAUT 200
	 *  GAUCHE 203 
	 *  DROITE 205
	 */
	protected int orientation;
	
	protected int etageCourant;
	
	/**
	 * Constructeur 
	 * orientation initialisée par défaut
	 * pointsDeVie initialisé a pointsDeVieMax
	 * etageCourant initialisé a 0
	 * L'image est initialisé a selon la classe (a implementer plus tard.)
	 * 
	 * @param position Point pour initialiser position
	 * @param pdvMax int pour decider du nombre de points de vie  maximum 
	 */
	public Personnage(Point position,int pdvMax){
		this.position= new Point(position);
		this.pointsDeVie=pdvMax;
		this.pointsDeVieMax=pdvMax;
		this.orientation=205;
		this.etageCourant=0;
	}
	
	/**
	 * Retourne la position du Personnage
	 * 
	 * @return (point)La position du Personnage 
	 */
	public Point getPosition(){
		return new Point(this.position);
	}
	
	/**
	 * Renvoye les points de vie maximums
	 * 
	 * @return (int) Les points de vie max
	 */
	public int getPointDeVieMax(){
		return pointsDeVieMax;
	}
	
	/**
	 * Retourne le sens dans lequel le Personnage est tourné
	 * 
	 * @return (int) int representant l'orientation du personnage
	 */
	public int getOrientation(){
		return orientation;
	}
	
	/**
	 * Retourne l'etage actuel du personnage
	 * 
	 * @return l'etage actuel
	 */
	public int getEtageCourant(){
		return etageCourant;
	}
	
	/**
	 * Permet de changer les points de vie avec un int tel que pointsDeVie=pointsDeVie-nbPointsDeVie
	 * Renvoye false quand pointsDeVie apsse en dessous de 0
	 * 
	 * @param nbPointsDeVie (int) nombre de points de vie ajouté ou retiré 
	 * @return (boolean) Faux si Personnage mort
	 */
	public boolean modifierPointsDeVie(int nbPointsDeVie){
		boolean b=true;
		if(this.pointsDeVie+nbPointsDeVie<this.pointsDeVieMax){
		this.pointsDeVie=this.pointsDeVie+nbPointsDeVie;
		}else{
			this.pointsDeVie=this.pointsDeVieMax;
		}
		if(this.pointsDeVie<=0){
			b=false;
		}
		return b;
	}
	
	/**
	 * Permet de changer la limite de points de vie
	 * 
	 * @param newPDVMax (int) les nouveaux points de vie maximum
	 */
	public void setPointsDeVieMax(int newPDVMax){
		this.pointsDeVieMax=newPDVMax;
	}
	
	/**
	 * Tourne le joueur dans une direction et le fait avancer ou non en fonction des parametres.
	 * 
	 * @param direction (int) code pour le sens dans lequel le Personnage se tourne et se déplace
	 * @param deplacementPossible (boolean) boolean indiquant si le personnage va su la case vers laquelle il est orienté
	 * @return La nouvelle position du joueur
	 */
	public Point deplacer(int direction,boolean deplacementPossible){
		try{
			if(direction!=203&&direction!=200&&direction!=205&&direction!=208){
				throw new Exception("direction non valable");
			}
			this.orientation=direction;
		if(deplacementPossible){
			if(direction==203){//left
			  position.translate(-1,0);
			 }if(direction==205){//right
			  position.translate(1,0);
			 }if(direction==208){//bottom
			  position.translate(0,1);
			  }if(direction==200){//up
			 position.translate(0,-1);
			  }}
			 
		}catch(Exception e){
			System.out.println("La direction ne correspond pas a un int des touches");
		}
		
		Point p=new Point(position);
		return p;
	}
	
	
}
