import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import by.segg3r.net.Client;

public class ClientRunner {

	private static final String URL = "localhost";
	private static final int PORT = 14804;

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(URL, PORT);
			Client client = new Client(socket);
			client.start();

			System.out.println("Connected to server at " + URL + ":" + PORT);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
