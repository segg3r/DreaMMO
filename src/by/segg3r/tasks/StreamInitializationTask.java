package by.segg3r.tasks;

import by.segg3r.net.task.AbstractTask;

/**
 * The Class StreamInitializationTask.
 */
public class StreamInitializationTask extends AbstractTask {

	private static final long serialVersionUID = -6791446819265535892L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.segg3r.net.task.AbstractTask#execute()
	 */
	@Override
	public void execute() {
		System.out.println("Socket stream initialized");
	}

}
