package br.com.mph.dddutils.entities.jpa;

import br.com.mph.dddutils.BusinessObject;
import br.com.mph.dddutils.entities.Entity;
import br.com.mph.ddutils.identities.Identity;

@SuppressWarnings("rawtypes")
public abstract class PersistentEntity<T extends Identity> extends BusinessObject implements Entity<T> {

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!PersistentEntity.class.isAssignableFrom(obj.getClass())) {
			return false;
		}

		@SuppressWarnings("rawtypes")
		PersistentEntity other = (PersistentEntity) obj;

		return this.getId().equals(other.getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}

	private long dbId;

	long getDbId() {
		return dbId;
	}

	public void setDbId(long dbId) {
		this.dbId = dbId;
	}

}

