package by.segg3r.ui;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -1897448338640683831L;

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final String TITLE = "DreaMMO";

	public GameWindow() {
		super();

		this.setSize(WIDTH, HEIGHT);
		this.setTitle(TITLE);

		this.setVisible(true);
	}

}
