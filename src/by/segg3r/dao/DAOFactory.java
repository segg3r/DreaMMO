package by.segg3r.dao;

import by.segg3r.dao.impl.db.UserDAOImplDB;

public class DAOFactory {

	public static IUserDAO getUserDAO() {
		return new UserDAOImplDB();
	}

}
