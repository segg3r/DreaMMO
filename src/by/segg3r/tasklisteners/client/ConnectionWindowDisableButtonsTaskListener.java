package by.segg3r.tasklisteners.client;

import by.segg3r.net.task.AbstractTask;
import by.segg3r.tasklisteners.ITaskListener;
import by.segg3r.ui.ConnectionWindow;

public class ConnectionWindowDisableButtonsTaskListener implements
		ITaskListener {

	private ConnectionWindow connectionWindow;

	public ConnectionWindowDisableButtonsTaskListener(
			ConnectionWindow connectionWindow) {
		super();
		this.connectionWindow = connectionWindow;
	}

	public void triggerListener(AbstractTask task) {
		connectionWindow.disableButtons();
	}

}
