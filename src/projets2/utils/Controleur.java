package projets2.utils;

import java.awt.Point;

import org.newdawn.slick.Input;

import projets2.Case;
import projets2.Entite;
import projets2.Escalier;
import projets2.Etage;
import projets2.Joueur;
import projets2.Partie;
import projets2.Piege;
import projets2.Ramassable;

public class Controleur {
	
	public static void informerDeplacement(Partie p, int toucheClavier) {
		Joueur j = p.getJoueur();
		Point position = j.getPosition();
		
		int x = (int) position.getX();
		int y = (int) position.getY();
		
		Etage courant = p.getEtage(j.getEtageCourant());
		courant.getCase(x, y).affecterPersonnage(null);
		
		switch (toucheClavier) {
			case Input.KEY_UP:
				y--;
				break;
			case Input.KEY_LEFT:
				x--;
				break;
			case Input.KEY_DOWN:
				y++;
				break;
			case Input.KEY_RIGHT:
				x++;
				break;
		}
		
		boolean deplacement = courant.getCase(x, y).deplacementPossible(j);
		
		if(deplacement) {
			courant.getCase(x, y).affecterPersonnage(j);
			j.deplacer(toucheClavier, deplacement);
			p.changerNbDeplacement(p.getNbDeplacement() + 1);
		}
	}
	
	public static void activerCase(Partie p) {
		Joueur j = p.getJoueur();
		Etage courant = p.getEtage(j.getEtageCourant());
		Point position = j.getPosition();
		
		int x = (int) position.getX();
		int y = (int) position.getY();
		
		Case tuile = courant.getCase(x, y);
		tuile.affecterPersonnage(j);
		Entite e = tuile.getEntite();
		
		if (e instanceof Ramassable) {
			j.ramasserObjet((Ramassable) e);
			tuile.viderCase();
		} else if (e instanceof Piege) {
			Piege piege = (Piege)e;
			if(!piege.appliquerEffet(j)) {
				p.setEtatPartie(false);
			}
		} else if (e instanceof Escalier) {
			if (((Escalier) e).getMonter()) {
				j.setEtageCourant(j.getEtageCourant() - 1);

			} else {
				j.setEtageCourant(j.getEtageCourant() + 1);
			}
			
			courant = p.getEtage(j.getEtageCourant());
			j.setPosition(courant.getPointCaseEscalier(e.getReference()));
		}
	}
}
