package by.segg3r.tasks.client;

import by.segg3r.ClientApplicationContext;
import by.segg3r.entities.GameCharacter;
import by.segg3r.gamelogic.ClientGameLogic;
import by.segg3r.net.task.AbstractTask;
import by.segg3r.net.task.exceptions.TaskExecutionException;

/**
 * The Class ClientAddGameCharacterTask.
 */
public class ClientAddGameCharacterTask extends AbstractTask {

	private static final long serialVersionUID = -5967205928533235747L;

	private GameCharacter gameCharacter;

	/**
	 * Instantiates a new client add game character task.
	 * 
	 * @param gameCharacter
	 *            the game character
	 */
	public ClientAddGameCharacterTask(GameCharacter gameCharacter) {
		super();
		this.gameCharacter = gameCharacter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.segg3r.net.task.AbstractTask#execute()
	 */
	@Override
	public void execute() throws TaskExecutionException {
		ClientGameLogic clientGameLogic = ClientApplicationContext
				.getClientGameLogic();
		clientGameLogic.addGameCharacter(gameCharacter);

		System.out.println("User connected " + gameCharacter);
	}

}
