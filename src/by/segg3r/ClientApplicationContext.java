package by.segg3r;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import by.segg3r.log.ILog;
import by.segg3r.log.impl.ConsoleLog;
import by.segg3r.net.Client;

public class ClientApplicationContext {

	private static final ILog LOG = new ConsoleLog();

	private static Client client;

	public static void initialize(String url, int port) {
		try {
			Socket socket = new Socket(url, port);
			client = new Client(socket);
			client.start();

			LOG.printMessage("Connected to server at " + url + ":" + port);
		} catch (UnknownHostException e) {
			LOG.printException(e);
		} catch (IOException e) {
			LOG.printException(e);
		}
	}

	public static Client getClient() {
		return client;
	}

	public static ILog getLog() {
		return LOG;
	}

}
