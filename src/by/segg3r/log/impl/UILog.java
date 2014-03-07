package by.segg3r.log.impl;

import javax.swing.JOptionPane;

import by.segg3r.log.ILog;

public class UILog implements ILog {

	public void printMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Message from server",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void printException(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage(),
				"Alert message from server", JOptionPane.ERROR_MESSAGE);
	}

}
