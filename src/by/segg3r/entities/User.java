package by.segg3r.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import by.segg3r.dao.impl.db.UserDAOImplDB;

/**
 * The Class User.
 */
@Entity
@Table(name = UserDAOImplDB.TABLE_NAME)
public class User extends AbstractDBEntity implements Serializable {

	private static final long serialVersionUID = 3013255069027924406L;

	@Column(name = UserDAOImplDB.LOGIN_FIELD)
	private String login;

	@Column(name = UserDAOImplDB.PASSWORD_FIELD)
	private String password;

	/**
	 * Instantiates a new user.
	 */
	public User() {
		super();
	}

	/**
	 * Instantiates a new user.
	 * 
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 */
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	/**
	 * Instantiates a new user.
	 * 
	 * @param id
	 *            the id
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 */
	public User(int id, String login, String password) {
		super(id);
		this.login = login;
		this.password = password;
	}

	/**
	 * Gets the login.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 * 
	 * @param login
	 *            the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", getId()="
				+ getId() + "]";
	}

}
