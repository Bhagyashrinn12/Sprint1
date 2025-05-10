package Dao;

import java.util.List;

import Entity.Bug;
import Entity.Developer;
import Entity.Project;
import Entity.Tester;

public interface BugDao {
	//getting project details
	Project getProject(int projectID);
	
	//getting developer details
	Developer getDevepoer(int devID);
	
	//getting tester details
	Tester getTester(int testID);
	
	//Assigning bug to the developer to resolve
	Bug addBug(Bug bug);	
	
	//to display all bugs
	List<Bug> getAllBugs();
	
	//get bug details by bug id
	Bug getBug(int bugID);
	
	//updating bug details
	Bug updateBug(int bugID,Bug updatedBug);
	
	//to delete bug details
	String deleteBug(int bugID);
}
