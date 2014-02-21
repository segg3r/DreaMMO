package by.segg3r.net.task.impl.client;

import by.segg3r.dao.DAOFactory;
import by.segg3r.dao.exceptions.DAOException;
import by.segg3r.dao.ifaces.IUserDAO;
import by.segg3r.entities.User;
import by.segg3r.net.task.AbstractTask;

/**
 * The Class ClientRegistrationTask.
 */
public class ClientRegistrationTask extends AbstractTask {

	private static final long serialVersionUID = 1L;

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
	public ClientRegistrationTask(String login, String password) {
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
	public void execute() {
		IUserDAO userDAO = DAOFactory.getUserDAO();
		try {
			User user = userDAO.registerUser(login, password);
			System.out.println("Registered user id = " + user.getId());
		} catch (DAOException e) {
			System.out.println("Error registering user with login " + login);
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
