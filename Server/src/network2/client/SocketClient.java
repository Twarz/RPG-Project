package network2.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient extends Socket{

	public SocketClient(String host, int port) throws UnknownHostException, IOException {
		super(InetAddress.getByName(host),port);
		System.out.println("Connexion �tablie avec le serveur");
	}
}
