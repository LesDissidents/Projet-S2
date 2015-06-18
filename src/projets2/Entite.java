package projets2;

import java.awt.Point;

import org.newdawn.slick.Graphics;

public class Entite extends Affichable {
	protected int clef;
	protected int reference;
	
	/**
	 * Constructeur d'une entitée
	 * @param id - id de l'entité
	 */
	public Entite(int id) {
		this.clef = id/100;
		this.reference = id % 100;
	}

	
	/**
	 * Accesseur à la clef  de l'entité.
	 * @return - la clef  de l'entité.
	 */
	public int getClef() {
		return this.clef;
	}
	
	/**
	 * Accesseur a la référence de l'entité
	 * @return la valeur de la référence de l'entité
	 */
	public int getReference() {
		return this.reference;
	}

	@Override
	public void afficher(Point point, Graphics graphic) {
		
	}
}
	
