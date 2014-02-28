package by.segg3r.tasks;

import by.segg3r.net.Client;
import by.segg3r.net.task.AbstractTask;
import by.segg3r.net.task.exceptions.TaskExecutionException;

/**
 * The Class ClientTaskEnvironment.
 */
public class ClientTaskEnvironment {

	private static AbstractExceptionTask exceptionTask;

	public static void setExceptionTask(AbstractExceptionTask exceptionTask) {
		ClientTaskEnvironment.exceptionTask = exceptionTask;
	}

	private Client client;

	/**
	 * Instantiates a new client task environment.
	 * 
	 * @param client
	 *            the client
	 */
	public ClientTaskEnvironment(Client client) {
		super();
		this.client = client;
	}

	/**
	 * Execute task.
	 * 
	 * @param task
	 *            the task
	 */
	public void executeTask(AbstractTask task) {
		try {
			task.setClient(client);
			task.execute();
		} catch (TaskExecutionException e) {
			exceptionTask.setException(e);
			client.sendTask(exceptionTask);
		}
	}

}
