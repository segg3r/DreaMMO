package by.segg3r.dao.impl.db;

import by.segg3r.dao.DBEntityDAOService;
import by.segg3r.dao.exceptions.DAOException;
import by.segg3r.dao.ifaces.IGameCharacterDAO;
import by.segg3r.entities.GameCharacter;
import by.segg3r.entities.User;

/**
 * The Class GameCharacterDAOImplDB.
 */
public class GameCharacterDAOImplDB implements IGameCharacterDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * by.segg3r.dao.ifaces.IGameCharacterDAO#createGameCharacter(by.segg3r.
	 * entities.User)
	 */
	public GameCharacter createGameCharacter(User user) throws DAOException {
		GameCharacter gameCharacter = new GameCharacter();
		gameCharacter.setUser(user);

		return DBEntityDAOService.saveEntity(gameCharacter);
	}
}
