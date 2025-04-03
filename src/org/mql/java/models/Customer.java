package org.mql.java.models;

import org.mql.java.annotations.Bean;
import org.mql.java.annotations.IntValue;
import org.mql.java.annotations.StringValue;


@Bean(4)
public class Customer {
	@IntValue(min=1,max=100)
	private int id;
	
	@StringValue(size = 10)
	private String name;
	
	@StringValue(size = 10)
	private String tel;
	
	@StringValue(size = 10)
	private String email;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, String tel, String email) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.email = email;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
