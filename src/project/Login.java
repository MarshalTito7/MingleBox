package project;


import java.util.Scanner;

public class Login extends Register implements menuPrint  { //here we are inheriting the register class to get the data of the registered users
	static Scanner sc = new Scanner(System.in);
	static int choice2;
	String logEmail, checkPass;
	
	
	
	 
	
	 @Override
	public int printMenu() {
		System.out.println("Press 1 if you want to login as a coder");
		System.out.println("Press 2 if you want to login as a buyer");
		choice2 = sc.nextInt();
		return choice2;
	}
	
	public void checkChoice() {
		int ch = printMenu();
		if(ch == 1) {
			System.out.println("Login as a coder");
			System.out.println("Enter your email id: ");
			 logEmail = sc.next();
			 if(!coderGang.containsKey(logEmail)) {
				 System.out.println("Email not registered. You need to register first");
			 }
			 else if(coderGang.containsKey(logEmail)) {
				 System.out.println("Enter your password: ");
				 checkPass = sc.next();
//				 Take the input of the password from the user
				 if(checkPass.equals(coderGang.get(logEmail).getPassword())) { //Check whether the password matches
					 System.out.println("Successfully logged in");
					 System.out.println(coderGang.get(logEmail).toString());
					 System.out.println();
//					 
				 }
				 
				
			 }	
			
		}
		else if(ch == 2) {
			System.out.println("login as a buyer");
			System.out.println("Enter your email id: ");
			 logEmail = sc.next();
			 if(!buyerGang.containsKey(logEmail)) {
				 System.out.println("Email not registered. You need to register first");
			 }
			 else if(buyerGang.containsKey(logEmail)) {
				 System.out.println("Enter your password: ");
				 checkPass = sc.next();
//				 Take the input of the password from the user
				 if(checkPass.equals(buyerGang.get(logEmail).getPassword())) { //Check whether the password matches
					 System.out.println("Successfully logged in");
					 System.out.println(buyerGang.get(logEmail).toString());
					 System.out.println();
//					 
				 }
			 }
			
		}
	}
	

	

}
