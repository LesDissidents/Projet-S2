package projets2;

import java.awt.Point;

import org.newdawn.slick.Graphics;

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

	@Override
	public void afficher(Point point, Graphics graphic) {
		
	}
}
