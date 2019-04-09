package br.com.mph.dddutils.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BusinessObjectTest {

	private Order order;

	@Before
	public void setUp() throws Exception {
		Customer customer = new Customer("MILTON", "O");
		order = new Order(null,customer);
	}

	@Test
	public final void testAllNotifications() {
		order.validate();
		assertTrue(order.allNotifications("").size() == 2);
	}

}
