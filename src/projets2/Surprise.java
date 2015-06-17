package projets2;

public class Surprise  extends Applicable {
	
	public int identifiant;
	
	/**
	 * Constructeur de l'objet Surprise prenant un identifiant en paramètre
	 * @param id - Identifiant de la surpise
	 */
	public Surprise(int id){
		super(id);
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
