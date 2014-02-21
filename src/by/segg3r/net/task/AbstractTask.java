package by.segg3r.net.task;

import java.io.Serializable;

import by.segg3r.net.task.exceptions.TaskExecutionException;

/**
 * The Class Task.
 */
public abstract class AbstractTask implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new task.
	 */
	public AbstractTask() {
		super();
	}

	/**
	 * Execute.
	 * 
	 * @throws TaskExecutionException
	 *             the task execution exception
	 */
	public abstract void execute() throws TaskExecutionException;

	/**
	 * Gets the succeed task.
	 * 
	 * @return the succeed task
	 */
	public AbstractTask getSucceedTask() {
		return null;
	}

}
