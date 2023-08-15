package project;

import java.util.Scanner;

public class MainMenu implements menuPrint {
	
	static Scanner sc = new Scanner(System.in);
	static int choice1;
	
	@Override
	public int printMenu() {
		System.out.println("Welcome to MingleBox Project");
		System.out.println("Press 1 to Login");
		System.out.println("Press 2 to Register");
		System.out.println("Press 3 to Exit");
		choice1 = sc.nextInt();
		
		return choice1;
		
	}
	
}
