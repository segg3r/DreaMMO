package by.segg3r.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import by.segg3r.net.task.Task;
import by.segg3r.net.task.TaskFactory;

/**
 * The Class Client.
 */
public class Client extends Thread {

	private DataInputStream in;
	private DataOutputStream out;

	/**
	 * Instantiates a new client.
	 * 
	 * @param socket
	 *            the socket
	 * @throws IOException
	 *             if socket stream are impossible to get.
	 */
	public Client(Socket socket) throws IOException {
		this.in = new DataInputStream(socket.getInputStream());
		this.out = new DataOutputStream(socket.getOutputStream());
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
				int taskId = in.readInt();
				Task task = TaskFactory.getClassFromFactory(taskId);
				task.readDataFromStream(in);
				task.execute();
			}
		} catch (IOException e) {
			System.out.println("Lost server connection");
		}
	}

	/**
	 * Send task.
	 * 
	 * @param task
	 *            the task
	 */
	public void sendTask(Task task) {
		task.writeDataToStream(out);
	}

}
