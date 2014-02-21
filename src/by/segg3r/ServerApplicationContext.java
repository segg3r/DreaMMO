package by.segg3r;

import java.io.IOException;

import by.segg3r.log.ILog;
import by.segg3r.log.impl.ConsoleLog;
import by.segg3r.net.Server;

public class ServerApplicationContext {

	private static final ILog LOG = new ConsoleLog();

	private static Server server;

	public static void initialize(int port) {
		try {
			server = new Server(port);
			server.start();
		} catch (IOException e) {
			LOG.printMessage("Error starting server at port " + port);
		}
	}

	public static Server getServer() {
		return server;
	}

	public static ILog getLog() {
		return LOG;
	}

}
