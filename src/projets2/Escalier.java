package projets2;

public class Escalier implements Traversable{
	private boolean monter;
	
	/**
	 * Constructeur d'un escalier prenant un int en paramètre
	 * @param id - id de l'escalier
	 */
	public Escalier(int id){

	}
	
	/** 
	 * Accesseur à l'attribut monter de l'escalier
	 * @return Un boolean selon si l'escalier permet de monter ou de descendre
	 */
	public boolean getMonter(){
		return this.monter;
	}
	
}
