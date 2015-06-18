package projets2;

import java.awt.Point;

public class Ennemi extends Personnage {
	
	/**
	 * Constructeur 
	 * orientation initialisée par défaut
	 * pointsDeVie initialisé a pointsDeVieMax
	 * etageCourant initialisé a 0
	 * @param position Point pour initialiser position
	 * @param pdvMax int pour decider du nombre de points de vie  maximum 
	 */
	public Ennemi(Point position,int pdvMax){
		super(position,pdvMax);
	}
}
