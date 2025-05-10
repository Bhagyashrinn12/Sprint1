package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Developer {
	
	//All attributes of developer entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int devID;  // primary key field

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
	public Developer() {
		super();
	}
    
	//paramterized constructor
	public Developer(String firstName, String lastName, String email, String contactNo,
			Project project) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo=contactNo;
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

	public int getDevID() {
		return devID;
	}

	public void setDevID(int devID) {
		this.devID = devID;
	}

    //toString() method
	@Override
	public String toString() {
		return "devID=" + devID + "| firstName=" + firstName + "| lastName=" + lastName + "| email=" + email
				+ "| conatcNo=" + contactNo + "| project="
				+ project ;
	}

}
