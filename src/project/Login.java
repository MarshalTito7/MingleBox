package project;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Login extends Register implements menuPrint  { //here we are inheriting the register class to get the data of the registered users
	static Scanner sc = new Scanner(System.in);
	static int choice2;
	String logEmail, checkPass;
	
	String projName, reqSkill, description, projId;
	int amount;
	String assignCoder;
	String status;
	Integer bidinc = 0;
	
	static HashMap<String, ProjectDetails> detailsOfProjects = new HashMap<>();
	static HashMap<Integer, Bids> detailsOfBids = new HashMap<>();

	
	 
	
	 @Override
	public int printMenu() {
		 System.out.println();
		System.out.println("Press 1 if you want to login as a coder");
		System.out.println("Press 2 if you want to login as a buyer");
		choice2 = sc.nextInt();
		return choice2;
	}
	 
//		This menu is printed once the coder logs in successfully
	private int printCoderMenu() {
		System.out.println();
		System.out.println("Press 1 to view available list of projects");
		System.out.println("Press 2 to bid for projects");
		System.out.println("Press 3 to view your assigned project");
		System.out.println("Press 4 if you have completed your assigned project");
		System.out.println("Press 5 to logout");
		choice2 = sc.nextInt();
		System.out.println();
		return choice2;

	}
	
//		This menu is printed once the coder logs in successfully
	private int printBuyerMenu() {
		System.out.println();
		System.out.println("Press 1 to view your added projects");
		System.out.println("Press 2 to add project for bidding");
		System.out.println("Press 3 to view bids");
		System.out.println("Press 4 to finalise bid");
		System.out.println("Press 5 to make payment for your completed projects");
		System.out.println("Press 6 to logout");
		choice2 = sc.nextInt();
		System.out.println();
		return choice2;
	}
	
//	Function to print the project details of the buyer if any
	protected int getProjDetails() {
		int flag = 0;
	    System.out.print("\nYOUR ADDED PROJECT REQUESTS: ");

        for (Entry<String, ProjectDetails> mapElement : detailsOfProjects.entrySet()) {
            String key = mapElement.getKey();
 
            if(mapElement.getValue().getOwnerId().equalsIgnoreCase(logEmail)) {
	    		
            	System.out.println("Project id:" + key);
            	System.out.println(mapElement.getValue().toString());
	   	      	flag = 1;
	    	}
        }

	    return flag;
	}
	
//	Function to register new project
	private void addProjDetails() {
		System.out.println("ENTER NEW PROJECT DETAILS: ");
		System.out.println("Enter new project id: ");
		projId = sc.next();
		if(!detailsOfProjects.containsKey(projId)) {
			System.out.println("Enter your project name: ");
			projName = sc.next();
			System.out.println("Enter required skill for the project: ");
			reqSkill = sc.next();
			System.out.println("Enter project description: ");
			description = sc.next();
			ProjectDetails tempProj = new ProjectDetails( projName, reqSkill, null, logEmail, description, "Not Assigned",0);
			detailsOfProjects.put(projId, tempProj);
			System.out.println("Project successfully Registered");
			System.out.println(detailsOfProjects.size());
			
		}
		else if(detailsOfProjects.containsKey(projId)) {
			System.out.println("Project id already exists!");
		}
		
		
	}
	

	
//	Function to search for available project details (coder)
	protected int searchProjDetails() {
		int flag = 0;
	    System.out.print("\nLIST OF AVAILABLE PROJECTS: ");	

        for (Entry<String, ProjectDetails> mapElement : detailsOfProjects.entrySet()) {
            String key = mapElement.getKey();
 
            if(mapElement.getValue().getStatus().equalsIgnoreCase("Not Assigned") && mapElement.getValue().getReqSkill().equalsIgnoreCase(coderGang.get(logEmail).getSkills())) {
	    		
            	System.out.println("Project id:" + key);
            	System.out.println(mapElement.getValue().toString());
	   	      	flag = 1;
//	    	Here we are only showing the projects that are not assigned and are matching the coder's Skillset
	    	}
        }

	    return flag;
	}
	
//	Function to place bids(coder)
	protected void placeBids() {
		System.out.println("ENTER NEW BID DETAILS: ");
		System.out.println("Enter project id for which you want to bid: ");
		String tempProId;
		tempProId = sc.next();
		System.out.println("Enter your bid amount: ");
		int tempBidAmt = sc.nextInt();
		Bids tempBid = new Bids(logEmail, tempProId, tempBidAmt);
		bidinc++;
		detailsOfBids.put(bidinc, tempBid);
		System.out.println("Bid Successfully Registered");
		System.out.println(detailsOfBids.size());
		
	}
	
//	Function to view bids
	protected int getBids(String tempEmail) {
		
		
		int flag = 0;
		
		HashMap<String, ProjectDetails> tempFetch = new HashMap<>();
        for (Entry<String, ProjectDetails> mapElement : detailsOfProjects.entrySet()) {
            String key = mapElement.getKey();
 
            if(mapElement.getValue().getOwnerId().equalsIgnoreCase(tempEmail)) {
            	tempFetch.put(key, mapElement.getValue());         	
	    	}
        }//fetching the projects requested by buyer
        
        System.out.println("The following bids have been placed for your projects: ");
        for (Entry<String, ProjectDetails> mapElement : tempFetch.entrySet()) {
            String prokey = mapElement.getKey();
            
            for (Entry<Integer, Bids> mapElement2 : detailsOfBids.entrySet()) {
                Integer bidkey = mapElement2.getKey();
                if(mapElement2.getValue().getProjId().equalsIgnoreCase(prokey)) {
                	System.out.println("Bid ID: "+bidkey);
                	System.out.println(mapElement2.toString());
                	flag = 1;
                	
                }

            }

        }

	    return flag;
	}
	
	
//	Function to find winning bid
	protected int finaliseBid(String tempProId) {
		
		int flag = 0;
		
            int compar = Integer.MAX_VALUE;
            Bids minBid = new Bids(null, tempProId, 0);
            List<Integer> placedBids = new ArrayList<>();
            //This will be required to remove the bids for the already assigned project
            
            for (Entry<Integer, Bids> mapElement2 : detailsOfBids.entrySet()) {
            	if(mapElement2.getValue().getProjId().equalsIgnoreCase(tempProId))
            		placedBids.add(mapElement2.getKey());
                if(mapElement2.getValue().getProjId().equalsIgnoreCase(tempProId) && mapElement2.getValue().getBidAmt()<compar) {
//                	here we will store the minimum bid;
                	compar=mapElement2.getValue().getBidAmt();
                	minBid.setCoderId(mapElement2.getValue().getCoderId());
                	minBid.setBidAmt(compar);

                	flag = 1;
                	
                }

            }
            System.out.println("WINNING BID:");
            System.out.println(minBid.toString());
            if(flag == 1) {
            	detailsOfProjects.get(tempProId).setStatus("Assigned");
            	detailsOfProjects.get(tempProId).setAssignCoder(minBid.getCoderId());
            	detailsOfProjects.get(tempProId).setPaymentToBeMade(minBid.getBidAmt());
//            	Here we are updating the newly assigned coders and the amount to be paid and the status of the project
            	
            	for(Integer i : placedBids) {
            		detailsOfBids.remove(i);
            	}
//            	Here we are removing all the losing bids from the hashmap
            	
//            	Now we are assigning the project to the coder
            	coderGang.get(minBid.getCoderId()).setWorkingProject(tempProId);
            	
            }
			return flag;

	}
	
	protected void completeProject(String tempWorkingCoder) {
		System.out.println("Enter the project id on which you were working: ");
		String tempComp = sc.next();
		if(coderGang.get(tempWorkingCoder).getWorkingProject() == null) {
			System.out.println("\nYou have not been assigned this project!");
		}
		else if(detailsOfProjects.containsKey(tempComp) && detailsOfProjects.get(tempComp).getAssignCoder().equalsIgnoreCase(tempWorkingCoder)) {
			detailsOfProjects.get(tempComp).setStatus("Completed");
			coderGang.get(tempWorkingCoder).setWorkingProject(null);
			System.out.println("\nThank You!");
			
		}
		else {
			System.out.println("\nYou have not been assigned this project!");
		}
		
	}
	
	private int makePayment(String string) {
		// TODO Auto-generated method stub
		int flag = 0;
		if(detailsOfProjects.get(string).getStatus().equalsIgnoreCase("Completed")) {
			System.out.println("Thank You for making payment of $"+detailsOfProjects.get(string).getPaymentToBeMade()+" to Coder id: "+detailsOfProjects.get(string).getAssignCoder());
			flag = 1;
		}
		return flag;

		
	}
	
	
	public void checkChoice() {
		int ch = printMenu();
//		User wants to login as coder
		if(ch == 1) {
			System.out.println("LOGIN AS A CODER");
			System.out.println("Enter your email id: ");
			 logEmail = sc.next();
			 if(!coderGang.containsKey(logEmail)) {
				 System.out.println("Email not registered. You need to register first");
			 }
			 else if(coderGang.containsKey(logEmail)) 
			 {
				 System.out.println("Enter your password: ");
				 checkPass = sc.next();
//				 Take the input of the password from the user
				 if(checkPass.equals(coderGang.get(logEmail).getPassword())) //Check whether the password matches
				 { 
					 
					 System.out.println("Successfully logged in");
					 System.out.println();
//					 Now once we log in successfully, we loop unless the user signs out
					 while(true) {
						 ch = printCoderMenu();
						 if(ch == 5)
							 break; //i.e we log out from coder portal
						 else if(ch==4) {
							 completeProject(logEmail);
						 }
						 else if(ch==3) {
							 
							 if(coderGang.get(logEmail).getWorkingProject() == null) {
								 System.out.println("You have not yet won a project! ");
							 }
							 else {
								 System.out.println("Your assigned project is: ");
								 System.out.println(coderGang.get(logEmail).getWorkingProject());								 
							 }
						 }
						 else if(ch==2) {
							 if(coderGang.get(logEmail).getWorkingProject() != null) {
								 System.out.println("You cannot place bids as you are already working on a project: ");
//								 Check whether coder is already working on a project
							 }
							 else {
								 placeBids();
							 }
//							 Register a new bid
						 }
						 else if(ch == 1) {
							 int check = searchProjDetails();
							 if(check == 0) {
								 System.out.println("No projects are available matching your skillset at the moment");
							 }
						 }
						 
					 }
					
				 }
				 
				
			 }	
			
		}
		else if(ch == 2) {
//			User wants to login as Buyer
			System.out.println("LOGIN AS A BUYER");
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
//					 Now once we log in successfully, we loop unless the user signs out
					 while(true) {
						 ch = printBuyerMenu();
						 if(ch == 6)
							 break; //i.e we log out from buyer portal
						 else if(ch == 5) {
							 System.out.println("Enter the project id for which you want to make payment: ");
							 int check = makePayment(sc.next());
							 if(check == 0) {
								 System.out.println("Sorry this project has not yet been completed.");
							 }
							 
						 }
						 else if(ch == 4) {
							 System.out.println("Enter the project id for which you want to finalise bids: ");
							 int check = finaliseBid(sc.next());
							 if(check == 0) {
								 System.out.println("Sorry no bids have been placed for the given project id.");
							 }
						 }
						 else if(ch==3) {
							 int check = getBids(logEmail);
							 if(check == 0) {
								 System.out.println("Sorry no bids have been placed for your projects.");
							 }
							 						 
						 }
						 else if(ch==2) {
							 addProjDetails();
//							 Register a new project
						 }
						 else if(ch == 1) {
							 int check = getProjDetails();
							 if(check == 0) {
								 System.out.println("You are yet to request for a project");
							 }
						 }
						 
						 
					 }
//					 
				 }
			 }
			
		}
	}


	

	

}
