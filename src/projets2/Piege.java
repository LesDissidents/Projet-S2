package projets2;

public class Piege extends Applicable implements Traversable {

	private boolean actif;
	
	/**
	 * Constructeur d'un objet Piege prenant en parametre un int
	 * @param id - id du piege
	 */
	public Piege(int id){
		super(id);
	}
	
	/**
	 * Methode renvoyant true si l'instance est traversable
	 * @return - true si l'objet est traversable
	 */
	public boolean estTraversable(Personnage personnage){
		return true;
	}
	
	/**
	 * Methode qui applique les effets du pieges sur le personnage
	 * return - false si le joueur survit, true sinon
	 */
	@Override
	public boolean appliquerEffet(Personnage personnage) {
		return false;
	}
}
