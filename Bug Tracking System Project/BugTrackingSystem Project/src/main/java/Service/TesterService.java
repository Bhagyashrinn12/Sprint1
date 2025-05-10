package Service;

import java.util.List;

import Entity.Project;
import Entity.Tester;

public interface TesterService {
	//to get project details by project id
		Project getProject(int projectID);
		
		//to add tester details
		Tester addTester(Tester tester);
		
		//to display all tester details
		List<Tester> getAllTesters();
		
		//to get tester details by tester id
		Tester getTester(int testID);
		
		//to update tester details
		Tester updateTester(int testID,Tester updatedTester);
		
		//to delete tester details
		String deleteTester(int testID);

}
