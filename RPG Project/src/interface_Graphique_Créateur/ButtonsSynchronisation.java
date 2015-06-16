package interface_Graphique_Cr�ateur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonsSynchronisation extends JPanel{
	
	protected ButtonAjoutCarte buttonAjoutCarte;
	protected ButtonAjoutDossier buttonAjoutDossier;
	protected ButtonSupprimer buttonSupprimer;
	
	public ButtonsSynchronisation(){
		super();
		this.setLayout(null);
		this.setBounds(5, 380, 170, 120);
		this.buttonAjoutCarte = new ButtonAjoutCarte(this);
		this.buttonAjoutDossier = new ButtonAjoutDossier(this);
		this.buttonSupprimer = new ButtonSupprimer(this);
		this.add(this.buttonAjoutCarte);
		this.add(this.buttonAjoutDossier);
		this.add(this.buttonSupprimer);
	}
}
