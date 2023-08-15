package project;


import java.util.Scanner;

public class Login implements menuPrint {
	static Scanner sc = new Scanner(System.in);
	static int choice2;
	
	 
	
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
			System.out.println("login as a coder");
			
		}
		else if(ch == 2) {
			System.out.println("login as a buyer");
			
		}
	}
	

	

}
