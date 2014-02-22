package by.segg3r.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import by.segg3r.log.ILog;
import by.segg3r.net.task.AbstractTask;
import by.segg3r.tasks.ClientTaskEnvironment;
import by.segg3r.tasks.StreamInitializationTask;

/**
 * The Class Client.
 */
public class Client extends Thread {

	private static ILog log;

	public static void setLog(ILog log) {
		Client.log = log;
	}

	private ObjectInputStream in;
	private ObjectOutputStream out;
	private ClientTaskEnvironment clientTaskEnvironment;

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
		this.clientTaskEnvironment = new ClientTaskEnvironment(this);
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
				clientTaskEnvironment.executeTask(task);
			}
		} catch (Exception e) {
			log.printException(e);
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
			log.printException(e);
		}
	}

}
