package com.expensetracker;

import java.time.LocalDate;

public class Transaction {
	private String type; //either an "expense" or "income" type of transaction
	private double amount; 
	private String category;
	private LocalDate date;

	public Transaction(String type, double amount, String category, LocalDate date) {
		this.type = type; 
		this.amount = amount;
		this.category = category;
		this.date = date;
	}
	
	public String getTypeOfTransaction() { 
		return this.type;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public String toString() {
		return this.type + ": $" + this.amount + " | Category: " + this.category + " | Date: " + this.date.toString();
	}
}
