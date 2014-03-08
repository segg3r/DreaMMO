package by.segg3r.tasks.server;

import by.segg3r.dao.DAOFactory;
import by.segg3r.dao.exceptions.DAOException;
import by.segg3r.dao.ifaces.IGameCharacterDAO;
import by.segg3r.dao.ifaces.IUserDAO;
import by.segg3r.entities.User;
import by.segg3r.net.Client;
import by.segg3r.net.task.AbstractTask;
import by.segg3r.net.task.exceptions.TaskExecutionException;
import by.segg3r.tasks.client.ClientMessageTask;

/**
 * The Class ClientRegistrationTask.
 */
public class ServerRegistrationTask extends AbstractTask {

	private static final long serialVersionUID = -7109741155671930793L;

	private String login;
	private String password;

	/**
	 * Instantiates a new client registration task.
	 * 
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 */
	public ServerRegistrationTask(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.segg3r.net.task.AbstractTask#execute()
	 */
	@Override
	public void execute() throws TaskExecutionException {
		try {
			IUserDAO userDAO = DAOFactory.getUserDAO();
			IGameCharacterDAO gameCharacterDAO = DAOFactory
					.getGameCharacterDAO();

			User user = userDAO.registerUser(login, password);
			gameCharacterDAO.createGameCharacter(user);

			Client client = getClient();
			client.sendTask(new ClientMessageTask(
					IUserDAO.Messages.SUCCESSFULL_REGISTRATION));
		} catch (DAOException e) {
			throw new TaskExecutionException(e.getMessage());
		}
	}

	/**
	 * Gets the login.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 * 
	 * @param login
	 *            the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
