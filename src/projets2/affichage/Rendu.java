package projets2.affichage;

import java.awt.Point;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import projets2.Case;
import projets2.Entite;
import projets2.Etage;
import projets2.Joueur;
import projets2.Partie;
import projets2.Ramassable;

public class Rendu {
	
	public static void afficherEtage(Partie p, Graphics g) {
		Etage courant = p.getEtage(p.getJoueur().getEtageCourant());
		
		for (int i = 0; i < courant.getLongueur(); i++) {
			for (int j = 0; j < courant.getLargeur(); j++) {
				Case caseCourante = courant.getCase(i, j);
				g.drawImage(RessourceLoader.getImageSols(courant.getMotif()),i * Case.SIZE, j * Case.SIZE);
				
				if (caseCourante.getEntite() != null) {
					caseCourante.getEntite().afficher(new Point(i * Case.SIZE, j * Case.SIZE), g);
				}
			}
		}
	}
	
	public static void afficherJoueur(Partie p, Graphics g) {
		p.getJoueur().afficher(p.getJoueur().getPosition(), g);
	}
	
	public static void afficherInventaire(Partie p, Graphics g) {
		Point pos = new Point(100, 600);
		g.drawImage(RessourceLoader.getImageInventaire(), 100, 600);
		
		for (Ramassable r : p.getJoueur().getInventaire()) {
			((Entite) r).afficher(pos, g);
			pos.move((int) pos.getX() + 38, (int) pos.getY());
		}
	}
	
	public static void afficherInformationsJoueur(Partie p, Graphics g) {
		Joueur j = p.getJoueur();
		g.drawString("NbDeplacement : " + p.getNbDeplacement(), 700,400);
		
		Rectangle barreVie = new Rectangle(805, 805, ( 118* j.getPointdeVie() ) / j.getPointDeVieMax(), 22);
		String pv = (j.getPointdeVie() ) + " / " + j.getPointDeVieMax();
		g.drawString(pv, 830, 830 );
		g.drawImage(RessourceLoader.getImagePvVide(), 800, 800);
		g.setColor(Color.red);
		g.fill(barreVie);
		g.draw(barreVie);
	}
}
