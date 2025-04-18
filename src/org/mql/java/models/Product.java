package org.mql.java.models;

import org.mql.java.annotations.Bean;
import org.mql.java.annotations.DoubleValue;
import org.mql.java.annotations.IntValue;
import org.mql.java.annotations.StringValue;

@Bean(5)
public class Product {
	@IntValue(min=1,max=100)
	private int id;
	
	@StringValue(size = 10)
	private String name;
	@DoubleValue(min=10.0, max = 1000.0)
	private double price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
