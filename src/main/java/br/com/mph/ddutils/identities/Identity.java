package br.com.mph.ddutils.identities;

import java.io.Serializable;
import java.util.UUID;

import br.com.mph.dddutils.exceptions.DddUtilsException;

public class Identity implements Serializable{

	private static final long serialVersionUID = -857432151835992006L;
	
	private UUID id;

	public UUID getId() {
		return id;
	}
	
	public Identity(){
		id = UUID.randomUUID();
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
		
		if (!Identity.class.isAssignableFrom(obj.getClass()))
		{
			return false;
		}
		
		Identity other = (Identity) obj;
		
		return this.getId().equals(other.getId());
	}

	public static Identity newInstance(){
		try {
			return Identity.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {			
			e.printStackTrace();
			throw new DddUtilsException(e);
		}
	}

}
