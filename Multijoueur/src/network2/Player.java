package network2;
import java.awt.Graphics;
import java.io.Serializable;


public class Player implements Serializable{

	private String pseudo;
	private int positionX;
	private int positionY;
	
	public Player(String pseudo){
		this.pseudo = pseudo;
		this.initialiser();
	}
	
	private void initialiser(){
		this.positionX = 20; //BDD.getPositionX(this.pseudo);
		this.positionY = 20; //BDD.getPositionY(this.pseudo);
		System.out.println("Cr�ation de " + this);
	}

	public void afficherPersonnage(Graphics g){
		g.fillRect(this.positionX, this.positionY, 20, 20);
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public int getPositionY() {
		return this.positionY;
	}
	
	public int getPositionX() {
		return this.positionX;
	}
	
	@Override
	public String toString() {
		return  this.pseudo + " (" + this.positionX	+ ";" + this.positionY + ")";
	}
}