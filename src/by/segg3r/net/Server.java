package by.segg3r.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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

		System.out.println("Server initialized at port " + port);
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

				System.out.println("Client connected : "
						+ clientSocket.getInetAddress());

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

}
