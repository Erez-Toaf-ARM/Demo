package com.arm.billingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class BillingSystem {
	
	int id;
	String name;
	HashMap<Integer,Customer> customerMap = new HashMap<Integer, Customer>();

	
	public BillingSystem() {
		
	}
	
	public BillingSystem(int id, String name) {
		Customer customer1 = new Customer("aaa", 1, 100);
		Customer customer2 = new Customer("bbb", 2, 80);
		customerMap.put(1, customer1);
		customerMap.put(2, customer2);
		this.id = id;
		this.name = name;
	}
	
	
	public BillingSystem(int id, String name, HashMap<Integer,Customer> customerMap) {
		this.id = id;
		this.name = name;
		this.customerMap = customerMap;
	}

	public HashMap<Integer, Customer> getCustomerMap() {
		return customerMap;
	}

	public void setCustomerMap(HashMap<Integer, Customer> customerMap) {
		this.customerMap = customerMap;
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

	public Customer getCustomer(Integer id) {
		return customerMap.get(id);
	}
	
	public List<Customer> getAllCustomers() {
		List<Customer> customersList = new ArrayList<Customer>(); 
		for (Integer id : customerMap.keySet()) 
			customersList.add(customerMap.get(id));
		 
		return customersList;
	}
	
	public int updateCustomer(Customer customer) {
		if (isCustomerExist(customer.getId())) {
			customerMap.put(customer.getId(), customer);
			return 0;
		}
		
		return -1;
	}	
	
	public int addCustomer(Customer customer) {
		if (!isCustomerExist(customer.getId())) {
			customerMap.put(customer.getId(), customer);
			return 0;
		}
		
		return -1;
	}
	
	public int deleteCustomer(Integer id) {
		if (isCustomerExist(id)) {
			customerMap.remove(id);
			return 0;
		}
		
		return -1;
	}
	
	private boolean isCustomerExist(Integer id) {
		Customer customer = customerMap.get(id);
		if (customer != null)
			return true;
		else 
			return false;
	}

	@Override
	public String toString() {
		return "BillingSystem [customerMap=" + customerMap + "]";
	}
}

