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
		
		switch(this.clef){
			case 0:
				graphic.drawImage(RessourceLoader.getImageDecors(this.reference), (int)point.getX(), (int)point.getY());
				break;
			case 10:
				
				graphic.drawImage(RessourceLoader.getImagePortesFermees(this.reference), (int)point.getX(), (int)point.getY());
				break;
			case 11:
				graphic.drawImage(RessourceLoader.getImagePortesOuvertes(this.reference), (int)point.getX(), (int)point.getY());
				break;
			case 20: case 21: case 22: case 23: case 24: case 25: case 26: case 27: case 28: case 29:
				graphic.drawImage(RessourceLoader.getImageOutils(this.clef), (int)point.getX(), (int)point.getY());
				break;
			case 30:
				graphic.drawImage(RessourceLoader.getImagePiegesActifs(this.reference), (int)point.getX(), (int)point.getY());
				break;
			case 31:
				graphic.drawImage(RessourceLoader.getImagePiegesInactifs(this.reference), (int)point.getX(), (int)point.getY());
				break;
			case 40: case 41:
				graphic.drawImage(RessourceLoader.getImageEscaliers(this.clef), (int)point.getX(), (int)point.getY());
				break;
			case 5:
				graphic.drawImage(RessourceLoader.getImageConsommables(this.reference), (int)point.getX(), (int)point.getY());
				break;
			case 6:
				System.out.print(this.reference);
				graphic.drawImage(RessourceLoader.getImageSurprises(this.reference), (int)point.getX(), (int)point.getY());
				break;
			/*case 7:
				graphic.drawImage(RessourceLoader.getImageSols(this.reference), (int)point.getX(), (int)point.getY());
				break;*/
			default:
				break;
		}
	}
}
	
