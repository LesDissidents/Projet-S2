package projets2.affichage;

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
	private static Image imageInventaire;
	private static Image imagePvVide;
	private static Image imagePvVie;

	public static void initRessources() throws SlickException {
		RessourceLoader.imageDecors = new HashMap<Integer, Image>();
		RessourceLoader.imagePortesFermees = new HashMap<Integer, Image>();
		RessourceLoader.imagePortesOuvertes = new HashMap<Integer, Image>();
		RessourceLoader.imageOutils = new HashMap<Integer, Image>();
		RessourceLoader.imagePiegesActifs = new HashMap<Integer, Image>();
		RessourceLoader.imagePiegesInactifs = new HashMap<Integer, Image>();
		RessourceLoader.imageEscaliers = new HashMap<Integer, Image>();
		RessourceLoader.imageConsommables = new HashMap<Integer, Image>();
		RessourceLoader.imageSurprises = new HashMap<Integer, Image>();
		RessourceLoader.imageSols = new HashMap<Integer, Image>();
		
		RessourceLoader.imageDecors.put(0, new Image("ressources/images/tiles/murHorizontal.png"));
		RessourceLoader.imageDecors.put(1, new Image("ressources/images/tiles/murVertical.png"));
		RessourceLoader.imageDecors.put(2, new Image("ressources/images/tiles/chaise.png"));
		RessourceLoader.imageDecors.put(3, new Image("ressources/images/tiles/tableMetal.png"));
		RessourceLoader.imageDecors.put(4, new Image("ressources/images/tiles/toilette.jpg"));
		RessourceLoader.imageDecors.put(5, new Image("ressources/images/tiles/coffeeMachine.png"));
		RessourceLoader.imageDecors.put(6, new Image("ressources/images/tiles/printer.png"));
		RessourceLoader.imageDecors.put(99, new Image("ressources/images/tiles/gg.png"));
		
		RessourceLoader.imagePortesFermees.put(1, new Image("ressources/images/tiles/porteFermeeN.png"));
		RessourceLoader.imagePortesFermees.put(2, new Image("ressources/images/tiles/porteFermeeE.png"));
		RessourceLoader.imagePortesFermees.put(3, new Image("ressources/images/tiles/porteFermeeS.png"));
		RessourceLoader.imagePortesFermees.put(4, new Image("ressources/images/tiles/porteFermeeO.png"));
		
		RessourceLoader.imagePortesOuvertes.put(1, new Image("ressources/images/tiles/porteOuverteN.png"));
		RessourceLoader.imagePortesOuvertes.put(2, new Image("ressources/images/tiles/porteOuverteE.png"));
		RessourceLoader.imagePortesOuvertes.put(3, new Image("ressources/images/tiles/porteOuverteS.png"));
		RessourceLoader.imagePortesOuvertes.put(4, new Image("ressources/images/tiles/porteOuverteO.png"));
		
		RessourceLoader.imageOutils.put(0, new Image("ressources/images/tiles/clef.png"));
		RessourceLoader.imageOutils.put(1, new Image("ressources/images/tiles/masqueGaz.png"));
		RessourceLoader.imageOutils.put(2, new Image("ressources/images/tiles/piedBiche.png"));
		
		
		RessourceLoader.imagePiegesActifs.put(0, new Image("ressources/images/tiles/mine.png"));
		RessourceLoader.imagePiegesActifs.put(1, new Image("ressources/images/tiles/piegeOurs.png"));
		RessourceLoader.imagePiegesActifs.put(2, new Image("ressources/images/tiles/piquesRentres.png"));
		RessourceLoader.imagePiegesActifs.put(3, new Image("ressources/images/tiles/gaz.png"));
		RessourceLoader.imagePiegesActifs.put(4, new Image("ressources/images/tiles/punaises.png"));
		RessourceLoader.imagePiegesActifs.put(5, new Image("ressources/images/tiles/trou.png"));
		
		RessourceLoader.imagePiegesInactifs.put(0, new Image("ressources/images/tiles/bombe.png"));
		RessourceLoader.imagePiegesInactifs.put(1, new Image("ressources/images/tiles/piegeLoup.png"));
		RessourceLoader.imagePiegesInactifs.put(2, new Image("ressources/images/tiles/piquesSortis.png"));
		
		RessourceLoader.imageEscaliers.put(0, new Image("ressources/images/tiles/escaliersDescendre.png"));
		RessourceLoader.imageEscaliers.put(1, new Image("ressources/images/tiles/escaliersMonter.png"));
		
		RessourceLoader.imageConsommables.put(0, new Image("ressources/images/tiles/cafe.png"));
		RessourceLoader.imageConsommables.put(1, new Image("ressources/images/tiles/sandwich.png"));
		
		RessourceLoader.imageSurprises.put(6, new Image("ressources/images/tiles/cadeau.png"));
		
		RessourceLoader.imageSols.put(0, new Image("ressources/images/tiles/sol.png"));
		RessourceLoader.imageSols.put(1, new Image("ressources/images/tiles/Sol1.png"));
		RessourceLoader.imageSols.put(2, new Image("ressources/images/tiles/Sol2.png"));
		RessourceLoader.imageSols.put(3, new Image("ressources/images/tiles/Sol3.png"));
		RessourceLoader.imageSols.put(4, new Image("ressources/images/tiles/Sol4.png"));
		RessourceLoader.imageSols.put(5, new Image("ressources/images/tiles/Sol5.png"));
		
		
		RessourceLoader.imageJoueur = new Image("ressources/images/tiles/joueur.png");
		RessourceLoader.imageInventaire = new Image("ressources/images/tiles/inventaire.png");
		RessourceLoader.imagePvVide = new Image("ressources/images/vi/barreVide.png");
		RessourceLoader.imagePvVie = new Image("ressources/images/vi/barreVie.png");
	}


	public static Image getImageDecors(int clef) {
		return RessourceLoader.imageDecors.get(clef);
	}
	
	public static Image getImageOutils(int clef) {
		return RessourceLoader.imageOutils.get(clef%10);
	}
	
	public static Image getImagePortesFermees(int clef) {
		return RessourceLoader.imagePortesFermees.get(clef/10);
	}
	
	public static Image getImagePortesOuvertes(int clef) {
		return RessourceLoader.imagePortesOuvertes.get(clef/10);
	}
	
	public static Image getImagePiegesActifs(int clef) {
		return RessourceLoader.imagePiegesActifs.get(clef/10);
	}
	
	public static Image getImagePiegesInactifs(int clef) {
		return RessourceLoader.imagePiegesInactifs.get(clef/10);
	}
	
	public static Image getImageEscaliers(int clef) {
		return RessourceLoader.imageEscaliers.get(clef%10);
	}
	
	public static Image getImageConsommables(int clef) {
		return RessourceLoader.imageConsommables.get(clef);
	}
	
	public static Image getImageSurprises(int clef) {
		return RessourceLoader.imageSurprises.get(clef);
	}
	
	public static Image getImageSols(int clef) {
		return RessourceLoader.imageSols.get(clef);
	}

	public static Image getImageJoueur() {
		return RessourceLoader.imageJoueur;
	}

	public static Image getImageInventaire() {
		return RessourceLoader.imageInventaire;
	}

	public static Image getImagePvVide() {
		return RessourceLoader.imagePvVide;
	}

	public static Image getImagePvVie() {
		return RessourceLoader.imagePvVie;
	}
}