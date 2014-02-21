import by.segg3r.ServerApplicationContext;
import by.segg3r.log.impl.ConsoleLog;

public class ServerRunner {

	private static final int PORT = 14804;

	public static void main(String[] args) {

		ServerApplicationContext.initializeLog(new ConsoleLog());
		ServerApplicationContext.initializeServer(PORT);

	}

}
