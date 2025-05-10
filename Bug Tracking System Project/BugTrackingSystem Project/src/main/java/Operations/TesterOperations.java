package Operations;

import java.util.List;
import java.util.Scanner;

import com.anudip.BugTrackingSystem1.App;

import Entity.Project;
import Entity.Tester;
import Exception.ResourceNotFoundException;
import ServiceImpl.TesterServiceImpl;
import Validation.Validator;

public class TesterOperations {
	//object creation of TesterServiceImpl
	static TesterServiceImpl testerService=new TesterServiceImpl();
	
	//Scanner object creation
	static Scanner sc=new Scanner(System.in);
	
	//taking tetser details as input through Scanner
	public static Tester testerInputs() {
		sc.nextLine();
		String firstName;
        do {
            System.out.print("Enter tester first name:");
            firstName = sc.next();
            if (!Validator.isValidName(firstName)) {
                System.out.println("Invalid first name. Please try again.");
            }
        } while (!Validator.isValidName(firstName));
		
        String lastName;
        do {
            System.out.print("Enter tester last name:");
            lastName = sc.next();
            if (!Validator.isValidName(lastName)) {
                System.out.println("Invalid last name. Please try again.");
            }
        } while (!Validator.isValidName(lastName));
        
		String email;
        do {
            System.out.print("Enter a valid email: ");
            email = sc.next();
            if (!Validator.isValidEmail(email)) {
                System.out.println("Invalid email. Please try again.");
            }
        } while (!Validator.isValidEmail(email));
        String contactNo;
        do {
            System.out.print("Enter contact number: ");
            contactNo = sc.next();
            if (!Validator.isValidMobile(contactNo)) {
                System.out.println("Invalid contact number. Please try again.");
            }
        } while (!Validator.isValidMobile(contactNo));
        
		System.out.println("Enter project id on which you are going to work: ");
		int projectID=sc.nextInt();
		Project project=testerService.getProject(projectID);
		return new Tester(firstName, lastName, email, contactNo, project);
	}
	
	//to display tester operations that should be performed on tester entity
	public static void testerOperations() {
		while(true) {
			System.out.println("Press 1. Add tester details \nPress 2. Retrive all tester details "
					+ "\nPress 3. Update tester details \nPress 4. Delete tester details \nPress 5. To getback to the main menu");
			System.out.println("Enter choice: ");
			int input=sc.nextInt();
			switch(input) {
			case 1:
				Tester tester=testerInputs();
				Tester savedEntity=testerService.addTester(tester);
				System.out.println("Tester Data has been saved successfully");
				break;
			case 2:
				List<Tester> testers=testerService.getAllTesters();
				for(Tester test:testers)
				{
					System.out.println(test);
				}
				break;
			case 3:sc.nextLine();
			    System.out.println("Enter Tester Id to update the information");
		       int testID=sc.nextInt();
		      Tester s=testerService.getTester(testID);
		       if(s!=null) {
		      Tester test=updatedTesterData(testID);
		     //service
		      Tester updatedInfo=testerService.updateTester(testID, test);
		       System.out.println("Tester Data has been updated Successfully");
		       }
		       
		       else
		       {
		    	   throw new ResourceNotFoundException("Tester Id not found");
		       }
		       
			break;
		

				
			case 4:
				System.out.println("Enter Tester Id to delete the information");
			       int id=sc.nextInt();
			       String message=testerService.deleteTester(id);
			       System.out.println(message);
				break;
				
			case 5:App.mainOps();
			break;
			default:
				System.out.println("Invalid Input");
			
			}
		}
	}
	
	//to update tester details by tester id
	public static Tester updatedTesterData(int testID) {
		sc.nextLine();
		String firstName;
        do {
            System.out.print("Enter tester first name:");
            firstName = sc.next();
            if (!Validator.isValidName(firstName)) {
                System.out.println("Invalid first name. Please try again.");
            }
        } while (!Validator.isValidName(firstName));
		
        String lastName;
        do {
            System.out.print("Enter tester last name:");
            lastName = sc.next();
            if (!Validator.isValidName(lastName)) {
                System.out.println("Invalid last name. Please try again.");
            }
        } while (!Validator.isValidName(lastName));
        
		String email;
        do {
            System.out.print("Enter a valid email: ");
            email = sc.next();
            if (!Validator.isValidEmail(email)) {
                System.out.println("Invalid email. Please try again.");
            }
        } while (!Validator.isValidEmail(email));
        String contactNo;
        do {
            System.out.print("Enter contact number: ");
            contactNo = sc.next();
            if (!Validator.isValidMobile(contactNo)) {
                System.out.println("Invalid contact number. Please try again.");
            }
        } while (!Validator.isValidMobile(contactNo));
        
		System.out.println("Enter project id on which you are going to work: ");
		int projectID=sc.nextInt();
		Project project=testerService.getProject(projectID);
		return new Tester(firstName, lastName, email, contactNo, project);
		
	}


}
