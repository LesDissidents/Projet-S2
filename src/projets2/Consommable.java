package projets2;

/**
 * Classe Consommable héritant de la classe Applicable et implementant l'interface Ramassable
 * 
 * @author mezen002
 *
 */
public class Consommable extends Applicable implements Ramassable {

	/**
	 * Constructeur par défaut, initialise l'identifiant du consommable
	 * 
	 * @param identifiant - L'identifiant du consommable
	 */
	public Consommable(int identifiant) {
		super(identifiant);
	}
	
	
	/**
	 * Surcharge de la méthode appliquerEffet de la classe Applicable,
	 * applique un effet au personnage
	 * 
	 * @param personnage - le personnage qui doit avoir l'effet
	 * @return true si le personnage est mort, false sinon
	 */
	@Override
	public boolean appliquerEffet(Personnage personnage) {
		return true;
	}
	
	/**
	 * Retourne si l'objet est ramassable
	 * 
	 * @return true si l'objet est ramassable, false sinon
	 */
	public boolean isRamassable() {
		return true;
	}
	
}
