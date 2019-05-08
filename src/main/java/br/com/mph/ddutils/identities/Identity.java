package br.com.mph.ddutils.identities;

import java.io.Serializable;
import java.util.UUID;

public abstract class Identity implements Serializable {

	private static final long serialVersionUID = -857432151835992006L;

	public abstract UUID getId();

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

		if (!Identity.class.isAssignableFrom(obj.getClass()))
		{
			return false;
		}

		Identity other = (Identity) obj;

		return this.getId().equals(other.getId());
	}



}
