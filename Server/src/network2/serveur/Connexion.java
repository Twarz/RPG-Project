package network2.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import network2.ConnectedClient;
import network2.Player;
import network2.client.SocketClient;

public class Connexion implements Runnable {

	private static Map<String,ConnectedClient> clientList;

	public Connexion(){
		if (Connexion.clientList == null) {
			Connexion.clientList = new HashMap<String,ConnectedClient>();
		}
	}

	public static void addClient(String pseudo, ConnectedClient identifiantClient){
		Connexion.clientList.put(pseudo, identifiantClient);
	}

	public static ConnectedClient getClient(String pseudo){
		return Connexion.clientList.get(pseudo);
	}
	
	public static void updatePlayer(Player player){
		Connexion.getClient(player.getPseudo()).setPerso(player);
	}

	public static void removeClient(String pseudo){
		Server.print(Connexion.clientList.get(pseudo).getPers().toString() + " s'est d�connect�.");
		Connexion.clientList.remove(pseudo);
	}

	public static Map<String,ConnectedClient> getListeClient(){
		return Connexion.clientList;
	}

	@Override
	public void run() {
		int nbCo = 0;
		while(nbCo <3){
			this.registerPlayer(); 
			nbCo++;
		}
	}


	private void startPlayerCommunication(Player player) {
		Thread t1 = new Thread(new CommunicationServer(player));
		t1.start();
	}

	private void registerPlayer(){
		Socket socketPlayer = this.listenSocketServer();
		System.out.println("ecout�");
		this.welcomePlayer(socketPlayer);
		this.register(socketPlayer);
	}


	private void welcomePlayer(Socket socketPlayer) {
		try {
			this.send(new PrintWriter(socketPlayer.getOutputStream()),"Bienvenue !!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void register(Socket socketPlayer){
		try {
			ObjectInputStream in = new ObjectInputStream(socketPlayer.getInputStream());
			Player player= (Player)in.readObject();
				Server.print(" [SERVEUR] --> " + player + " vient de se connecter au serveur");
				Connexion.addClient(player.getPseudo(), new ConnectedClient(socketPlayer,player));
				this.startPlayerCommunication(player);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void send(PrintWriter out, String message) {
		out.println(" [SERVEUR] --> " + message);
		out.flush();
	}

	private Socket listenSocketServer() {
		try {
			return Server.getInstance().getSocketServer().accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}