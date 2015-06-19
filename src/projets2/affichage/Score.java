package projets2.affichage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Score extends BasicGameState {
	private int id;

	public Score(int id) {
		this.id = id;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Ceci est la fenetre de score", 100, 100);
		String chaine = "";
		try {
			InputStream ips=new FileInputStream(Gagne.scorePath); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while((ligne=br.readLine())!=null){
				chaine+= ligne +"\n";
			}
			br.close();
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		g.drawString(chaine, 100,300);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			sbg.enterState(Game.menu);
		}
	}

	@Override
	public int getID() {
		return this.id;
	}
}
