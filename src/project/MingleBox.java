package project;

public class MingleBox {
	static MainMenu m1 = new MainMenu();
	static Login l1 = new Login();
	static Register r1 = new Register();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			int choice1 = m1.printMenu(); //Here we will print the main menu using the MainMenu class
			//System.out.println(choice1);
			
			if(choice1 == 1) {
				l1.checkChoice();
			}
			else if(choice1 == 2) {
				r1.checkChoice();
//				System.out.println(r1.toString());
			}
			else if(choice1 == 3) {
				break; //When user enters the number 3 in the main menu the program exits
			}
		}
		System.out.println("Thank You for using MingleBox - Parijat Niyogy");

	}

}
