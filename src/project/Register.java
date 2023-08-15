package project;

import java.util.Scanner;

public class Register implements menuPrint {
	private static Scanner sc = new Scanner(System.in);
	private static int choice2;
	private String id, firstName, lastName, email, password;
	private long phoneNum;
	
	private void getDetails() {
		System.out.println("Enter your first name: ");
		firstName = sc.next();
		System.out.println("Enter your last name: ");
		lastName = sc.next();
		System.out.println("Enter your email: ");
		email = sc.next();
		System.out.println("Enter new password: ");
		password = sc.next();
		System.out.println("Enter your phone number: ");
		phoneNum = sc.nextLong();
	}
	
	 private boolean regCoder() {
		getDetails();
		
		return true;
	 }
	 
	 private boolean regBuyer() {
		 getDetails();
		 return true;
	 }
	
	 @Override
	public int printMenu() {
		System.out.println("Press 1 if you want to register as a coder");
		System.out.println("Press 2 if you want to register as a buyer");
		choice2 = sc.nextInt();
		return choice2;
	}//Here we take the choice whether the user wants to register as a coder or a buyer
	
	public void checkChoice() {
		int ch = printMenu();
		if(ch == 1) {
			System.out.println("Register as a coder");
			if(regCoder()) {
				System.out.println("Successfully Registered");
			}//Enforcing checks whether the user could be registered
			
		}
		else if(ch == 2) {
			System.out.println("Register as a buyer");
			if(regBuyer()) {
				System.out.println("Successfully Registered");
			}
			
		}
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNum=" + phoneNum + "]";
	}
	
	
	

	

}
