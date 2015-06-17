package projets2;

public class Piege extends Applicable implements Traversable {

	private boolean actif;
	
	/**
	 * Constructeur d'un objet Piege prenant en parametre un int
	 * @param id - id du piege
	 */
	public Piege(int id){
	}
	
	/**
	 * Methode renvoyant true si l'instance est traversable
	 * @return - true si l'objet est traversable
	 */
	public boolean estTraversable(Personnage personnage){
		return true;
	}
}
