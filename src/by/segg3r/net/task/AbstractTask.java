package by.segg3r.net.task;

import java.io.Serializable;

/**
 * The Class Task.
 */
public abstract class AbstractTask implements Serializable {

	private static final long serialVersionUID = -8283010802522560930L;

	/**
	 * Instantiates a new task.
	 */
	public AbstractTask() {
		super();
	}

	/**
	 * Execute.
	 */
	public abstract void execute();

}
