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
/*
 * package org.mql.java.services;

import java.util.Arrays;

import org.mql.java.models.Customer;
import org.mql.java.models.Invoice;
import org.mql.java.models.Product;

public class DefaultApplicationContext extends AbstractApplicationContext{
	@Override
	public void load() {
		Product product1 = new Product(100, "laptop", 2000);
		Product product2 = new Product(101, "monitor", 1000);
		Product product3 = new Product(102, "mouse", 200);
		addBean("Product1", product1);
		addBean("Product2", product2);
		addBean("Product3", product3);
		
		Customer customer1 = new Customer(110, "customer1", "06666666", "customer1@gmail.com");
		Customer customer2 = new Customer(111, "customer2", "06666666", "customer2@gmail.com");
		Customer customer3 = new Customer(112, "customer3", "06666666", "customer3@gmail.com");
		addBean("Customer1", customer1);
		addBean("Customer2", customer2);
		addBean("Customer3", customer3);
		
		Invoice invoice1 = new Invoice(120, customer1, Arrays.asList(product1, product2));
		Invoice invoice2 = new Invoice(121, customer2, Arrays.asList(product1, product3));
		Invoice invoice3 = new Invoice(122, customer3, Arrays.asList(product2, product3));
		addBean("Invoice1", invoice1);
		addBean("Invoice2", invoice2);
		addBean("Invoice3", invoice3);
		
		=====================
		Invoice invoice1 = new Invoice(120, customer1, new Vector<>(List.of(product1, product2)));
		Invoice invoice2 = new Invoice(121, customer2, new Vector<>(List.of(product1, product3)));
		Invoice invoice3 = new Invoice(122, customer3, new Vector<>(List.of(product2, product3)));

		
	}

}




package org.mql.java.services;

import java.util.Vector;

import org.mql.java.models.Customer;
import org.mql.java.models.Invoice;
import org.mql.java.models.Product;

public class DefaultApplicationContext extends AbstractApplicationContext {
	@Override
	public void load() {
		// Produits
		Product product1 = new Product(100, "laptop", 2000);
		Product product2 = new Product(101, "monitor", 1000);
		Product product3 = new Product(102, "mouse", 200);
		addBean("Product1", product1);
		addBean("Product2", product2);
		addBean("Product3", product3);

		// Clients
		Customer customer1 = new Customer(110, "customer1", "06666666", "customer1@gmail.com");
		Customer customer2 = new Customer(111, "customer2", "06666666", "customer2@gmail.com");
		Customer customer3 = new Customer(112, "customer3", "06666666", "customer3@gmail.com");
		addBean("Customer1", customer1);
		addBean("Customer2", customer2);
		addBean("Customer3", customer3);

		// Invoices avec Vectors classiques
		Vector<Product> produits1 = new Vector<>();
		produits1.add(product1);
		produits1.add(product2);
		Invoice invoice1 = new Invoice(120, customer1, produits1);

		Vector<Product> produits2 = new Vector<>();
		produits2.add(product1);
		produits2.add(product3);
		Invoice invoice2 = new Invoice(121, customer2, produits2);

		Vector<Product> produits3 = new Vector<>();
		produits3.add(product2);
		produits3.add(product3);
		Invoice invoice3 = new Invoice(122, customer3, produits3);

		addBean("Invoice1", invoice1);
		addBean("Invoice2", invoice2);
		addBean("Invoice3", invoice3);
	}
}
*/
  