package by.segg3r.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The Class AbstractDBEntity.
 */
@MappedSuperclass
public abstract class AbstractDBEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	/**
	 * Instantiates a new abstract db entity.
	 */
	public AbstractDBEntity() {
		super();
	}

	/**
	 * Instantiates a new abstract db entity.
	 * 
	 * @param id
	 *            the id
	 */
	public AbstractDBEntity(int id) {
		super();
		this.id = id;
	}

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