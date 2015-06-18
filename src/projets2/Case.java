package projets2;
import java.awt.Point;

/**
 * Classe Case, représenté par une entité et un personnage
 * @author mezen002
 *
 */
public class Case {
	
	private Entite entite;
	private Personnage perso;
	public static final int SIZE = 32;
	
	/**
	 * Constructeur par defaut
	 * 
	 * @param contenu - le contenu de la case
	 * @param perso - le personnage de la case
	 */
	public Case(Entite entite) {
		this.entite = entite;
	}
	
	/**
	 * Retourne le contenu de la case
	 * 
	 * @return le contenu
	 */
	public Entite getEntite() {
		return this.entite;
	}
	
	/**
	 * Retourne le personnage de la case
	 * 
	 * @return le personnage, null sinon
	 */
	public Personnage getPersonnage() {
		return this.perso;
	}
	
	/**
	 * Modifie le personnage de la case
	 * 
	 * @param perso - le personnage a modifier ou retirer
	 */
	public void affecterPersonnage(Personnage perso) {
		this.perso = perso;
	}
	
	/**
	 * Indique si le déplacement est possible ou pas
	 * @param perso - le personnage que l'on souhaite deplacer
	 * @return true si le déplacement est possible, false sinon
	 */
	public boolean deplacementPossible(Personnage perso) {
		boolean res = false; 
		if(this.entite instanceof Porte) {
			Porte porte = (Porte)this.entite;
			res = porte.estTraversable(perso);
		} else if(this.entite instanceof Mur) {
			res = false;
		} else {
			res = true;
		}
		return res;
	}
	
	/**
	 * Vide le contenu de la case
	 */
	public void viderCase() {
		this.entite = null;
		this.perso = null;
		
	}
}
