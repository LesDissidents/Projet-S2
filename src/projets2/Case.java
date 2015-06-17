package projets2;

/**
 * Classe Case, représenté par une entité et un personnage
 * @author mezen002
 *
 */
public class Case {
	
	private Entite contenu;
	private Personnage perso; 
	
	/**
	 * Constructeur par defaut
	 * 
	 * @param contenu - le contenu de la case
	 * @param perso - le personnage de la case
	 */
	public Case(Entite entite) {
		
	}
	
	/**
	 * Retourne le contenu de la case
	 * 
	 * @return le contenu
	 */
	public Entite getEntite() {
		
	}
	
	/**
	 * Retourne le personnage de la case
	 * 
	 * @return le personnage, null sinon
	 */
	public Personnage getPersonnage() {
		
	}
	
	/**
	 * Modifie le personnage de la case
	 * 
	 * @param perso - le personnage a modifier ou retirer
	 */
	public void affecterPersonnage(Personnage perso) {
		
	}
	
	/**
	 * Indique si le déplacement est possible ou pas
	 * @param perso - le personnage que l'on souhaite deplacer
	 * @return true si le déplacement est possible, false sinon
	 */
	public boolean deplacementPossible(Personnage perso) {
		
	}
	
	/**
	 * Vide le contenu de la case
	 */
	public void viderCase() {
		
	}
}
