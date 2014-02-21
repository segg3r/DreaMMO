package by.segg3r.net.task.impl;

import by.segg3r.net.task.AbstractTask;

public class StreamInitializationTask extends AbstractTask {

	private static final long serialVersionUID = -6791446819265535892L;

	@Override
	public void execute() {
		System.out.println("Socket stream initialized");
	}

}
