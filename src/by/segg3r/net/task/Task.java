package by.segg3r.net.task;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * The Class Task.
 */
public abstract class Task {

	private int id;

	/**
	 * Instantiates a new abstract task.
	 * 
	 * @param id
	 *            the id
	 */
	public Task(int id) {
		super();
		this.id = id;
	}

	/**
	 * Execute.
	 */
	public abstract void execute();

	/**
	 * Read data from stream.
	 * 
	 * @param dataInputStream
	 *            the data input stream
	 */
	public abstract void readDataFromStream(DataInputStream dataInputStream);

	/**
	 * Write data to stream.
	 * 
	 * @param dataOutputStream
	 *            the data output stream
	 */
	public abstract void writeDataToStream(DataOutputStream dataOutputStream);

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
