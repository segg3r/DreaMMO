package by.segg3r.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import by.segg3r.dao.impl.db.GameCharacterDAOImplDB;

/**
 * The Class Character.
 */
@Entity
@Table(name = GameCharacterDAOImplDB.TABLE_NAME)
public class GameCharacter extends AbstractDBEntity implements Serializable {

	private static final long serialVersionUID = -7678957269362076861L;

	@OneToOne
	private User user;
	@Column(name = GameCharacterDAOImplDB.X_FIELD)
	private int x;
	@Column(name = GameCharacterDAOImplDB.Y_FIELD)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GameCharacter [user=" + user + ", x=" + x + ", y=" + y
				+ ", getId()=" + getId() + "]";
	}

}
