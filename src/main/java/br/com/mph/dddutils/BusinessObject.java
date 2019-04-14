package br.com.mph.dddutils;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import br.com.mph.flunt4j.notifications.Notifiable;
import br.com.mph.flunt4j.notifications.Notification;
import br.com.mph.flunt4j.validations.contracts.Validatable;
import br.com.mph.mphutils.collections.CollectionFactory;
import br.com.mph.mphutils.reflection.ReflectionUtils;

public abstract class BusinessObject extends Notifiable implements Validatable {

	public Set<Notification> allNotifications(String alias){
		Set<Notification> allNotifications = CollectionFactory.newSet(Notification.class);
		allNotifications.addAll(getNotifications());
		Set<String> notifiableAttributes = ReflectionUtils.listClassTypeAttributes(BusinessObject.class, this);
		for (String attribute: notifiableAttributes){
			BusinessObject notifiableAttribute = (BusinessObject) ReflectionUtils.getAttributeValue(this, attribute);
			Set<Notification> notifications = notifiableAttribute.allNotifications(alias);
			for (Notification notification: notifications){
				String strAlias = (alias != null && !alias.equals(StringUtils.EMPTY)) ?
						alias+"."+attribute+"." : attribute+".";
				notification.setAlias(strAlias);
				allNotifications.add(notification);
			}
		}
		return allNotifications;
	}

	@Override
	public void validate() {
		Set<String> validatableAttributes = ReflectionUtils.listClassTypeAttributes(Validatable.class, this);
		for(String attributeName: validatableAttributes){
			Validatable validatableAttribute = (Validatable) ReflectionUtils.getAttributeValue(this, attributeName);
			validatableAttribute.validate();
		}
	}
	
	
}
