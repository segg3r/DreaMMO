package by.segg3r.dao.ifaces;

import by.segg3r.dao.exceptions.DAOException;
import by.segg3r.entities.User;

/**
 * The Interface IUserDAO.
 */
public interface IUserDAO {

	/**
	 * Register user.
	 * 
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 * @return the user
	 */
	User registerUser(String login, String password) throws DAOException;

}
