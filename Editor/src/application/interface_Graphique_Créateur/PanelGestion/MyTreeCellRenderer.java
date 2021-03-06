package application.interface_Graphique_Cr�ateur.PanelGestion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

@SuppressWarnings("serial")
public class MyTreeCellRenderer extends DefaultTreeCellRenderer {


	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel,boolean expanded, boolean leaf, int row, boolean hasFocus) {

		setText(value.toString() );
		setForeground(Color.BLACK);
		setFont(new Font("Courrier", Font.PLAIN ,12));
		this.setBackgroundNonSelectionColor(new Color(245, 245, 245));
		if(sel) {

			if(value.toString().contains(".txt")){
				setFont(new Font("Courrier", Font.BOLD ,12));
				setForeground(new Color(110,0,50)); //Ou la couleur que tu veux
			}else{
				setFont(new Font("Courrier", Font.BOLD ,12));
				setForeground(new Color(50,0,110)); //Ou la couleur que tu veux
			}
		}
		return this;
	}
}
