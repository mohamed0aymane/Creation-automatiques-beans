package org.mql.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mql.java.models.Customer;
import org.mql.java.models.Invoice;
import org.mql.java.models.Product;
import org.mql.java.services.DefaultApplicationContext;

class DefaultApplicationContextTest {
	private DefaultApplicationContext context;
	
	@BeforeEach
	void setup() {
		context=new DefaultApplicationContext();
		context.load();
	}

//	@Test
//	void context() {
//		assertAll(
//				() -> assertEquals(context.getBeans(Customer.class).size(),3),
//				() -> {
//					context.addBean("customer 4", new Customer(1, "amine", "01020202", "amine@gmail.com"));
//					assertEquals(context.getBeans(Customer.class).size(), 4);
//				},
//				() -> {
//					assertNull(context.getBean("customer 4", Customer.class));
//				}
//				);
//		
//	}
	@Test
	void addCustomer() {
		Customer customer4=new Customer(1, "aymane", "0705797152", "aymane@gmail.com");
		context.addBean("customer 4", customer4);
		assertEquals(context.getBeans(Customer.class).size(), 4);
	}
	@Test
	void getCustomer() {
		Customer customer4=new Customer(1, "aymane", "0705797152", "aymane@gmail.com");
		context.addBean("customer 4", customer4);
		assertNotNull(context.getBean("customer 4",Customer.class));
	}
	@Test
	void addProduct() {
		Product product4=new Product(1, "laptop", 50000);		
		context.addBean("product 4", product4);
		assertEquals(4,context.getBeans(Product.class).size());
	}
	@Test
	void addInvoice() {
		Customer customer=new Customer(1, "aymane", "0705797152", "aymane@gmail.com");
		Invoice invoice4 = new Invoice(1, customer)	;	
		context.addBean("invoice 4", invoice4);
		assertNotEquals(5,context.getBeans(Invoice.class).size());
	}
	


}
