package by.segg3r.tasks.server;

import by.segg3r.dao.DAOFactory;
import by.segg3r.dao.exceptions.DAOException;
import by.segg3r.dao.ifaces.IGameCharacterDAO;
import by.segg3r.dao.ifaces.IUserDAO;
import by.segg3r.entities.GameCharacter;
import by.segg3r.entities.User;
import by.segg3r.net.Client;
import by.segg3r.net.task.AbstractTask;
import by.segg3r.net.task.exceptions.TaskExecutionException;
import by.segg3r.tasks.client.ClientSuccessfullAuthorizationTask;

/**
 * The Class ClientAuthorizationTask.
 */
public class ServerAuthorizationTask extends AbstractTask {

	private static final long serialVersionUID = 3402653989197611624L;

	private String login;
	private String password;

	private User user;
	private GameCharacter gameCharacter;

	/**
	 * Instantiates a new client authorization task.
	 * 
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 */
	public ServerAuthorizationTask(String login, String password) {
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

			user = userDAO.getUser(login, password);
			gameCharacter = gameCharacterDAO.getGameCharacter(user);

			Client client = getClient();
			client.sendTask(new ClientSuccessfullAuthorizationTask(user));
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
