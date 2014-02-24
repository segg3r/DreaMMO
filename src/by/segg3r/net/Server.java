package by.segg3r.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import by.segg3r.ServerApplicationContext;
import by.segg3r.net.task.AbstractTask;

/**
 * The Class Server.
 */
public class Server extends Thread {

	private ServerSocket serverSocket;
	private List<Client> clients;

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

}
