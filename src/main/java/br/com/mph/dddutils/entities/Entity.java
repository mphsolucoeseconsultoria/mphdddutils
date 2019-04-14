package br.com.mph.dddutils.entities;

import br.com.mph.dddutils.BusinessObject;
import br.com.mph.ddutils.identities.Identity;

public abstract class Entity<T extends Identity> extends BusinessObject{
	
	private T id;

	@SuppressWarnings("unchecked")
	protected Entity() {
		this.id = (T) T.newInstance();
	}

	public T getId() {
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
