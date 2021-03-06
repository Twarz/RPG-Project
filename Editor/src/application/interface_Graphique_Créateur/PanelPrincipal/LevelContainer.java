package application.interface_Graphique_Cr�ateur.PanelPrincipal;

import java.util.HashMap;
import java.util.Map;

import application.fonction.Origine;

public class LevelContainer{

	private Map<String, Level> listeLevel; 
	private Level level;

	public LevelContainer() {
		this.listeLevel = new HashMap<String, Level>();  
	}

	public Level getLevel() {
		return this.level;
	}

	public Map<String, Level> getListeLevel() {
		return listeLevel;
	}

	public void ajouterLevel(String string,Level level){
		this.listeLevel.put(string, level);
	}

	public void changerLevel(String cl�){
		Origine.reset();
		this.level = this.listeLevel.get(cl�);
		PanelPrincipalCr�ateur.getPanel().repaint();
	}
}