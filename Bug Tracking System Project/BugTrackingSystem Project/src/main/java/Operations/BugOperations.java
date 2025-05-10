package Operations;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.anudip.BugTrackingSystem1.App;

import Entity.Bug;
import Entity.Developer;
import Entity.Project;
import Entity.Tester;
import Exception.ResourceNotFoundException;
import ServiceImpl.BugServiceImpl;


public class BugOperations {
	static BugServiceImpl bugService=new BugServiceImpl();  //BugServiceImpl object creation
	static Scanner sc=new Scanner(System.in);//Scanner object creation
	static LocalDate localDate;
	
	//taking bug details as input through Scanner
	public static Bug bugInputs() {
		sc.nextLine();
		System.out.println("Enter bug title: ");
		String title=sc.nextLine();
		System.out.println("Enter bug description: ");
		String description=sc.nextLine();
		System.out.println("Enter bug status(complete/incomplete/in progress): ");
		String status=sc.nextLine();
		status=status.toLowerCase();
		int completionPercent;
		if(status.equals("complete"))
		{
			completionPercent=100;
		}
		else if(status.equals("incomplete")) {
			completionPercent=0;
		}
		else {
			System.out.println("Enter the completion percentage of bug: ");
			completionPercent=sc.nextInt();
		}
		System.out.println("Enter deadline of bug resolve(yyyy-mm-dd): ");
		
		String deadline=sc.next();
		
	    try {
			    // Parse date using LocalDate
			    localDate = LocalDate.parse(deadline);  // throws DateTimeParseException if invalid    
		 }
	    catch (Exception e) {
			    System.out.println("Error: " + e.getMessage());
		}
			    
		System.out.println("Enter developer id for which the bug is assigned to resolve: ");
		int devID=sc.nextInt();
		Developer developer=bugService.getDeveloper(devID);
		System.out.println("Enter tester id which identified the bug:  ");
		int testID=sc.nextInt();
		Tester tester=bugService.getTester(testID);
		System.out.println("Enter project id on which you are going to work: ");
		int projectID=sc.nextInt();
		Project project=bugService.getProject(projectID);
		return new Bug(title,description,status,completionPercent,localDate ,developer,tester,project);
	}
	
	//to display bug operations related to Bug entity
	public static void bugOperations() {
		while(true) {
			System.out.println("Press 1. Add bug details \nPress 2. Retrive all bug details "
					+ "\nPress 3. Update bug details \nPress 4. Delete bug details \nPress 5. To getback to the main menu");
			System.out.println("Enter choice: ");
			int input=sc.nextInt();
			switch(input) {
			case 1:
				Bug bug=bugInputs();
				Bug savedEntity=bugService.addBug(bug);
				System.out.println("Bug Data has been saved successfully");
				break;
			case 2:
				try {
				List<Bug> bugs=bugService.getAllBugs();
				for(Bug b:bugs)
				{
					System.out.println(b);
				}
				}
				catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 3:sc.nextLine();
			    System.out.println("Enter Bug Id to update the information");
		      int bugID=sc.nextInt();
		      Bug s=bugService.getBug(bugID);
		       if(s!=null) {
		       Bug bug1=updatedBugData(bugID);
		     //service
		      Bug updatedInfo=bugService.updateBug(bugID, bug1);
		       System.out.println("Bug Data has been updated Successfully");
		       }
		       
		       else
		       {
		    	   throw new ResourceNotFoundException("Bug Id not found");
		       }
		       
			break;
		

				
			case 4:
				System.out.println("Enter Bug Id to delete the information");
			       int id=sc.nextInt();
			       String message=bugService.deleteBug(id);
			       System.out.println(message);
				break;
				
			case 5:App.mainOps();
			break;
			default:
				System.out.println("Invalid Input");
			
			}
		}
	}
	
	//to update bug details by bug id
	public static Bug updatedBugData(int bugID) {
		sc.nextLine();
		System.out.println("Enter bug title: ");
		String title=sc.nextLine();
		System.out.println("Enter bug description: ");
		String description=sc.nextLine();
		System.out.println("Enter bug status(complete/incomplete/in progress): ");
		String status=sc.nextLine();
		status=status.toLowerCase();
		int completionPercent;
		if(status.equals("complete"))
		{
			completionPercent=100;
		}
		else if(status.equals("incomplete")) {
			completionPercent=0;
		}
		else {
			System.out.println("Enter the completion percentage of bug: ");
			completionPercent=sc.nextInt();
		}
		System.out.println("Enter deadline of bug resolve(yyyy-mm-dd): ");
		String deadline=sc.nextLine();
		
	    try {
			    // Parse date using LocalDate
			    localDate = LocalDate.parse(deadline);  // throws DateTimeParseException if invalid    
		 }
	    catch (Exception e) {
			    System.out.println("Error: " + e.getMessage());
		}
			    
		System.out.println("Enter developer id for which the bug is assigned to resolve: ");
		int devID=sc.nextInt();
		Developer developer=bugService.getDeveloper(devID);
		System.out.println("Enter tester id which identified the bug:  ");
		int testID=sc.nextInt();
		Tester tester=bugService.getTester(testID);
		System.out.println("Enter project id on which you are going to work: ");
		int projectID=sc.nextInt();
		Project project=bugService.getProject(projectID);
		return new Bug(title,description,status,completionPercent,localDate ,developer,tester,project);
		
	}


}
