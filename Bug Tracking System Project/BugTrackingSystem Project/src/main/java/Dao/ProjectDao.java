package Dao;

import java.util.List;

import Entity.Project;

public interface ProjectDao {
	
	//to add project details
	Project addProject(Project project);
	
	//to display all project details
	List<Project> getAllProjects();
	
	//to delete project details
	String deleteProject(int projectID);
}
