package projets2;

import java.util.Random;

public class Surprise extends Applicable {
	public int identifiant;

	/**
	 * Constructeur de l'objet Surprise prenant un identifiant en paramètre
	 * 
	 * @param id
	 *            - Identifiant de la surpise
	 */
	public Surprise(int id) {
		super(id);
	}

	/**
	 * Methode appliquant un effet à un personnage en fonction de l'idée de
	 * l'Entite et renvoyant un boolean
	 * 
	 * @return true si le joueurest encore en vie, false sinon
	 * @author DONIN de ROSIERE Kévin
	 */
	@Override
	public boolean appliquerEffet(Personnage p) {
		boolean res = true;
		switch (this.getReference()/10) {
			case 0 :
				boolean b = new Random().nextBoolean();
				if(b) res = p.modifierPointsDeVie(-(this.getReference()%10));
				else res = p.modifierPointsDeVie((this.getReference()%10));
				break;
			case 1 :
				p.setEtat("fatigue",50);
				res = true;
				break;
			case 2 :
				boolean b2 = new Random().nextBoolean();
				if(b2) res = p.setPointsDeVieMax(-(this.getReference()%10));
				else res = p.setPointsDeVieMax((this.getReference()%10));
				break;
		}
		return res;
	}
}
