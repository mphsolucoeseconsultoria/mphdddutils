package br.com.mph.dddutils.util;

import java.util.Comparator;
import java.util.List;

import br.com.mph.dddutils.BusinessObject;
import br.com.mph.mphutils.reflection.ReflectionUtils;

public class ContentComparator <T extends BusinessObject> implements Comparator<T> {

	@Override
	public int compare(BusinessObject o1AttributeValue2, BusinessObject o2AttributeValue2) {
		
		int ret = 0;
		
		if (o1AttributeValue2 == null && o2AttributeValue2 == null)
		{
			return ret;
		}
		
		if (o1AttributeValue2 == null && o2AttributeValue2 != null)
		{
			ret = -1;
		}
		
		if (o1AttributeValue2 != null && o2AttributeValue2 == null)
		{
			ret = 1;
		}
		
		if (!o1AttributeValue2.getClass().isAssignableFrom(o2AttributeValue2.getClass()))
		{
			throw new IllegalArgumentException("Cannot compare objects from different classes.");
		}
		
		List<String> attributes = ReflectionUtils.listClassAttributes(o1AttributeValue2.getClass());
		for (String attribute: attributes)
		{
			Object o1AttributeValue = ReflectionUtils.getFieldValue(o1AttributeValue2,attribute);
			Object o2AttributeValue = ReflectionUtils.getFieldValue(o2AttributeValue2,attribute);
			
			if (o1AttributeValue == null && o2AttributeValue == null)
			{
				//attributes with same value
				continue;
			} 
			
			if (ret == 0)
			{
				if (o1AttributeValue == null && o2AttributeValue != null)
				{
					ret = 1;									
				}
				
				if (o1AttributeValue != null && o2AttributeValue == null)
				{					
					ret = -1;
				}

				if (BusinessObject.class.isAssignableFrom(o1AttributeValue.getClass())){
					ret = compare((BusinessObject) o1AttributeValue, (BusinessObject) o2AttributeValue);	
				}				
			}									
		}		
		return ret;
	}

}
