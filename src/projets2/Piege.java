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
		this.actif = true;
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
		Joueur j = (Joueur)p;
		if(this.actif) {
			if((this.reference / 10) == 3 && j.haveItem(21)) {
				return true;
			}
			
			switch (this.getReference() / 10) {
				case 0: case 1: case 2: case 3: case 4:
					p.modifierPointsDeVie(-(this.getReference() % 10));
				break;
				case 5:
					p.setEtat("fatigue", 50);
				break;
				case 6:
					p.setPointsDeVieMax(-(this.getReference() % 10));
				break;
			}
		}
		
		if((this.getReference() / 10) != 3 && (this.getReference() / 10) != 4) {
			if(this.actif) {
				this.clef += 1;
			}
			this.actif = false;
		}
		
		return p.getPointdeVie() > 0;
	}
}
