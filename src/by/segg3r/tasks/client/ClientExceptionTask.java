package by.segg3r.tasks.client;

import by.segg3r.net.task.AbstractTask;
import by.segg3r.net.task.exceptions.TaskExecutionException;

/**
 * The Class ServerExceptionTask.
 */
public class ClientExceptionTask extends AbstractTask {

	private static final long serialVersionUID = -2369565242013183395L;

	private TaskExecutionException exception;

	/**
	 * Instantiates a new server exception task.
	 * 
	 * @param exception
	 *            the exception
	 */
	public ClientExceptionTask(TaskExecutionException exception) {
		super();
		this.exception = exception;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.segg3r.net.task.AbstractTask#execute()
	 */
	@Override
	public void execute() throws TaskExecutionException {
		System.err.println("Server error : " + exception.getMessage());
	}

	/**
	 * Gets the exception.
	 * 
	 * @return the exception
	 */
	public TaskExecutionException getException() {
		return exception;
	}

	/**
	 * Sets the exception.
	 * 
	 * @param exception
	 *            the new exception
	 */
	public void setException(TaskExecutionException exception) {
		this.exception = exception;
	}

}
