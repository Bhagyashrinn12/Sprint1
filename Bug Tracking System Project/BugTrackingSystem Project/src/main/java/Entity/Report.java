package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Report {
	// All attributes of report entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportID;  //primary key field

	@ManyToOne
	@JoinColumn(name = "bugID",nullable=false)
	private Bug bug;
	
	//default constructor
	public Report() {
		super();
	}

	//parameterized constructor
	public Report(Bug bug) {
		super();
		this.bug = bug;
	}

	//getter and setter methods
	public int getReportID() {
		return reportID;
	}

	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	//toString() method
	@Override
	public String toString() {
		return "reportID=" + reportID + "| bug=" + bug ;
	}

}
