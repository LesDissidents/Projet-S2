package projets2;

public class Escalier extends Entite implements Traversable{
	
	private boolean monter;
	
	/**
	 * Constructeur d'un escalier prenant un int en paramètre
	 * @param id - id de l'escalier
	 */
	public Escalier(int id){
		super(id);
		if((((id/100)%10)) == 0) this.monter = false;
		else this.monter = true;
	}
	
	/** 
	 * Accesseur à l'attribut monter de l'escalier
	 * @return Un boolean selon si l'escalier permet de monter ou de descendre
	 */
	public boolean getMonter(){
		return this.monter;
	}
	
	/**
	 * Methode renvoyant true si l'instance est traversable
	 * @return - true si l'objet est traversable
	 */
	public boolean estTraversable(Personnage personnage){
		return true;
	}
	
}
