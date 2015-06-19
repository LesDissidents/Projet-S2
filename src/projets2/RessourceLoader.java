package projets2;

import java.util.HashMap;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class RessourceLoader {
	private static HashMap<Integer, Image> imageEntite;
	private static Image imageJoueur;
	private static Image imageInventaire;

	public static void initRessources() throws SlickException {
		imageEntite = new HashMap<Integer, Image>();
		imageEntite.put(0, new Image("ressources/images/tiles/murHorizontal.png"));
		imageEntite.put(10, new Image("ressources/images/tiles/porteFermee.png"));
		imageEntite.put(11, new Image("ressources/images/tiles/porteOuverte.png"));
		imageEntite.put(2, new Image("ressources/images/tiles/clef.png"));
		imageEntite.put(30, new Image("ressources/images/tiles/piegeLoup.png"));
		imageEntite.put(40, new Image("ressources/images/tiles/escaliersDescendre.png"));
		imageEntite.put(41, new Image("ressources/images/tiles/escaliersMonter.png"));
		imageEntite.put(5, new Image("ressources/images/tiles/cafe.png"));
		imageEntite.put(7, new Image("ressources/images/tiles/sol.png"));
		imageEntite.put(8, new Image("ressources/images/tiles/masqueGaz.png"));
		imageEntite.put(6, new Image("ressources/images/tiles/cadeau.png"));
		imageJoueur = new Image("ressources/images/tiles/joueur.png");
		imageInventaire = new Image("ressources/images/tiles/inventaire.png");
	}

	public static Image getImageEntite(int clef) {
		return imageEntite.get(clef);
	}

	public static Image getImageJoueur() {
		return imageJoueur;
	}
	
	public static Image getImageInventaire() {
		return imageInventaire;
	}
}