package by.segg3r.log.impl;

import by.segg3r.log.ILog;

/**
 * The Class ConsoleLog.
 */
public class ConsoleLog implements ILog {

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.segg3r.log.ILog#printMessage(java.lang.String)
	 */
	public void printMessage(String message) {
		System.out.println(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.segg3r.log.ILog#printException(java.lang.Exception)
	 */
	public void printException(Exception e) {
		System.err.println(e.getMessage());
	}

}
