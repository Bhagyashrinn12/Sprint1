package Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Tester {
	//All attributes of tester entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testID;  //primary key field

	private String firstName;

	private String lastName;

	@Column(length=30)
	private String email;

	@Column(length=10)
	private String contactNo;

	@ManyToOne
	@JoinColumn(name="projectID", nullable=false)
	private Project project;

	//default constructor
	public Tester() {
		super();
	}

	//parameterized constructor
	public Tester(String firstName, String lastName, String email, String contactNo,
			Project project) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		this.project = project;
	}
	
	//getter and setter methods
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	//toString() method
	@Override
	public String toString() {
		return "testID=" + testID + "| firstName=" + firstName + "| lastName=" + lastName + "| email="
				+ email + "| contactNo=" + contactNo + "| project=" + project;
	}

}
