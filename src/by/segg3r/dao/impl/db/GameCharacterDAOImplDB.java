package by.segg3r.dao.impl.db;

import org.hibernate.criterion.Restrictions;

import by.segg3r.ServerApplicationContext;
import by.segg3r.dao.DBEntityDAOService;
import by.segg3r.dao.exceptions.DAOException;
import by.segg3r.dao.exceptions.EntityDAOServiceException;
import by.segg3r.dao.ifaces.IGameCharacterDAO;
import by.segg3r.entities.GameCharacter;
import by.segg3r.entities.User;

/**
 * The Class GameCharacterDAOImplDB.
 */
public class GameCharacterDAOImplDB implements IGameCharacterDAO {

	public static final String TABLE_NAME = "gameCharacters";
	public static final String USER_ID_FIELD = "user.id";
	public static final String X_FIELD = "x";
	public static final String Y_FIELD = "y";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * by.segg3r.dao.ifaces.IGameCharacterDAO#createGameCharacter(by.segg3r.
	 * entities.User)
	 */
	public GameCharacter createGameCharacter(User user) throws DAOException {
		ServerApplicationContext.getLog().printMessage(
				"Game character creation for " + user);
		GameCharacter gameCharacter = new GameCharacter();
		gameCharacter.setUser(user);

		return DBEntityDAOService.saveEntity(gameCharacter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * by.segg3r.dao.ifaces.IGameCharacterDAO#getGameCharacter(by.segg3r.entities
	 * .User)
	 */
	public GameCharacter getGameCharacter(User user) throws DAOException {
		ServerApplicationContext.getLog().printMessage(
				"Getting game character for " + user);
		try {
			GameCharacter gameCharacter = DBEntityDAOService
					.getEntityByCriteria(GameCharacter.class, Restrictions.eq(
							GameCharacterDAOImplDB.USER_ID_FIELD, user.getId()));
			return gameCharacter;
		} catch (EntityDAOServiceException e) {
			throw new DAOException(e);
		}
	}
}
