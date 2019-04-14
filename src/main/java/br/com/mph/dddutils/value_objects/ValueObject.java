package br.com.mph.dddutils.value_objects;

import java.util.List;

import br.com.mph.dddutils.BusinessObject;
import br.com.mph.dddutils.util.ContentComparator;
import br.com.mph.mphutils.reflection.ReflectionUtils;

public class ValueObject extends BusinessObject {

	@Override
	public int hashCode() {
		int hashCode = 1;
		List<String> attributes = ReflectionUtils.listClassAttributes(getClass());
		for (String attribute: attributes)
		{
			hashCode = hashCode * ReflectionUtils.getAttributeValue(this, attribute).hashCode();
		}
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {		
		
		if (obj == null)
		{
			return false;
		}
		
		if (!BusinessObject.class.isAssignableFrom(obj.getClass()))
		{
			return false;
		}
		
		return new ContentComparator<BusinessObject>()
				.compare(this, (BusinessObject) obj) == 0;
	}

	
	
}
