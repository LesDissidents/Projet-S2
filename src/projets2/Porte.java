package projets2;

public class Porte extends Entite implements Traversable{
	
	private boolean ouvert;
	
	/**
	 * Constructeur d'un objet porte qui un int en paramètre
	 * @param int - identifiant de la porte
	 */
	public Porte(int id) {
		super(id);
		this.ouvert = false;
	}
	
	/**
	 * Méthode permettant d'ouvrir la porte.
	 * @param ouvrir - Etat de la porte apres utilisation de la methode
	 */
	public boolean ouvrir(boolean ouvrir) {
		return this.ouvert = ouvrir;
	}
	
	/**
	 * Methode renvoyant true si l'instance est traversable
	 * @return - true si l'objet est traversable et false sinon
	 */
	public boolean estTraversable(Personnage personnage) {
		if(personnage instanceof Joueur){
			boolean inc = this.ouvert;
			if(this.ouvrir(((Joueur)personnage).ouvrirPorte(this)) && !inc) {
				this.clef += 1;
			}
		}
		return this.ouvert;
	}
}

