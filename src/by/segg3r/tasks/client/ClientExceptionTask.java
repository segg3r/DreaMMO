package by.segg3r.tasks.client;

import by.segg3r.ClientApplicationContext;
import by.segg3r.net.task.exceptions.TaskExecutionException;
import by.segg3r.tasks.AbstractExceptionTask;

/**
 * The Class ServerExceptionTask.
 */
public class ClientExceptionTask extends AbstractExceptionTask {

	private static final long serialVersionUID = -2369565242013183395L;

	/**
	 * Instantiates a new client exception task.
	 */
	public ClientExceptionTask() {
		super();
	}

	/**
	 * Instantiates a new server exception task.
	 * 
	 * @param exception
	 *            the exception
	 */
	public ClientExceptionTask(TaskExecutionException exception) {
		super(exception);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.segg3r.net.task.AbstractTask#execute()
	 */
	@Override
	public void execute() throws TaskExecutionException {
		ClientApplicationContext.getLog().printException(
				new Exception("Server error : " + getException().getMessage()));
	}

}
