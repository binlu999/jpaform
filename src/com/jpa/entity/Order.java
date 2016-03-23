package com.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ORDERS") 
public class Order {
       
       @Id //signifies the primary key
       @Column(name = "ORDER_ID", nullable = false)
       @GeneratedValue(strategy = GenerationType.AUTO)
       private long orderId;
       
       @Column(name="name")
       private String name;
       
       public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*
	@Column(name = "CUST_ID")
       private long custId;
  */     
       //@ManyToOne(targetEntity=Customer.class, optional=true )
       //@ManyToOne(fetch=FetchType.LAZY )
       //@JoinColumn(name="CUST_ID",referencedColumnName="CUST_ID", nullable = false, updatable = true, insertable = true)
       @ManyToOne(cascade = {CascadeType.ALL})
       @JoinColumn(name="CUST_ID")
       private Customer customer;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

       
}
