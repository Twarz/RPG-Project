package application.interface_Graphique_Créateur.PanelGestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ButtonSupprimer extends JButton implements ActionListener{

	private boolean peutSupprimer;
	private ButtonsSynchronisation buttonsSynchronisation;

	public ButtonSupprimer(ButtonsSynchronisation buttonsSynchronisation){
		super("Supprimer");
		this.buttonsSynchronisation = buttonsSynchronisation;
		this.setPeutSupprimer(false);
		this.setBounds(5, 80, 160, 30);
		this.addActionListener(this);
	}

	public boolean isPeutSupprimer() {
		return peutSupprimer;
	}

	public void setPeutSupprimer(boolean peutSupprimer) {
		this.peutSupprimer = peutSupprimer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.buttonsSynchronisation.buttonAjoutCarte.setPeutCréerCarte(false);
		this.buttonsSynchronisation.buttonAjoutDossier.setPeutCréerDossier(false);
		this.buttonsSynchronisation.buttonSupprimer.setPeutSupprimer(true);
	}
}
