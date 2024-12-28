package com.expensetracker;

import java.time.LocalDate;

public class Main {
	
	public static void main(String args[]) {
		ExpenseTracker tracker = new ExpenseTracker();
		
		tracker.addTransaction(new Transaction("income", 2000, "Salary", LocalDate.now()));
		tracker.addTransaction(new Transaction("expense", 150, "Groceries", LocalDate.now()));
		tracker.addTransaction(new Transaction("expense", 439.87, "Bills", LocalDate.now()));
		
		tracker.printCategories();
		tracker.printSummary();
	}

}
