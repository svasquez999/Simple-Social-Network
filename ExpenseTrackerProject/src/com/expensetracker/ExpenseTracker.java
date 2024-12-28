package com.expensetracker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpenseTracker {
	private List<Transaction> transactions;
	
	public ExpenseTracker() {
		this.transactions = new ArrayList<>();
	}
	
	public void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}
	
	public double getTotalIncome() {
		double totalIncome = 0;
		
		for(Transaction transaction : this.transactions) {
			if(transaction.getTypeOfTransaction().equals("income") || transaction.getTypeOfTransaction().equals("Income")) 
				totalIncome += transaction.getAmount();
		}
		return totalIncome;
	}
	
	public double getTotalExpenses() {
		double totalExpenses = 0;
		for(Transaction transaction : this.transactions) {
			if(transaction.getTypeOfTransaction().equals("expense") || transaction.getTypeOfTransaction().equals("Expense")) 
				totalExpenses += transaction.getAmount();
		}
		return totalExpenses;
	}
	
	private Set<String> getCategories() {
		Set<String> categories = new HashSet<>();
		
		for(Transaction transaction : this.transactions) {
			categories.add(transaction.getCategory());
		}
		return categories;
	}
	
	public void printCategories() {
		Set<String> categories = getCategories();
		for(String category : categories) {
			System.out.println(category);
		}
	}
	
	public void printSummary() {
		System.out.println("Total Income: $" + getTotalIncome());
		System.out.println("Total Expenses: $" + getTotalExpenses());
		System.out.println("Balance: $" + (getTotalIncome() - getTotalExpenses()));
		
	}
}
