package org.mql.java.models;

import java.util.List;
import java.util.Vector;



public class Invoice {
	private int num;
	private Customer customer;
	private List<Product> products;
	private double amount=1;
	
	public Invoice() {
		this.products = new Vector<>();
		this.amount = 0.0;
	}

	public Invoice(int num, Customer customer) {
		this();
		this.num = num;
		this.customer = customer;
		
	}
	public void calculateAmount(Product p) {
		this.amount=0.0;
		if(products != null) {
			
				this.amount +=p.getPrice();
			
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Invoice [num=" + num + ", customer=" + customer + ", products=" + products + ", amount=" + amount + "]";
	}
	
	

}
