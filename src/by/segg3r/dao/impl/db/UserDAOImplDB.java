package by.segg3r.dao.impl.db;

import by.segg3r.dao.DBEntityDAOService;
import by.segg3r.dao.IUserDAO;
import by.segg3r.entities.User;

/**
 * The Class UserDAOImplDB.
 */
public class UserDAOImplDB implements IUserDAO {

	/**
	 * Instantiates a new user dao impl db.
	 */
	public UserDAOImplDB() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.segg3r.dao.IUserDAO#registerUser(java.lang.String,
	 * java.lang.String)
	 */
	public User registerUser(String login, String password) {
		User user = new User(login, password);
		return DBEntityDAOService.saveEntity(user);
	}

}
