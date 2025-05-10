package Operations;
import java.util.List;
import java.util.Scanner;

import com.anudip.BugTrackingSystem1.App;

import Entity.Project;
import Service.ProjectService;
import ServiceImpl.ProjectServiceImpl;

public class ProjectOperations {
	//object creation of ProjectServiceImpl
	static ProjectServiceImpl projectService=new ProjectServiceImpl();
	
	//Scanner object creation
	static Scanner sc=new Scanner(System.in);
	
	//taking project details as input through Scanner
	public static Project projectInputs() {
		sc.nextLine();
		System.out.println("Enter project name: ");
		String projectName=sc.nextLine();
		return new Project(projectName);
	}
	
	//to display the operations that should be performed on Project entity
	public static void projectOperations() {
		while(true) {
			System.out.println("Press 1. Add Project details \nPress 2. Retrive all project details "
					+ "\nPress 3. Delete Project details \nPress 4. To getback to the main menu");
			System.out.println("Enter choice: ");
			int input=sc.nextInt();
			switch(input) {
			case 1:
				Project project=projectInputs();
				Project savedEntity=projectService.addProject(project);
				System.out.println("Project Data has been saved successfully");
				break;
			case 2:
				List<Project> projects=projectService.getAllProjects();
				for(Project prj:projects)
				{
					System.out.println(prj);
				}
				break;
			case 3:
				System.out.println("Enter Project Id to delete the information");
			       int id=sc.nextInt();
			       String message=projectService.deleteProject(id);
			       System.out.println(message);
				break;
				
			case 4:App.mainOps();
			break;
			default:
				System.out.println("Invalid Input");

 
			
			}
		}
	}

}
