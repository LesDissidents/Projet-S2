package projets2;

public class Porte extends Entite implements Traversable{
	
	private boolean ouvert;
	
	/**
	 * Constructeur d'un objet porte qui un int en paramètre
	 * @param int - identifiant de la porte
	 */
	public Porte(int id){
	super(id);
	if((((id/100)%10)) == 0) this.ouvert = false;
	else this.ouvert = true;
	}
	
	
	/**
	 * Méthode permettant d'ouvrir la porte.
	 * @param ouvrir - Etat de la porte apres utilisation de la methode
	 */
	public void ouvrir(boolean ouvrir){
		this.ouvert = ouvrir;
	}
	/**
	 * Methode renvoyant true si l'instance est traversable
	 * @return - true si l'objet est traversable et false sinon
	 */
	public boolean estTraversable(Personnage personnage){
		return this.ouvert;
	}
}

