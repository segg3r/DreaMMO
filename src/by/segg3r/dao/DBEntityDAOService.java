package by.segg3r.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import by.segg3r.dao.exceptions.EntityDAOServiceException;
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

		Transaction transaction = session.beginTransaction();

		session.save(entity);
		session.close();

		transaction.commit();
		return entity;
	}

	/**
	 * Gets the entity by criteria.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param entityClass
	 *            the entity class
	 * @param criterions
	 *            the criterions
	 * @return the entity by criteria
	 */
	@SuppressWarnings("unchecked")
	public static <T extends AbstractDBEntity> List<T> getEntitiesByCriteria(
			Class<T> entityClass, Criterion... criterions) {
		Session session = DB.getSession();
		Criteria criteria = session.createCriteria(entityClass);
		addCriterionsToCriteria(criteria, Arrays.asList(criterions));
		List<T> result = criteria.list();
		session.close();
		return result;
	}

	/**
	 * Gets the entities.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param entityClass
	 *            the entity class
	 * @return the entities
	 */
	public static <T extends AbstractDBEntity> List<T> getEntities(
			Class<T> entityClass) {
		return getEntitiesByCriteria(entityClass);
	}

	/**
	 * Adds the criterions to criteria.
	 * 
	 * @param criteria
	 *            the criteria
	 * @param criterions
	 *            the criterions
	 */
	private static void addCriterionsToCriteria(Criteria criteria,
			List<Criterion> criterions) {
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
	}

	/**
	 * Gets the entity.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param entityClass
	 *            the entity class
	 * @return the entity
	 */
	public static <T extends AbstractDBEntity> T getEntity(Class<T> entityClass)
			throws EntityDAOServiceException {
		try {
			return getEntities(entityClass).get(0);
		} catch (IndexOutOfBoundsException e) {
			throw new EntityDAOServiceException(
					"Error getting entity from database", e);
		}
	}

	/**
	 * Gets the entity by criteria.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param entityClass
	 *            the entity class
	 * @param criterions
	 *            the criterions
	 * @return the entity by criteria
	 */
	public static <T extends AbstractDBEntity> T getEntityByCriteria(
			Class<T> entityClass, Criterion... criterions)
			throws EntityDAOServiceException {
		try {
			return getEntitiesByCriteria(entityClass, criterions).get(0);
		} catch (IndexOutOfBoundsException e) {
			throw new EntityDAOServiceException(
					"Error getting entity from database", e);
		}
	}

}
