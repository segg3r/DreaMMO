package by.segg3r.gamelogic;

import java.util.ArrayList;
import java.util.List;

import by.segg3r.entities.GameCharacter;

/**
 * The Class ClientGameLogic.
 */
public class ClientGameLogic {

	private List<GameCharacter> gameCharacters;

	/**
	 * Instantiates a new client game logic.
	 */
	public ClientGameLogic() {
		super();
		this.gameCharacters = new ArrayList<GameCharacter>();
	}

	/**
	 * Adds the game character.
	 * 
	 * @param gameCharacter
	 *            the game character
	 */
	public void addGameCharacter(GameCharacter gameCharacter) {
		this.gameCharacters.add(gameCharacter);
	}

}
