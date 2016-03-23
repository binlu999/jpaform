package com.jpa.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import relations.Deity;

import com.jpa.entity.Customer;
import com.jpa.entity.Employee;
import com.jpa.entity.Order;

public class JPATest {

	public static void main(String[] args) {
	       //Get the EntityManager Factory
	       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formjpa");
	       //Get the Entity Manager
	       EntityManager entityManager = entityManagerFactory.createEntityManager();
	       //Create the employee
	       Employee employee = new Employee();
	       employee.setName("Empl1");
	       employee.setSalary(1000000);
	       //Start the transaction
	       entityManager.getTransaction().begin();
	       //Save the employee
	      // entityManager.persist(employee);
	       /*
	       
	       Deity d=new Deity("parent", Deity.Gender.FEMALE);
	       Deity c1=new Deity("child1", Deity.Gender.FEMALE);
	       Deity c2=new Deity("child1", Deity.Gender.FEMALE);
	       
	       HashSet<Deity> children=new HashSet<Deity>();
	       children.add(c1);
	       children.add(c2);
	       
	       d.setChildren(children);
	       entityManager.persist(d);
	       */
	       
	       Customer c=new Customer();
	       c.setFirstName("c15");
	       c.setLastName("c25");
	        
	       
	       Order o=new Order();
	       o.setName("new");
	       o.setCustomer(c);
	       
	       List<Order> list=new ArrayList<Order>();
	       list.add(o);
	       c.setOrders(list);
	       
	       //entityManager.persist(c);
	       //entityManager.persist(o);
	       
	       //Commit the transaction
	       entityManager.getTransaction().commit();
	       //Order oo=entityManager.find(Order.class, 601);
	       Customer cc=entityManager.find(Customer.class, 4551);
	       cc=entityManager.merge(cc);
	       Collection orders = cc.getOrders();
	       entityManager.close();
	       System.out.println("Program completed...");
	   }
}
