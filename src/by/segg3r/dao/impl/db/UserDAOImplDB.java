package by.segg3r.dao.impl.db;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import by.segg3r.dao.DBEntityDAOService;
import by.segg3r.dao.exceptions.DAOException;
import by.segg3r.dao.ifaces.IUserDAO;
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
	public User registerUser(String login, String password) throws DAOException {
		System.out.println("Registering user with login " + login);
		synchronized (UserDAOImplDB.class) {
			List<User> existingUsersWithSameLogin = DBEntityDAOService
					.getEntitiesByCriteria(User.class,
							Restrictions.eq("login", login));
			if (!existingUsersWithSameLogin.isEmpty()) {
				throw new DAOException("User with this login already exists");
			}
			User user = new User(login, password);
			return DBEntityDAOService.saveEntity(user);
		}
	}
}
