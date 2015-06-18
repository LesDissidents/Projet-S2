package projets2;

/**
 * Classe Consommable héritant de la classe Applicable et implementant
 * l'interface Ramassable
 *
 * @author mezen002
 *
 */
public class Consommable extends Applicable implements Ramassable {
	/**
	 * Constructeur par défaut, initialise l'identifiant du consommable
	 *
	 * @param identifiant
	 *            - L'identifiant du consommable
	 */
	public Consommable(int identifiant) {
		super(identifiant);
	}

	/**
	 * Surcharge de la méthode appliquerEffet de la classe Applicable, applique
	 * un effet au personnage
	 *
	 * @param personnage - le personnage qui doit avoir l'effet
	 * @return false si le personnage est mort, true sinon
	 */
	@Override
	public boolean appliquerEffet(Personnage personnage) {
		switch (this.reference / 10) {
		case 0:
			personnage.modifierPointsDeVie(this.reference % 10);
			break;
		case 1:
			personnage.setPointsDeVieMax(this.reference % 10);
			break;
		}
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
