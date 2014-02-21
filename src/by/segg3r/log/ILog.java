package by.segg3r.log;

/**
 * The Interface ILog.
 */
public interface ILog {

	/**
	 * Prints the message.
	 * 
	 * @param message
	 *            the message
	 */
	void printMessage(String message);

	/**
	 * Prints the exception.
	 * 
	 * @param e
	 *            the e
	 */
	void printException(Exception e);

}
