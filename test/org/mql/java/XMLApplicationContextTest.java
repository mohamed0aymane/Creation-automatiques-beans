package org.mql.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mql.java.models.Product;
import org.mql.java.xml.XMLApplicationContext;

class XMLApplicationContextTest {
	private XMLApplicationContext context;
	
	@BeforeEach
	void setup() {
		context=new XMLApplicationContext();
		context.load();
	}

	@Test
	void testBeanLoading() {
		assertNotNull(context.getBean("p01", Product.class));
	}
	@Test
	public void testBeanInstance() {
	    Product product1 = (Product) context.getBean("p01", Product.class);
	    Product product2 = (Product) context.getBean("p02", Product.class);

	    assertEquals(101, product1.getId());
	    assertEquals(102, product2.getId());

	}
}
