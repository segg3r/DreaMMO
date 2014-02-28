package by.segg3r.dao.impl.db;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import by.segg3r.ServerApplicationContext;
import by.segg3r.dao.DBEntityDAOService;
import by.segg3r.dao.exceptions.DAOException;
import by.segg3r.dao.exceptions.EntityDAOServiceException;
import by.segg3r.dao.ifaces.IUserDAO;
import by.segg3r.entities.User;

/**
 * The Class UserDAOImplDB.
 */
public class UserDAOImplDB implements IUserDAO {

	public static final String TABLE_NAME = "users";
	public static final String LOGIN_FIELD = "login";
	public static final String PASSWORD_FIELD = "password";

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
		synchronized (UserDAOImplDB.class) {
			ServerApplicationContext.getLog().printMessage(
					"Registering user with login " + login);
			List<User> existingUsersWithSameLogin = DBEntityDAOService
					.getEntitiesByCriteria(User.class,
							Restrictions.eq(LOGIN_FIELD, login));
			if (!existingUsersWithSameLogin.isEmpty()) {
				throw new DAOException(
						IUserDAO.Errors.USER_ALREADY_EXISTS_ERROR);
			}
			User user = new User(login, password);
			return DBEntityDAOService.saveEntity(user);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.segg3r.dao.ifaces.IUserDAO#getUser(java.lang.String,
	 * java.lang.String)
	 */
	public User getUser(String login, String password) throws DAOException {
		synchronized (UserDAOImplDB.class) {
			ServerApplicationContext.getLog().printMessage(
					"Logging in user with login " + login);
			try {
				User user = DBEntityDAOService.getEntityByCriteria(User.class,
						Restrictions.eq(LOGIN_FIELD, login),
						Restrictions.eq(PASSWORD_FIELD, password));
				return user;
			} catch (EntityDAOServiceException e) {
				throw new DAOException(
						IUserDAO.Errors.WRONG_LOGIN_PASSWORD_COMBINATION);
			}
		}
	}
}
