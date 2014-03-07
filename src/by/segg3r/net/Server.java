package by.segg3r.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import by.segg3r.ServerApplicationContext;
import by.segg3r.entities.GameCharacter;
import by.segg3r.net.task.AbstractTask;

/**
 * The Class Server.
 */
public class Server extends Thread {

	private ServerSocket serverSocket;
	private List<Client> clients;
	private Map<GameCharacter, Client> gameCharacterMapping;

	/**
	 * Instantiates a new server.
	 * 
	 * @param port
	 *            the port number
	 * @throws IOException
	 *             Signals that port is not listened.
	 */
	public Server(int port) throws IOException {
		super();
		this.serverSocket = new ServerSocket(port);
		this.clients = new ArrayList<Client>();
		this.gameCharacterMapping = new HashMap<GameCharacter, Client>();

		ServerApplicationContext.getLog().printMessage(
				"Server initialized at port " + port);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Socket clientSocket;
		while (true) {
			try {
				clientSocket = serverSocket.accept();

				ServerApplicationContext.getLog().printMessage(
						"Client connected : " + clientSocket.getInetAddress());
				Client client = new Client(clientSocket);
				clients.add(client);
				client.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Send task to all.
	 * 
	 * @param task
	 *            the task
	 */
	public void sendTaskToAll(AbstractTask task) {
		for (Client client : clients) {
			client.sendTask(task);
		}
	}

	/**
	 * Send all but one.
	 * 
	 * @param exceptedClient
	 *            the excepted client
	 * @param task
	 *            the task
	 */
	public void sendAllButOne(Client exceptedClient, AbstractTask task) {
		for (Client client : clients) {
			if (!client.equals(exceptedClient)) {
				client.sendTask(task);
			}
		}
	}

	/**
	 * Game character loginned.
	 * 
	 * @param gameCharacter
	 *            the game character
	 * @param client
	 *            the client
	 */
	public void gameCharacterLogin(GameCharacter gameCharacter, Client client) {
		this.gameCharacterMapping.put(gameCharacter, client);
	}

	/**
	 * Game character logouted.
	 * 
	 * @param gameCharacter
	 *            the game character
	 */
	public void gameCharacterLogout(GameCharacter gameCharacter) {
		this.gameCharacterMapping.remove(gameCharacter);
	}

	/**
	 * Checks if is client loginned.
	 * 
	 * @param client
	 *            the client
	 * @return true, if is client loginned
	 */
	public boolean isClientLoginned(Client client) {
		return this.gameCharacterMapping.containsValue(client);
	}

	/**
	 * Send task to all loginned.
	 * 
	 * @param task
	 *            the task
	 */
	public void sendTaskToAllLoginned(AbstractTask task) {
		for (Client client : this.gameCharacterMapping.values()) {
			client.sendTask(task);
		}
	}

	/**
	 * Send task to all loginned but one.
	 * 
	 * @param exceptedClient
	 *            the excepted client
	 * @param task
	 *            the task
	 */
	public void sendTaskToAllLoginnedButOne(Client exceptedClient,
			AbstractTask task) {
		for (Client client : this.gameCharacterMapping.values()) {
			if (!client.equals(exceptedClient)) {
				client.sendTask(task);
			}
		}
	}

	/**
	 * Send task to all but one.
	 * 
	 * @param exceptedGameCharacter
	 *            the excepted game character
	 * @param task
	 *            the task
	 */
	public void sendTaskToAllButOne(GameCharacter exceptedGameCharacter,
			AbstractTask task) {
		Set<GameCharacter> gameCharacters = this.gameCharacterMapping.keySet();
		for (GameCharacter gameCharacter : gameCharacters) {
			if (!gameCharacter.equals(exceptedGameCharacter)) {
				Client client = this.gameCharacterMapping.get(gameCharacter);
				client.sendTask(task);
			}
		}
	}

	/**
	 * Gets the loginned game characters.
	 * 
	 * @return the loginned game characters
	 */
	public List<GameCharacter> getLoginnedGameCharacters() {
		List<GameCharacter> result = new ArrayList<GameCharacter>();

		Set<GameCharacter> loginnedGameCharacters = this.gameCharacterMapping
				.keySet();
		result.addAll(loginnedGameCharacters);
		return result;
	}

}
