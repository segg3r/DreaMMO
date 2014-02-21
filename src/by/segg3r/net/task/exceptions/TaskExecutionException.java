package by.segg3r.net.task.exceptions;

/**
 * The Class TaskExecutionException.
 */
public class TaskExecutionException extends Exception {

	private static final long serialVersionUID = -3135987834284684875L;

	/**
	 * Instantiates a new task execution exception.
	 */
	public TaskExecutionException() {
	}

	/**
	 * Instantiates a new task execution exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public TaskExecutionException(String arg0) {
		super(arg0);

	}

	/**
	 * Instantiates a new task execution exception.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	public TaskExecutionException(Throwable arg0) {
		super(arg0);

	}

	/**
	 * Instantiates a new task execution exception.
	 * 
	 * @param arg0
	 *            the arg0
	 * @param arg1
	 *            the arg1
	 */
	public TaskExecutionException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	/**
	 * Instantiates a new task execution exception.
	 * 
	 * @param arg0
	 *            the arg0
	 * @param arg1
	 *            the arg1
	 * @param arg2
	 *            the arg2
	 * @param arg3
	 *            the arg3
	 */
	public TaskExecutionException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);

	}

}
