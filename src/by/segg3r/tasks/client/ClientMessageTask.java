package by.segg3r.tasks.client;

import by.segg3r.net.task.AbstractTask;
import by.segg3r.net.task.exceptions.TaskExecutionException;

/**
 * The Class ServerExceptionTask.
 */
public class ClientMessageTask extends AbstractTask {

	private static final long serialVersionUID = -2635023920379962806L;

	private String message;

	/**
	 * Instantiates a new server exception task.
	 * 
	 * @param message
	 *            the message
	 */
	public ClientMessageTask(String message) {
		super();
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.segg3r.net.task.AbstractTask#execute()
	 */
	@Override
	public void execute() throws TaskExecutionException {
		System.out.println("Server message : " + message);
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 * 
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
