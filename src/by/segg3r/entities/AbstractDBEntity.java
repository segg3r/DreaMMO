package by.segg3r.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The Class AbstractDBEntity.
 */
@MappedSuperclass
public abstract class AbstractDBEntity implements Serializable {

	private static final long serialVersionUID = 7038765984750242361L;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AbstractDBEntity)) {
			return false;
		}
		AbstractDBEntity entity = (AbstractDBEntity) obj;
		return id == entity.id;
	}

}
