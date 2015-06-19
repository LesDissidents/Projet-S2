package projets2.affichage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class Gagne extends BasicGameState {
	private int score;
	private String nomPartie;
	private int id;
	public static final String scorePath = "ressources/score.txt";
	
	public Gagne(int id, int difficulte, String nomPartie, int nbDeplacements) {
		this.score = nbDeplacements*100/(difficulte+1);
		try{
			FileWriter fw = new FileWriter(scorePath, true);
			BufferedWriter output = new BufferedWriter(fw);
			output.write(this.nomPartie + " : " + score + "points\n");
			output.flush();
			output.close();
			System.out.println("fichier créé");
		}
		catch(IOException ioe){
			System.out.print("Erreur : ");
			ioe.printStackTrace();
		}

	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		g.drawString("Bravo, "+nomPartie+"! Vous avez gagné avec : " + score + " points !", 100, 100);
		g.drawString("Tableau des scores :", 100,200);
		String chaine="";
		try{
			InputStream ips=new FileInputStream(Gagne.scorePath); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while((ligne=br.readLine())!=null){
				chaine+=ligne +"\n";
			}
			br.close();
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		g.drawString(chaine, 100,500);
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
	}

	@Override
	public int getID() {
		return 7;
	}


}
