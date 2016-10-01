 package game;

import java.awt.Color;
import java.awt.Graphics;

import hero.Coord;

public class CarteFeu extends Carte{

	private static final int TAILLE_MAX_X = 20;
	private static final int TAILLE_MAX_Y = 20;

	public CarteFeu() {
		super("feu", CarteFeu.TAILLE_MAX_X, CarteFeu.TAILLE_MAX_Y, 600, 200);
		
		for (int i=0; i <= TAILLE_MAX_X-1; i++){
			for (int j=0; j <= TAILLE_MAX_Y-1; j++){
				if (i == j)
					this.setCoordonnées(i, j, new Coord(1));
				else
					this.setCoordonnées(i, j, new Coord(0));
			}
		}
	}

	@Override
	public int getTailleMaxX() {
		return CarteFeu.TAILLE_MAX_X;
	}

	@Override
	public int getTailleMaxY() {
		return CarteFeu.TAILLE_MAX_Y;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(120,120,120));
		for (int i=0; i <= this.getTailleMaxX()-1; i++){
			for (int j=0; j <= this.getTailleMaxY()-1; j++){
				if (this.getMap()[i][j].getComposante() == 1)
					g.fillRect(20*i, 20*j, 20, 20);
			}
		}
	}
}
