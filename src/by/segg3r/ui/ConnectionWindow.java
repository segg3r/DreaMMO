package by.segg3r.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import by.segg3r.ClientApplicationContext;
import by.segg3r.tasks.server.ServerAuthorizationTask;
import by.segg3r.tasks.server.ServerRegistrationTask;

/**
 * The Class ConnectionWindow.
 */
public class ConnectionWindow extends JFrame {

	private static final long serialVersionUID = 898918893818719016L;

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JButton btnLogin;
	private JButton btnRegistration;

	/**
	 * Create the frame.
	 */
	public ConnectionWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 309, 137);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setBounds(10, 11, 96, 14);
		contentPane.add(lblLogin);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(10, 36, 96, 14);
		contentPane.add(lblPassword);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(116, 11, 163, 20);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		textFieldPassword = new JPasswordField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(116, 33, 163, 20);
		contentPane.add(textFieldPassword);

		btnRegistration = new JButton("Registration");
		btnRegistration.addActionListener(getRegistrationActionListener());
		btnRegistration.setBounds(173, 65, 110, 23);
		contentPane.add(btnRegistration);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(getLoginActionListener());
		btnLogin.setBounds(74, 65, 89, 23);
		contentPane.add(btnLogin);
	}

	/**
	 * Gets the login action listener.
	 * 
	 * @return the login action listener
	 */
	private ActionListener getLoginActionListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = getLogin();
				String password = getPassword();
				ServerAuthorizationTask serverAuthorizationTask = new ServerAuthorizationTask(
						login, password);

				ClientApplicationContext.getClient().sendTask(
						serverAuthorizationTask);
			}
		};
	}

	/**
	 * Gets the registration action listener.
	 * 
	 * @return the registration action listener
	 */
	private ActionListener getRegistrationActionListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = getLogin();
				String password = getPassword();
				ServerRegistrationTask serverRegistrationTask = new ServerRegistrationTask(
						login, password);

				ClientApplicationContext.getClient().sendTask(
						serverRegistrationTask);
			}
		};
	}

	/**
	 * Gets the login.
	 * 
	 * @return the login
	 */
	private String getLogin() {
		return textFieldLogin.getText();
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	private String getPassword() {
		return textFieldPassword.getText();
	}

	/**
	 * Disable buttons.
	 */
	public void disableButtons() {
		btnLogin.setEnabled(false);
		btnRegistration.setEnabled(false);
	}

	/**
	 * Enable buttons.
	 */
	public void enableButtons() {
		btnLogin.setEnabled(true);
		btnRegistration.setEnabled(true);
	}
}
