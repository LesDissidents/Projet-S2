package projets2;

public class Mur extends Entite implements Traversable  {
	
	/**
	 * Constructeur de l'objet mur rpenant un identifiant en paramètre
	 * @param id - Identifiant du mur
	 */
	public Mur(int id) {
		super(id);
		
	}
	
	/**
	 * Methode renvoyant true si l'instance est traversable
	 * @return - true si l'objet est traversable
	 */
	public boolean estTraversable(Personnage personnage) {
		return false;
	}
}
