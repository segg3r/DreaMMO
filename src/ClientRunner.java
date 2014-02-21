import by.segg3r.ClientApplicationContext;
import by.segg3r.log.impl.ConsoleLog;
import by.segg3r.net.Client;
import by.segg3r.tasks.server.ServerAuthorizationTask;

public class ClientRunner {

	private static final String URL = "localhost";
	private static final int PORT = 14804;

	public static void main(String[] args) {
		ClientApplicationContext.initializeGameWindow();
		ClientApplicationContext.initializeLog(new ConsoleLog());
		ClientApplicationContext.initializeClient(URL, PORT);

		Client client = ClientApplicationContext.getClient();
		client.sendTask(new ServerAuthorizationTask("user", "login"));
	}

}
