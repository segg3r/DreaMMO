package by.segg3r.net.task;

/**
 * A factory for creating AbstractTask objects.
 */
public abstract class TaskFactory {

	/**
	 * Gets the class from factory.
	 * 
	 * @param id
	 *            the id
	 * @return the class from factory
	 */
	public static Task getClassFromFactory(int id) {
		TaskId taskId = TaskId.values()[id];

		return null;
	}

}
