package com.Bank.SajanKc;

import java.util.Scanner;

public class Bank {
	public static void main(String[] args) {
		char tempChar;
		byte choice1;
		String name = null;
		int accBalance = 0, tempPassword, withdraw, accNumber, accPassword = 0, temp;
		// creating new user account
		newAccount user = new newAccount();
		
		Scanner input = new Scanner(System.in);
		do {
			do {
				System.out.println("-------------------------");
				System.out.println("***Welcome TO XYZ BANK***");
				System.out.println("-------------------------");
				System.out.println(" 1. Banking Transaction.");
				System.out.println(" 2. ATM Transaction.");
				System.out.println(" 3. Exit");
				System.out.print("\nEnter your choice: ");
				choice1 = input.nextByte();
				if (choice1 == 2 && user.accNumber == 0)
					System.out.println("\n!!!First Create Account!!!\n");
			} while (choice1 == 2 && user.accNumber == 0);
			switch (choice1) {
			case 1:
				// Bank service
				int userChoice;
				char bank = 'y';
				do {
					do {
						System.out.println("\n------------------------------------");
						System.out.println("***Welcome TO XYZ BANKING SERVICE***");
						System.out.println("------------------------------------");
						System.out.println("1. OPEN NEW ACCOUNT");
						System.out.println("2. DEPOSIT");
						System.out.println("3. WITHDRAW");
						System.out.println("4. BALANCE ENQUIRY");
						System.out.println("5. ACCOUNT INFORMATION");
						System.out.println("6. ATM PASSWORD");
						//System.out.println("7. MAIN MENU");
						System.out.print("Enter Your Choice: ");
						userChoice = input.nextInt();
						if ((userChoice == 2 || userChoice == 3 || userChoice == 4 || userChoice == 5
								|| userChoice == 6) && user.accNumber == 0)
							System.out.println("\n!!!First Create Account!!!\n");
					} while ((userChoice == 2 || userChoice == 3 || userChoice == 4 || userChoice == 5
							|| userChoice == 6) && user.accNumber == 0);
					switch (userChoice) {
					case 1: // Creating new account
						Scanner nameInput = new Scanner(System.in);
						System.out.print("Enter your Name : ");
						name = nameInput.nextLine();
						System.out.print("Enter Opening Balance: ");
						accBalance = input.nextInt();
						accNumber = (int) ((Math.random() * 100000) + 10000);
						accPassword = (int) ((Math.random() * 10000) + 1000);
						// inserting details
						user.insert(name, accNumber, accPassword, accBalance);
						System.out.println("\n--------------------------------");
						System.out.println("NOTE/REMEMBER ACCOUNT NUMBER AND PASSWORD");
						System.out.println("--------------------------------");
						user.display();
						break;
					case 2: // Deposit
						System.out.print("Enter your account Number : ");
						int tempAccNumber = input.nextInt();
						if (tempAccNumber == user.accNumber) {
							System.out.print("Enter Amount: ");
							int newBalance = input.nextInt();
							user.accBalance += newBalance;
							System.out.println("Successfully Deposited.");
						} else
							System.out.println("Wrong Accoount Number.");
						break;
					case 3: // Withdraw
						System.out.print("Enter your account Number : ");
						temp = input.nextInt();

						if (temp == user.accNumber) {
							if (user.accBalance == 0)
								System.out.print("Your Account is Empty.");
							else {
								System.out.print("Enter Amount: ");
								withdraw = input.nextInt();
								if (withdraw > user.accBalance) {
									System.out.print("Not sufficient amount in your account!!!");
									break;
								} else {
									user.withdraw(withdraw);
								}
								System.out.println("\nWithdrawing.......");
								System.out.println("Collect your Money: Rs." + withdraw);
								System.out.println("\n\nRemaining Balance : Rs." + user.accBalance);
							}
						} else
							System.out.println("Wrong Account Number.");
						break;
					case 4:// Balance Enquiry
						System.out.print("Enter your Account Number : ");
						temp = input.nextInt();
						if (temp == user.accNumber) {
							System.out.println("Your Current Balance : " + user.accBalance);
						} else
							System.out.println("Wrong Account Number.");
						break;
					case 5: // Account Details
						System.out.print("Enter your Account Number :");
						temp = input.nextInt();
						if (temp == user.accNumber) {
							user.display();
						} else
							System.out.println("Wrong Account Number.");
						break;
					case 6: // ATM Password
						System.out.print("Enter your Account Number : ");
						temp = input.nextInt();
						if (temp == user.accNumber) {
							System.out.println("Your Current ATM Password : " + accPassword);
						} else
							System.out.println("Wrong Accoount Number.");
						break;
					case 7: // goto main menu
						//main(null);
						break;
					default:
						System.out.println("\nInvalid Input, Please enter again.");
					}
					System.out.print("\nPress Y to Continue Banking Services: ");
					bank = input.next().charAt(0);
				} while (bank == 'Y' || bank == 'y');
				break;
			case 2:
				// ATM service
				char tempPIN;
				do {
					System.out.println("\n--------------------------------");
					System.out.println("***Welcome to XYZ ATM SERVICE***");
					System.out.println("--------------------------------");
					System.out.print("Enter your Password: ");
					tempPassword = input.nextInt();
					if (tempPassword == user.accPassword) {
						byte atmChoice;
						Scanner atmInput = new Scanner(System.in);
						do {
							System.out.println("\n\n***ATM MENU***");
							System.out.println("1. CHECK BALANCE");
							System.out.println("2. WITHDRAW BALANCE");
							System.out.println("3. ACCOUNT DETAILS");
							System.out.println("4. GOTO MAIN MENU");
							System.out.println("5. EXIT");
							System.out.print("Enter Your choice: ");
							atmChoice = atmInput.nextByte();
							switch (atmChoice) {
							case 1:
								System.out.println("\nTotal Balance in Your Account: Rs." + user.accBalance);
								break;
							case 2:
								if (user.accBalance <= 0)
									System.out.println("Can't withdraw! Balance insufficient.");
								else {
									System.out.print("\nEnter amount: ");
									withdraw = input.nextInt();
									if (withdraw > user.accBalance) {
										System.out.print("Not sufficient amount in your account!!!");
										break;
									} else {
										user.withdraw(withdraw);
									}
									System.out.println("\nWithdrawing.......");
									System.out.println("Collect your Money: Rs." + withdraw);
									System.out.println("\n\nRemaining Balance : Rs." + user.accBalance);							
								}								
								break;
							case 3:
								user.display();
								break;
							case 4:
								main(null);
								break;
							case 5:
								System.exit(0);
							default:
								System.out.println("\nInvalid choice!! Please enter fromo 1 to 4: ");
							}
						} while (atmChoice != 5);
						atmInput.close();
						System.out.println("\nHAVE A NICE DAY");
					} else
						System.out.println("\nWrong Password Number! Please try again!!");
					System.out.println("Do you want to enter again(y/n)? ");
					tempPIN = input.next().charAt(0);
				} while (tempPIN == 'Y' || tempPIN == 'y');
				break;
			case 3:
				System.exit(-1);
			default:
				System.out.println("\nInvalid Input, Please enter again.");
			}
			System.out.print("\nPress Y To Enter Main Menu: ");
			tempChar = input.next().charAt(0);
		} while (tempChar == 'Y' || tempChar == 'y');
		System.out.println("\nThank You, Have a Nice Day, Bye Bye...");
		input.close();
	}
}