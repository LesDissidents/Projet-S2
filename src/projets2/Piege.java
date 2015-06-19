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
		boolean res = false;
		if(this.actif) {
			System.out.println(p.getPointdeVie());
			switch (this.getReference() / 10) {
			case 0: case 1: case 2: case 3: case 4:
				res = p.modifierPointsDeVie(-(this.getReference() % 10));
				System.out.println("retirer pdv" + this.getReference() % 10);
				break;
			
			case 5:
				p.setEtat("fatigue", 50);
				res = true;
				System.out.println("fatigue");
				break;
			
			case 6:
				res = p.setPointsDeVieMax(-(this.getReference() % 10));
				System.out.println("retirer pdvMax" + this.getReference() % 10);
				break;
			}
		}
		
		if((this.getReference() / 10) != 3 || (this.getReference() / 10) != 4){
			if(this.actif){
				this.clef+=1;
			}
			this.actif = false;
		}
		
		return res;
	}
}
