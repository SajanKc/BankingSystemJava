package com.Bank.SajanKc;

class Account {
	String name;
	int accBalance, accNumber, accPassword;

	Account(){
	}

	Account(String name, int accNumber, int accPassword, int accBalance){
		this.name = name;
		this.accNumber = accNumber;
		this.accPassword = accPassword;
		this.accBalance = accBalance;
	}
}

class newAccount extends Account {
	newAccount(String name, int accNumber, int accPassword, int accBalance) {
		this.name = name;
		this.accPassword = accPassword;
		this.accNumber = accNumber;
		this.accBalance = accBalance;
	}

	newAccount() {
		super(); //calls constructor Account(){}
	}
	
	void insert(String name, int accNumber, int accPassword, int accBalance) {
		this.name = name;
		this.accNumber = accNumber;
		this.accPassword = accPassword;
		this.accBalance = accBalance;
	}	

	public void display() {
		System.out.println("\n--------------------");
		System.out.println("YOUR ACCOUNT DETAILS");
		System.out.println("--------------------");
		System.out.println("Name:\t\t" + name);
		System.out.println("Account Number:\t" + accNumber);
		System.out.println("Total Balance:\t"+"Rs." + accBalance);
		System.out.println("ATM Password:\t" + accPassword);
	}

	int withdraw(int withdraw) {
		accBalance = accBalance - withdraw;
		return accBalance;
	}//problem in withdraw amount update.

}