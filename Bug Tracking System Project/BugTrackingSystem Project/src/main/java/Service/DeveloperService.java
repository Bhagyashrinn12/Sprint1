package Service;

import java.util.List;

import Entity.Developer;
import Entity.Project;

public interface DeveloperService {
	//to get project details
		Project getProject(int projectID);
		
		//to add developer details
		Developer addDeveloper(Developer developer);
		
		//to display all developer details
		List<Developer> getAllDevelopers();
		
		//to get developer details by developer id
		Developer getDeveloper(int devID);
		
		//to update developer details
		Developer updateDeveloper(int devID,Developer updatedDeveloper);
		
		//to delete developer details
		String deleteDeveloper(int devID);

}
