package by.segg3r.tasks.server;

import by.segg3r.ServerApplicationContext;
import by.segg3r.net.task.exceptions.TaskExecutionException;
import by.segg3r.tasks.AbstractExceptionTask;

/**
 * The Class ServerExceptionTask.
 */
public class ServerExceptionTask extends AbstractExceptionTask {

	private static final long serialVersionUID = -2369565242013183395L;

	/**
	 * Instantiates a new server exception task.
	 */
	public ServerExceptionTask() {
		super();
	}

	/**
	 * Instantiates a new server exception task.
	 * 
	 * @param exception
	 *            the exception
	 */
	public ServerExceptionTask(TaskExecutionException exception) {
		super(exception);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.segg3r.net.task.AbstractTask#execute()
	 */
	@Override
	public void execute() throws TaskExecutionException {
		ServerApplicationContext.getLog().printException(
				new Exception("Server error : " + getException().getMessage()));
	}

}
