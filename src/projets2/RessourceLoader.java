package projets2;

import java.util.HashMap;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class RessourceLoader {
	private static HashMap<Integer, Image> imageDecors;
	private static HashMap<Integer, Image> imagePiegesActifs;
	private static HashMap<Integer, Image> imagePiegesInactifs;
	private static HashMap<Integer, Image> imageOutils;
	private static HashMap<Integer, Image> imagePortesFermees;
	private static HashMap<Integer, Image> imagePortesOuvertes;
	private static HashMap<Integer, Image> imageEscaliers;
	private static HashMap<Integer, Image> imageConsommables;
	private static HashMap<Integer, Image> imageSurprises;
	private static HashMap<Integer, Image> imageSols;
	
	private static Image imageJoueur;

	public static void initRessources() throws SlickException {
		//initialisation des tableaux associatifs
		imageDecors = new HashMap<Integer, Image>();
		imagePortesFermees = new HashMap<Integer, Image>();
		imagePortesOuvertes = new HashMap<Integer, Image>();
		imageOutils = new HashMap<Integer, Image>();
		imagePiegesActifs = new HashMap<Integer, Image>();
		imagePiegesInactifs = new HashMap<Integer, Image>();
		imageEscaliers = new HashMap<Integer, Image>();
		imageConsommables = new HashMap<Integer, Image>();
		imageSurprises = new HashMap<Integer, Image>();
		imageSols = new HashMap<Integer, Image>();
		
		//Associations des images de décors
		imageDecors.put(0, new Image("ressources/images/tiles/murHorizontal.png"));
		imageDecors.put(1, new Image("ressources/images/tiles/murVertical.png"));
		imageDecors.put(2, new Image("ressources/images/tiles/chaise.png"));
		imageDecors.put(3, new Image("ressources/images/tiles/tableMetal.png"));
		//imageDecors.put(4, new Image("ressources/images/tiles/toilettes.png"));
		//imageDecors.put(5, new Image("ressources/images/tiles/machineCafe.png"));
		//imageDecors.put(6, new Image("ressources/images/tiles/imprimante.png"));
		
		
		imagePortesFermees.put(1, new Image("ressources/images/tiles/porteFermeeN.png"));
		imagePortesFermees.put(2, new Image("ressources/images/tiles/porteFermeeE.png"));
		imagePortesFermees.put(3, new Image("ressources/images/tiles/porteFermeeS.png"));
		imagePortesFermees.put(4, new Image("ressources/images/tiles/porteFermeeO.png"));
		
		
		imagePortesOuvertes.put(1, new Image("ressources/images/tiles/porteOuverteN.png"));
		imagePortesOuvertes.put(2, new Image("ressources/images/tiles/porteOuverteE.png"));
		imagePortesOuvertes.put(3, new Image("ressources/images/tiles/porteOuverteS.png"));
		imagePortesOuvertes.put(4, new Image("ressources/images/tiles/porteOuverteO.png"));
		
		
		imageOutils.put(0, new Image("ressources/images/tiles/clef.png"));
		imageOutils.put(1, new Image("ressources/images/tiles/masqueGaz.png"));
		imageOutils.put(2, new Image("ressources/images/tiles/piedBiche.png"));
		
		
		imagePiegesActifs.put(0, new Image("ressources/images/tiles/mine.png"));
		imagePiegesActifs.put(1, new Image("ressources/images/tiles/piegeOurs.png"));
		imagePiegesActifs.put(2, new Image("ressources/images/tiles/piquesRentres.png"));
		imagePiegesActifs.put(3, new Image("ressources/images/tiles/gaz.png"));
		imagePiegesActifs.put(4, new Image("ressources/images/tiles/punaises.png"));
		imagePiegesActifs.put(5, new Image("ressources/images/tiles/trou.png"));
		
		
		
		imagePiegesInactifs.put(1, new Image("ressources/images/tiles/piegeLoup.png"));
		imagePiegesInactifs.put(2, new Image("ressources/images/tiles/piquesSortis.png"));
		
		
		imageEscaliers.put(0, new Image("ressources/images/tiles/escaliersDescendre.png"));
		imageEscaliers.put(1, new Image("ressources/images/tiles/escaliersMonter.png"));
		
		
		imageConsommables.put(0, new Image("ressources/images/tiles/cafe.png"));
		imageConsommables.put(1, new Image("ressources/images/tiles/sandwich.png"));
		
		
		imageSurprises.put(0, new Image("ressources/images/tiles/cadeau.png"));
		
		
		imageSols.put(0, new Image("ressources/images/tiles/sol.png"));
		imageSols.put(1, new Image("ressources/images/tiles/Sol1.png"));
		imageSols.put(2, new Image("ressources/images/tiles/Sol2.png"));
		imageSols.put(3, new Image("ressources/images/tiles/Sol3.png"));
		imageSols.put(4, new Image("ressources/images/tiles/Sol4.png"));
		imageSols.put(5, new Image("ressources/images/tiles/Sol5.png"));
		
		imageJoueur = new Image("ressources/images/tiles/joueur.png");
	}

	public static Image getImageDecors(int clef) {
		return imageDecors.get(clef);
	}
	
	public static Image getImageOutils(int clef) {
		return imageOutils.get(clef%10);
	}
	
	public static Image getImagePortesFermees(int clef) {
		return imagePortesFermees.get(clef/10);
	}
	
	public static Image getImagePortesOuvertes(int clef) {
		return imagePortesOuvertes.get(clef/10);
	}
	
	public static Image getImagePiegesActifs(int clef) {
		return imagePiegesActifs.get(clef/10);
	}
	
	public static Image getImagePiegesInactifs(int clef) {
		return imagePiegesInactifs.get(clef/10);
	}
	
	public static Image getImageEscaliers(int clef) {
		return imageEscaliers.get(clef%10);
	}
	
	public static Image getImageConsommables(int clef) {
		return imageConsommables.get(clef);
	}
	
	public static Image getImageSurprises(int clef) {
		return imageSurprises.get(clef);
	}
	
	public static Image getImageSols(int clef) {
		return imageSols.get(clef);
	}

	public static Image getImageJoueur() {
		return imageJoueur;
	}
}