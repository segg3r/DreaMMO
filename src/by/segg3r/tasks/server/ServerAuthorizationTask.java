package by.segg3r.tasks.server;

import java.util.List;

import by.segg3r.ServerApplicationContext;
import by.segg3r.dao.DAOFactory;
import by.segg3r.dao.exceptions.DAOException;
import by.segg3r.dao.ifaces.IGameCharacterDAO;
import by.segg3r.dao.ifaces.IUserDAO;
import by.segg3r.entities.GameCharacter;
import by.segg3r.entities.User;
import by.segg3r.net.Client;
import by.segg3r.net.Server;
import by.segg3r.net.task.AbstractTask;
import by.segg3r.net.task.exceptions.TaskExecutionException;
import by.segg3r.tasks.client.ClientAddGameCharacterTask;
import by.segg3r.tasks.client.ClientSuccessfullAuthorizationTask;

/**
 * The Class ClientAuthorizationTask.
 */
public class ServerAuthorizationTask extends AbstractTask {

	private static final long serialVersionUID = -4637398194326277934L;

	private static final String CHARACTER_IS_ALREADY_LOGINNED_ERROR = "Character is already loginned";

	private String login;
	private String password;

	private User user;
	private GameCharacter gameCharacter;

	/**
	 * Instantiates a new client authorization task.
	 * 
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 */
	public ServerAuthorizationTask(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.segg3r.net.task.AbstractTask#execute()
	 */
	@Override
	public void execute() throws TaskExecutionException {
		try {
			Server server = ServerApplicationContext.getServer();

			IUserDAO userDAO = DAOFactory.getUserDAO();
			IGameCharacterDAO gameCharacterDAO = DAOFactory
					.getGameCharacterDAO();

			user = userDAO.getUser(login, password);
			gameCharacter = gameCharacterDAO.getGameCharacter(user);

			synchronized (ServerAuthorizationTask.class) {
				if (server.isGameCharacterLoginned(gameCharacter)) {
					throw new TaskExecutionException(
							CHARACTER_IS_ALREADY_LOGINNED_ERROR);
				}

				Client client = getClient();
				sendNewCharacterToLoginnedCharacters();

				client.sendTask(new ClientSuccessfullAuthorizationTask(user));
				setLoginnedCharactersToNewCharacter();

				server.gameCharacterLogin(gameCharacter, client);
			}
		} catch (DAOException e) {
			throw new TaskExecutionException(e.getMessage());
		}
	}

	/**
	 * Send new character to loginned characters.
	 */
	private void sendNewCharacterToLoginnedCharacters() {
		System.out.println("sendNewCharacterToLoginnedCharacters");

		Server server = ServerApplicationContext.getServer();
		AbstractTask addLoginnedCharacterTask = new ClientAddGameCharacterTask(
				gameCharacter);
		server.sendTaskToAllLoginned(addLoginnedCharacterTask);
	}

	/**
	 * Sets the loginned characters to new character.
	 */
	private void setLoginnedCharactersToNewCharacter() {
		System.out.println("setLoginnedCharactersToNewCharacter");
		Client client = getClient();
		Server server = ServerApplicationContext.getServer();
		List<GameCharacter> loginnedGameCharacters = server
				.getLoginnedGameCharacters();
		for (GameCharacter gameCharacter : loginnedGameCharacters) {
			AbstractTask sendCharacterToNewClientTask = new ClientAddGameCharacterTask(
					gameCharacter);
			client.sendTask(sendCharacterToNewClientTask);
		}
	}

	/**
	 * Gets the login.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 * 
	 * @param login
	 *            the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
