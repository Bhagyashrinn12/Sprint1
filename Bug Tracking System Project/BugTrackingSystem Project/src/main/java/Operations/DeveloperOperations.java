package Operations;

import java.util.List;
import java.util.Scanner;

import com.anudip.BugTrackingSystem1.App;

import Entity.Developer;
import Entity.Project;
import Exception.ResourceNotFoundException;
import ServiceImpl.DeveloperServiceImpl;
import Validation.Validator;



public class DeveloperOperations {
	//object creation og DeveloperServiceImpl
	static DeveloperServiceImpl developerService=new DeveloperServiceImpl();
	
	//Scanner object creation
	static Scanner sc=new Scanner(System.in);
	
	//taking developer details as input through Scanner
	public static Developer developerInputs() {
		sc.nextLine();
		String firstName;
        do {
            System.out.print("Enter developer first name:");
            firstName = sc.next();
            if (!Validator.isValidName(firstName)) {
                System.out.println("Invalid first name. Please try again.");
            }
        } while (!Validator.isValidName(firstName));
		
        String lastName;
        do {
            System.out.print("Enter developer last name:");
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
		Project project=developerService.getProject(projectID);
		return new Developer(firstName, lastName, email, contactNo, project);
	}
	
	//to display the operations that should be performed on Developer entity
	public static void developerOperations() {
		while(true) {
			System.out.println("Press 1. Add developer details \nPress 2. Retrive all developer details "
					+ "\nPress 3. Update developer details \nPress 4. Delete developer details \nPress 5. To getback to the main menu");
			System.out.println("Enter choice: ");
			int input=sc.nextInt();
			switch(input) {
			case 1:
				Developer developer=developerInputs();
				Developer savedEntity=developerService.addDeveloper(developer);
				System.out.println("Developer Data has been saved successfully");
				break;
			case 2:
				List<Developer> developers=developerService.getAllDevelopers();
				for(Developer dev:developers)
				{
					System.out.println(dev);
				}
				break;
			case 3:sc.nextLine();
			    System.out.println("Enter Developer Id to update the information");
		       int devID=sc.nextInt();
		       Developer s=developerService.getDeveloper(devID);
		       if(s!=null) {
		       Developer dev=updatedDeveloperData(devID);
		     //service
		       Developer updatedInfo=developerService.updateDeveloper(devID, dev);
		       System.out.println("Developer Data has been updated Successfully");
		       }
		       
		       else
		       {
		    	   throw new ResourceNotFoundException("Developer Id not found");
		       }
		       
			break;
		

				
			case 4:
				System.out.println("Enter Developer Id to delete the information");
			       int id=sc.nextInt();
			       String message=developerService.deleteDeveloper(id);
			       System.out.println(message);
				break;
				
			case 5:App.mainOps();
			break;
			default:
				System.out.println("Invalid Input");

 
			
			}
		}
	}
	
	//to update developer details by developer id
	public static Developer updatedDeveloperData(int devID) {
		sc.nextLine();
		String firstName;
        do {
            System.out.print("Enter developer first name:");
            firstName = sc.next();
            if (!Validator.isValidName(firstName)) {
                System.out.println("Invalid first name. Please try again.");
            }
        } while (!Validator.isValidName(firstName));
		
        String lastName;
        do {
            System.out.print("Enter developer last name:");
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
		Project project=developerService.getProject(projectID);
		return new Developer(firstName, lastName, email, contactNo, project);
		
	}

}
