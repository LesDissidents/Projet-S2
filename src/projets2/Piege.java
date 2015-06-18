package projets2;

public class Piege extends Applicable implements Traversable {
	private boolean actif;

	/**
	 * Constructeur d'un objet Piege prenant en parametre un int
	 * 
	 * @param id
	 *            - id du piege
	 */
	public Piege(int id) {
		super(id);
	}

	/**
	 * Methode renvoyant true si l'instance est traversable
	 * 
	 * @return - true si l'objet est traversable
	 */
	public boolean estTraversable(Personnage personnage) {
		return true;
	}

	/**
	 * Methode appliquant un effet à un personnage en fonction de l'idée de
	 * l'Entite et renvoyant un boolean
	 * 
	 * @return true si le joueurest encore en vie, faulse sinon
	 * @author DONIN de ROSIERE Kévin
	 */
	@Override
	public boolean appliquerEffet(Personnage p) {
		boolean res = false;
		if(this.actif) {
			switch (this.getReference() / 10) {
			case 0:
				res = p.modifierPointsDeVie(-(this.getReference() % 10));
				break;
			case 1:
				p.setEtat("fatigue", 50);
				res = true;
				break;
			case 2:
				res = p.setPointsDeVieMax(-(this.getReference() % 10));
				break;
			}
		}
		this.actif = false;
		return res;
	}
}
