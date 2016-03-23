package com.jpa.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name = "CUSTOMER")
public class Customer {
	@Id
	// signifies the primary key
	@Column(name = "CUST_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long custId;

	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false, length = 50)
	private String lastName;

	@Column(name = "STREET")
	private String street;

	//@OneToMany(mappedBy = "customer", targetEntity = Order.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	//@OneToMany(targetEntity = Order.class, fetch = FetchType.EAGER)
	//@OneToMany(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "customer", fetch = FetchType.EAGER)
	//@OneToMany
	//@OneToMany( cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@OneToMany( cascade={CascadeType.ALL,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
	
	private Collection<Order> orders=new ArrayList<Order>();

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Collection getOrders() {
		return orders;
	}

	public void setOrders(Collection orders) {
		this.orders = orders;
	}

}
