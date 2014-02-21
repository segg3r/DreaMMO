package by.segg3r.dao;

import org.hibernate.Session;

import by.segg3r.dao.impl.db.DB;
import by.segg3r.entities.AbstractDBEntity;

/**
 * The Class DBEntityDAOService.
 */
public class DBEntityDAOService {

	/**
	 * Save entity.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param entity
	 *            the entity
	 * @return the t
	 */
	public static <T extends AbstractDBEntity> T saveEntity(T entity) {
		Session session = DB.getSession();

		session.save(entity);
		session.close();

		return entity;
	}

}
