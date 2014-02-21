package by.segg3r.tasks.client;

import by.segg3r.ClientApplicationContext;
import by.segg3r.entities.User;
import by.segg3r.net.task.AbstractTask;
import by.segg3r.net.task.exceptions.TaskExecutionException;

/**
 * The Class ClientSuccessfullAuthorizationTask.
 */
public class ClientSuccessfullAuthorizationTask extends AbstractTask {

	private static final long serialVersionUID = -844832293826087095L;

	private User user;

	/**
	 * Instantiates a new client successfull authorization task.
	 * 
	 * @param user
	 *            the user
	 */
	public ClientSuccessfullAuthorizationTask(User user) {
		super();
		this.setUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.segg3r.net.task.AbstractTask#execute()
	 */
	@Override
	public void execute() throws TaskExecutionException {
		ClientApplicationContext.getLog().printMessage(
				"Authorization successfull " + user);
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
