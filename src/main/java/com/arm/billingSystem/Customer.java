package com.arm.billingSystem;

public class Customer {
	private String name;
	private Integer id;
	private int balance;
	
	
	public Customer() {
		super();
	}
	
	public Customer(String name, Integer id, int balance) {
		super();
		this.name = name;
		this.id = id;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", balance=" + balance + "]";
	}
}
