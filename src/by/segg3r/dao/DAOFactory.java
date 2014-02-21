package by.segg3r.dao;

import by.segg3r.dao.ifaces.IUserDAO;
import by.segg3r.dao.impl.db.UserDAOImplDB;

/**
 * A factory for creating DAO objects.
 */
public class DAOFactory {

	/**
	 * Gets the user dao.
	 * 
	 * @return the user dao
	 */
	public static IUserDAO getUserDAO() {
		return new UserDAOImplDB();
	}

}
