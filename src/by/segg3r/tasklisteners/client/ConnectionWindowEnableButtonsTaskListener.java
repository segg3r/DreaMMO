package by.segg3r.tasklisteners.client;

import by.segg3r.net.task.AbstractTask;
import by.segg3r.tasklisteners.ITaskListener;
import by.segg3r.ui.ConnectionWindow;

public class ConnectionWindowEnableButtonsTaskListener implements ITaskListener {

	private ConnectionWindow connectionWindow;

	public ConnectionWindowEnableButtonsTaskListener(
			ConnectionWindow connectionWindow) {
		super();
		this.connectionWindow = connectionWindow;
	}

	public void triggerListener(AbstractTask task) {
		connectionWindow.enableButtons();
	}

}
