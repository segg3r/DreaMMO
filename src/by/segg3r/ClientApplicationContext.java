package by.segg3r;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import by.segg3r.net.Client;

public class ClientApplicationContext {

	private static Client client;

	public static void initialize(String url, int port) {
		try {
			Socket socket = new Socket(url, port);
			client = new Client(socket);
			client.start();

			System.out.println("Connected to server at " + url + ":" + port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Client getClient() {
		return client;
	}

}
