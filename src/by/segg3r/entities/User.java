package by.segg3r.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class User.
 */
@Entity
@Table(name = "users")
public class User extends AbstractDBEntity {

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

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

}
