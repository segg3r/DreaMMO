package by.segg3r;

import java.io.IOException;

import by.segg3r.log.ILog;
import by.segg3r.net.Server;

/**
 * The Class ServerApplicationContext.
 */
public class ServerApplicationContext {

	private static ILog log;
	private static Server server;

	/**
	 * Initialize log.
	 * 
	 * @param log
	 *            the log
	 */
	public static void initializeLog(ILog log) {
		ServerApplicationContext.log = log;
	}

	/**
	 * Initialize server.
	 * 
	 * @param port
	 *            the port
	 */
	public static void initializeServer(int port) {
		try {
			server = new Server(port);
			server.start();
		} catch (IOException e) {
			log.printMessage("Error starting server at port " + port);
		}
	}

	/**
	 * Gets the server.
	 * 
	 * @return the server
	 */
	public static Server getServer() {
		return server;
	}

	/**
	 * Gets the log.
	 * 
	 * @return the log
	 */
	public static ILog getLog() {
		return log;
	}

}
