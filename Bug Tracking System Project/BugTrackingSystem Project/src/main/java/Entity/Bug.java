package Entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Bug {
	
	// All attributes of bug entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bugID;  //primary key field
	
	private String title;
	
	private String description;

	private String status;
	
	private int completionPercent;
	
	private LocalDate deadline;

	@ManyToOne
	@JoinColumn(name="devID", nullable=false)
	private Developer developer;

	@ManyToOne
	@JoinColumn(name="testID", nullable=false)
	private Tester tester;

	@ManyToOne
	@JoinColumn(name="projectID",nullable=false)
	private Project project;

	@ManyToOne
	@JoinColumn(name = "reportID")
	private Report report;

	//default constructor
	public Bug() {
		super();
	}

    //parameterized constructor
	public Bug(String title, String description, String status,int completionPercent, LocalDate deadline, Developer developer, Tester tester,
			Project project) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.completionPercent=completionPercent;
		this.deadline=deadline;
		this.developer = developer;
		this.tester = tester;
		this.project = project;
	}

    //getter and setter methods
	public int getBugID() {
		return bugID;
	}

	public void setBugID(int bugID) {
		this.bugID = bugID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCompletionPercent() {
		return completionPercent;
	}

	public void setCompletionPercent(int completionPercent) {
		this.completionPercent = completionPercent;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public Tester getTester() {
		return tester;
	}

	public void setTester(Tester tester) {
		this.tester = tester;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	//toString() method
	@Override
	public String toString() {
		return "bugID=" + bugID + "| title=" + title + "| description=" + description + "| status=" + status
				+ "| completionPercent=" + completionPercent + "| deadline=" + deadline + "| developer=" + developer
				+ "| tester=" + tester + "| project=" + project + "| report=" + report;
	}

    
	

}
