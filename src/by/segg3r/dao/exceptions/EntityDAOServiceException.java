/*
 * 
 */
package by.segg3r.dao.exceptions;

public class EntityDAOServiceException extends Exception {

	private static final long serialVersionUID = 7725517694707562956L;

	public EntityDAOServiceException(Throwable throwable) {
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
	public EntityDAOServiceException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * Instantiates a new DAO exception.
	 * 
	 * @param message
	 *            the message
	 */
	public EntityDAOServiceException(String message) {
		super(message);
	}

}
