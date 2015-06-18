package projets2;

import java.util.HashMap;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class RessourceLoader {
	private static HashMap<Integer, Image> imageEntite;
	private static Image imageJoueur;

	public static void initRessources() throws SlickException {
		imageEntite = new HashMap<Integer, Image>();
		imageEntite.put(0, new Image("/ressources/map/img/mur.png"));
		imageEntite.put(10, new Image("/ressources/map/img/porteFermee.png"));
		imageJoueur = new Image("/ressources/map/img/joueur.png");
	}

	public static Image getImageEntite(int clef) {
		return imageEntite.get(clef);
	}

	public static Image getImageJoueur() {
		return imageJoueur;
	}
}