package by.segg3r;

import java.io.IOException;

import by.segg3r.net.Server;

public class ServerApplicationContext {

	private static Server server;

	public static void initialize(int port) {
		try {
			server = new Server(port);
			server.start();
		} catch (IOException e) {
			System.out.println("Error starting server at port " + port);
		}
	}

	public static Server getServer() {
		return server;
	}

}
