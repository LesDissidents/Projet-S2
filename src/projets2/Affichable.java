package projets2;

import java.awt.Point;

import org.newdawn.slick.Graphics;

/**
 * Classe abstraite servant à l'affichage représenté par un chemin d'image
 * 
 * @author mezen002
 *
 */
public abstract class Affichable {

	protected String cheminImage;
	
	/**
	 * Methode permettant d'afficher une image
	 * 
	 * @param point - le point où afficher l'image
	 * @param graphic - la fenêtre du dessin
	 */
	public abstract void afficher(Point point, Graphics graphic);
}
