import by.segg3r.ClientApplicationContext;
import by.segg3r.log.impl.UILog;
import by.segg3r.net.Client;
import by.segg3r.tasks.ClientTaskEnvironment;
import by.segg3r.tasks.server.ServerExceptionTask;

public class ClientRunner {

	private static final String URL = "localhost";
	private static final int PORT = 14804;

	public static void main(String[] args) {
		ClientApplicationContext.initializeLog(new UILog());
		Client.setLog(ClientApplicationContext.getLog());
		ClientTaskEnvironment.setExceptionTask(new ServerExceptionTask());

		ClientApplicationContext.initializeClient(URL, PORT);
		ClientApplicationContext.initializeConnectionWindow(ClientApplicationContext
				.getClient());
	}

}
