import by.segg3r.ClientApplicationContext;
import by.segg3r.net.Client;
import by.segg3r.net.task.impl.client.RegistrationTask;

public class ClientRunner {

	private static final String URL = "localhost";
	private static final int PORT = 14804;

	public static void main(String[] args) {

		ClientApplicationContext.initialize(URL, PORT);

		Client client = ClientApplicationContext.getClient();
		client.sendTask(new RegistrationTask("user", "login"));
	}

}
