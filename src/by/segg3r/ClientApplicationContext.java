package by.segg3r;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import by.segg3r.gamelogic.ClientGameLogic;
import by.segg3r.log.ILog;
import by.segg3r.net.Client;
import by.segg3r.tasklisteners.client.ConnectionWindowDisableButtonsTaskListener;
import by.segg3r.tasklisteners.client.ConnectionWindowEnableButtonsTaskListener;
import by.segg3r.ui.ConnectionWindow;
import by.segg3r.ui.GameWindow;

/**
 * The Class ClientApplicationContext.
 */
public class ClientApplicationContext {

	private static ILog log;
	private static Client client;
	private static ConnectionWindow connectionWindow;
	private static GameWindow gameWindow;
	private static ClientGameLogic clientGameLogic;

	/**
	 * Initialize ui.
	 * 
	 * @param client
	 *            the client
	 */
	public static void initializeConnectionWindow(Client client) {
		connectionWindow = new ConnectionWindow();
		connectionWindow.setVisible(true);

		ConnectionWindowEnableButtonsTaskListener connectionWindowEnableButtonsTaskListener = new ConnectionWindowEnableButtonsTaskListener(
				connectionWindow);
		client.addRecieveTaskListener(connectionWindowEnableButtonsTaskListener);
		ConnectionWindowDisableButtonsTaskListener connectionWindowDisableButtonsTaskListener = new ConnectionWindowDisableButtonsTaskListener(
				connectionWindow);
		client.addSendTaskListener(connectionWindowDisableButtonsTaskListener);
	}

	/**
	 * Initialize game window.
	 */
	public static void initializeGameWindow() {
		connectionWindow.dispose();

		initializeClientGameLogic();

		gameWindow = new GameWindow();
		gameWindow.setVisible(true);
	}

	/**
	 * Initialize client game logic.
	 */
	public static void initializeClientGameLogic() {
		clientGameLogic = new ClientGameLogic();
	}

	/**
	 * Initialize log.
	 * 
	 * @param log
	 *            the log
	 */
	public static void initializeLog(ILog log) {
		ClientApplicationContext.log = log;
	}

	/**
	 * Initialize client.
	 * 
	 * @param url
	 *            the url
	 * @param port
	 *            the port
	 */
	public static void initializeClient(String url, int port) {
		try {
			Socket socket = new Socket(url, port);
			client = new Client(socket);
			client.start();

			log.printMessage("Connected to server at " + url + ":" + port);
		} catch (UnknownHostException e) {
			log.printException(e);
		} catch (IOException e) {
			log.printException(e);
		}
	}

	/**
	 * Gets the client.
	 * 
	 * @return the client
	 */
	public static Client getClient() {
		return client;
	}

	/**
	 * Gets the log.
	 * 
	 * @return the log
	 */
	public static ILog getLog() {
		return log;
	}

	/**
	 * Gets the client game logic.
	 * 
	 * @return the client game logic
	 */
	public static ClientGameLogic getClientGameLogic() {
		return clientGameLogic;
	}

}
