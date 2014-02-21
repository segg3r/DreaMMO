/*
 * 
 */
package by.segg3r.dao.exceptions;

public class DAOException extends Exception {

	private static final long serialVersionUID = -4531892728225554400L;

	public DAOException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * Instantiates a new DAO exception.
	 * 
	 * @param message
	 *            the message
	 * @param throwable
	 *            the throwable
	 */
	public DAOException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * Instantiates a new DAO exception.
	 * 
	 * @param message
	 *            the message
	 */
	public DAOException(String message) {
		super(message);
	}

}
