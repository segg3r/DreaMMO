package by.segg3r;

import java.io.IOException;

import by.segg3r.net.Server;

public class ApplicationContext {

	private static Server server;

	public static void initialize(int port) {
		try {
			server = new Server(port);
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Server getServer() {
		return server;
	}

}
