package by.segg3r.dao.ifaces;

import by.segg3r.dao.exceptions.DAOException;
import by.segg3r.entities.User;

/**
 * The Interface IUserDAO.
 */
public interface IUserDAO {

	public static class Errors {
		public static final String USER_ALREADY_EXISTS_ERROR = "User already exists";
		public static final String WRONG_LOGIN_PASSWORD_COMBINATION = "Wrong login/password combination";
	}

	public static class Messages {
		public static final String SUCCESSFULL_REGISTRATION = "Registration is successful";
	}

	/**
	 * Register user.
	 * 
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 * @return the user
	 * @throws DAOException
	 *             the DAO exception
	 */
	User registerUser(String login, String password) throws DAOException;

	/**
	 * Gets the user.
	 * 
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 * @return the user
	 * @throws DAOException
	 *             the DAO exception
	 */
	User getUser(String login, String password) throws DAOException;

}
