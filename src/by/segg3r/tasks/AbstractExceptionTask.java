package by.segg3r.tasks;

import by.segg3r.net.task.AbstractTask;
import by.segg3r.net.task.exceptions.TaskExecutionException;

public abstract class AbstractExceptionTask extends AbstractTask {

	private static final long serialVersionUID = 7209515809200678213L;

	private TaskExecutionException exception;

	/**
	 * Instantiates a new abstract exception task.
	 */
	public AbstractExceptionTask() {
		super();
	}

	/**
	 * Instantiates a new server exception task.
	 * 
	 * @param exception
	 *            the exception
	 */
	public AbstractExceptionTask(TaskExecutionException exception) {
		super();
		this.exception = exception;
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
