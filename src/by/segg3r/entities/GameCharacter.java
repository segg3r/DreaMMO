package by.segg3r.entities;

import java.io.Serializable;

/**
 * The Class Character.
 */
public class GameCharacter extends AbstractDBEntity implements Serializable {

	private static final long serialVersionUID = -493620783708915423L;

	private User user;
	private int x;
	private int y;

	/**
	 * Instantiates a new character.
	 */
	public GameCharacter() {
		super();
	}

	/**
	 * Instantiates a new character.
	 * 
	 * @param user
	 *            the user
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public GameCharacter(User user, int x, int y) {
		super();
		this.user = user;
		this.x = x;
		this.y = y;
	}

	/**
	 * Instantiates a new character.
	 * 
	 * @param id
	 *            the id
	 * @param user
	 *            the user
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public GameCharacter(int id, User user, int x, int y) {
		super(id);
		this.user = user;
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the x.
	 * 
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x.
	 * 
	 * @param x
	 *            the new x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 * 
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y.
	 * 
	 * @param y
	 *            the new y
	 */
	public void setY(int y) {
		this.y = y;
	}

}
