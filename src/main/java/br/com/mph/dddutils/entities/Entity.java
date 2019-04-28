package br.com.mph.dddutils.entities;

import br.com.mph.dddutils.BusinessObject;
import br.com.mph.ddutils.identities.Identity;
import br.com.mph.mphutils.exceptions.MphUtilsRuntimeException;

public abstract class Entity<T extends Identity> extends BusinessObject{

	private T id;

	@SuppressWarnings("unchecked")
	protected Entity(Class<T> clazz) {
		try {
			this.id = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new MphUtilsRuntimeException(e);
		}
	}

	public T getId() {
		if (id == null) {
			throw new IllegalStateException(
					"Entity's constructor must be called by implementation class constructor through super(Class<T> clazz).");
		}
		return id;
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
		{
			return false;
		}

		if (!Entity.class.isAssignableFrom(obj.getClass()))
		{
			return false;
		}

		@SuppressWarnings("rawtypes")
		Entity other = (Entity) obj;

		return this.getId().equals(other.getId());
	}

}
