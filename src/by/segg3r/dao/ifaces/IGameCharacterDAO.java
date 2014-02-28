package by.segg3r.dao.ifaces;

import by.segg3r.dao.exceptions.DAOException;
import by.segg3r.entities.GameCharacter;
import by.segg3r.entities.User;

/**
 * The Interface IGameCharacterDAO.
 */
public interface IGameCharacterDAO {

	/**
	 * Creates the game character.
	 * 
	 * @param user
	 *            the user
	 * @throws DAOException
	 *             the DAO exception
	 */
	GameCharacter createGameCharacter(User user) throws DAOException;

	/**
	 * Gets the game character.
	 * 
	 * @param user
	 *            the user
	 * @return the game character
	 * @throws DAOException
	 *             the DAO exception
	 */
	GameCharacter getGameCharacter(User user) throws DAOException;

}
