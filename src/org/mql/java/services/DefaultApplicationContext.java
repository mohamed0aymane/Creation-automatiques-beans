package org.mql.java.services;

import org.mql.java.models.Customer;
import org.mql.java.models.Invoice;
import org.mql.java.models.Product;

public class DefaultApplicationContext  extends AbstractApplicationContext {

	@Override
	public void load() {
		Customer customer1=new Customer(1, "aymane", "0705797152", "aymane@gmail.com");
		Customer customer2=new Customer(1, "wissal", "0705797152", "wissal@gmail.com");
		Customer customer3=new Customer(1, "abdellah", "0705797152", "abdellah@gmail.com");
		addBean("customer 1", customer1);
		addBean("customer 2", customer2);
		addBean("customer 3", customer3);
		
		Product product1=new Product(1, "iphone", 5000);
		Product product2=new Product(2, "samsung", 8000);
		Product product3=new Product(3, "honor", 9000);
		
		addBean("product 1", product1);
		addBean("product 2", product2);
		addBean("product 3", product3);
		
		Invoice invoice1=new Invoice(1, customer1);
		Invoice invoice2=new Invoice(2, customer2);
		Invoice invoice3=new Invoice(3, customer3);
		
		addBean("invoice1", invoice1);
		addBean("invoice2", invoice2);
		addBean("invoice3", invoice3);
	}

}
