package br.com.mph.dddutils.entities.jpa;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.mph.dddutils.entities.Entity;
import br.com.mph.ddutils.identities.Identity;

@SuppressWarnings("rawtypes")
public abstract class PersistentEntity<T extends Identity> extends Entity implements Serializable {
	
	PersistentEntity() {
		super();
	}

	protected PersistentEntity(Class<T> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 4130447696994578239L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dbId;

	public int getDbId() {
		return dbId;
	}

}
