package by.segg3r.net.task.impl.client;

import by.segg3r.dao.DAOFactory;
import by.segg3r.dao.IUserDAO;
import by.segg3r.entities.User;
import by.segg3r.net.task.AbstractTask;

public class RegistrationTask extends AbstractTask {

	private static final long serialVersionUID = 1441628265679512155L;

	private String login;
	private String password;

	public RegistrationTask(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	@Override
	public void execute() {
		IUserDAO userDAO = DAOFactory.getUserDAO();
		User user = userDAO.registerUser(login, password);

		System.out.println("Registered user id = " + user.getId());
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
