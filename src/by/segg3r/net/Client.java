package by.segg3r.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import by.segg3r.net.task.AbstractTask;
import by.segg3r.net.task.impl.StreamInitializationTask;

/**
 * The Class Client.
 */
public class Client extends Thread {

	private ObjectInputStream in;
	private ObjectOutputStream out;

	/**
	 * Instantiates a new client.
	 * 
	 * @param socket
	 *            the socket
	 * @throws IOException
	 *             if socket stream are impossible to get.
	 */
	public Client(Socket socket) throws IOException {
		this.out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(new StreamInitializationTask());

		this.in = new ObjectInputStream(socket.getInputStream());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try {
			while (true) {
				AbstractTask task = (AbstractTask) in.readObject();
				task.execute();
			}
		} catch (IOException e) {
			System.out.println("Lost server connection");
		} catch (ClassNotFoundException e) {
			System.out.println("Error reading server task");
		}
	}

	/**
	 * Send task.
	 * 
	 * @param task
	 *            the task
	 */
	public void sendTask(AbstractTask task) {
		try {
			out.writeObject(task);
		} catch (IOException e) {
			System.out.println("Error sending task to server");
		}
	}

}
