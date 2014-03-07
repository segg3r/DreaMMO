import by.segg3r.ServerApplicationContext;
import by.segg3r.log.impl.ConsoleLog;
import by.segg3r.net.Client;
import by.segg3r.tasks.ClientTaskEnvironment;
import by.segg3r.tasks.client.ClientExceptionTask;

public class ServerRunner {

	private static final int PORT = 14804;

	public static void main(String[] args) {

		ServerApplicationContext.initializeLog(new ConsoleLog());
		Client.setLog(ServerApplicationContext.getLog());
		ClientTaskEnvironment.setExceptionTask(new ClientExceptionTask());

		ServerApplicationContext.initializeServer(PORT);

	}
}
