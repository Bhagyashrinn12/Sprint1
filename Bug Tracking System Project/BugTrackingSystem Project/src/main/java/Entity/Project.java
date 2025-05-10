package Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project {
	
	// All attributes of project entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectID; // primary key field

	private String projectName;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Developer> developers = new ArrayList<>(); 

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tester> testers = new ArrayList<>();

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Bug> bugs=new ArrayList<>();
	
	//default constructor
	public Project() {
		super();
	}

	//paramterized constructor
	public Project(String projectName) {
		super();
		this.projectName = projectName;
	}

	//getter and setter methods
	public List<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}

	public List<Tester> getTesters() {
		return testers;
	}

	public void setTesters(List<Tester> testers) {
		this.testers = testers;
	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}


	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	//toString() method
	@Override
	public String toString() {
		return "projectID=" + projectID + "| projectName=" + projectName ;
	}

}
