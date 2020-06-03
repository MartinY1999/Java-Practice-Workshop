package com.savings;

public class Main {

    public static void main(String[] args) {
    	System.out.println("Count:" + SavingsAccount.getCount());

	    SavingsAccount account1 = new SavingsAccount(10000, 0.4);
	    SavingsAccount account2 = new SavingsAccount(14000, 1.1);
	    SavingsAccount account3 = account1;

		System.out.println("Count:" + SavingsAccount.getCount());

	    account1.calculateMonthlyInterest();
	    account2.calculateMonthlyInterest();

	    System.out.println(account1.isGreater(account2));
	    System.out.println(account3);
	    System.out.println(account2);

	    account1 = null;
	    account2 = null;
	    account3 = null;
	    System.gc();
	    Runtime.getRuntime().runFinalization();
		System.out.println("Count:" + SavingsAccount.getCount());
    }
}
