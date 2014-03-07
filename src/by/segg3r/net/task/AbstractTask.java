package by.segg3r.net.task;

import java.io.Serializable;

import by.segg3r.net.Client;
import by.segg3r.net.task.exceptions.TaskExecutionException;

/**
 * The Class Task.
 */
public abstract class AbstractTask implements Serializable {

	private static final long serialVersionUID = 1L;

	private Client client;

	/**
	 * Instantiates a new task.
	 */
	public AbstractTask() {
		super();
	}

	/**
	 * Execute.
	 * 
	 * @throws TaskExecutionException
	 *             the task execution exception
	 */
	public abstract void execute() throws TaskExecutionException;

	/**
	 * Gets the client.
	 * 
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Sets the client.
	 * 
	 * @param client
	 *            the new client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

}
