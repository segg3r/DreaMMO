package by.segg3r.dao.impl.db;

import org.hibernate.Session;

import by.segg3r.dao.IUserDAO;
import by.segg3r.entities.User;

public class UserDAOImplDB implements IUserDAO {

	public UserDAOImplDB() {
		super();
	}

	public User registerUser(String login, String password) {
		Session session = DB.getSession();

		User user = new User(login, password);
		session.save(user);
		session.close();

		return user;
	}

}
