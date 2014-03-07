package by.segg3r.dao;

import by.segg3r.dao.ifaces.IGameCharacterDAO;
import by.segg3r.dao.ifaces.IUserDAO;
import by.segg3r.dao.impl.db.GameCharacterDAOImplDB;
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

	/**
	 * Gets the game character dao.
	 * 
	 * @return the game character dao
	 */
	public static IGameCharacterDAO getGameCharacterDAO() {
		return new GameCharacterDAOImplDB();
	}

}
