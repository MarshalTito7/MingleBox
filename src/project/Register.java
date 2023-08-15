package project;

import java.util.HashMap;
import java.util.Scanner;

public class Register implements menuPrint {
	private static Scanner sc = new Scanner(System.in);
	private static int choice2;
	private String id, firstName, lastName;
	private String email;
	private String password;
	protected String skill;
	private long phoneNum;
	protected static HashMap<String, Coder> coderGang = new HashMap<>();
	protected static HashMap<String, Buyer> buyerGang = new HashMap<>();
	
	
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
		System.out.println("Enter your username: ");
		id = sc.next();
	}
	
	 private boolean regCoder() {
		getDetails();
		System.out.println("Enter your main skill: ");
		skill = sc.next();
		Coder tempCode = new Coder(id, firstName, lastName, email, password, phoneNum, skill);
		if(!coderGang.containsKey(email)) {
			coderGang.put(email, tempCode);
			System.out.println(tempCode.toString());
			return true;
		}
		else {
			return false;
		}
		
		
	 }
	 
	 private boolean regBuyer() {
		 getDetails();
		 Buyer tempBuy = new Buyer(id, firstName, lastName, email, password, phoneNum);
			if(!buyerGang.containsKey(email)) {
				buyerGang.put(email, tempBuy);
				return true;
			}
			else {
				return false;
			}
		 
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
			else {
				System.out.println("Email already registered");
//				System.out.println(coderGang.size());
//				Checked whether the hashmap is successfully storing
			}
			
		}
		
		else if(ch == 2) {
			System.out.println("Register as a buyer");
			if(regBuyer()) {
				System.out.println("Successfully Registered");
			}
			else{
				System.out.println("Email already registered");
			}
			
		}
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", skill=" + skill + ", phoneNum=" + phoneNum + "]";
	}

	
	
	

	

}
