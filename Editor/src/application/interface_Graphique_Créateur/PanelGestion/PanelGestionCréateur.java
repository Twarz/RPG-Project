package application.interface_Graphique_Créateur.PanelGestion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JLabel;

import application.interface_Graphique_Créateur.BorderGray;
import application.interface_Graphique_Créateur.FrameCréateur;
import application.interface_Graphique_Créateur.SousPanel;

@SuppressWarnings("serial")
public class PanelGestionCréateur extends SousPanel {

	private JLabel titre;
	private ArbreCartes arbre;
	private ModelArbreCarte model;
	private ButtonsSynchronisation boutons;

	private static PanelGestionCréateur instance;
	
	public static PanelGestionCréateur getPanel(){
		if (instance == null){
			instance = new PanelGestionCréateur();
			instance.setBounds(10, 200, 180, FrameCréateur.getFrame().getHeight() - 270 );
		}
		return instance;
	}
	
	private PanelGestionCréateur() {
		super();
		this.setLayout(null);
		this.setBorder(new BorderGray());
		this.setBackground(new Color(245, 245, 245));
		this.setBounds(10, 200, 180, Toolkit.getDefaultToolkit().getScreenSize().height - 270);
		this.boutons = new ButtonsSynchronisation();
		this.boutons.setBounds(5, (int)this.getSize().getHeight()-120,170, 120);
		this.add(this.boutons);
		this.titre = new JLabel("Gestion des cartes");
		this.titre.setFont(new Font("Arial", 18, 18));
		this.titre.setBounds(10, 10, 160, 40);
		this.add(this.titre);
		this.model = new ModelArbreCarte(new File("cartes"));
		this.arbre = new ArbreCartes(this.boutons, this.model);
		this.arbre.setCellRenderer(new MyTreeCellRenderer());
		this.add(this.arbre);
	}

	public ArbreCartes getArbre() {
		return arbre;
	}

	public void raffraichir(){}
}
