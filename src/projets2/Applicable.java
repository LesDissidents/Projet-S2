package projets2;

public abstract class Applicable extends Entite {
	
	public Applicable(int id) {
		super(id);
	}

	/**
	 * Méthode permettant d'appliquer l'effet d'un objet à un personnage
	 * @param personnage - Le personnage sur lequel l'effet est appliqué
	 * @return - "true" si l'effet a été appliqué, "false" sinon.
	 */
	public abstract boolean appliquerEffet(Personnage personnage);
	
	/**
	* Accesseur à la clef de l'entité.
	* @return - la clef de l'entité.
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
}

