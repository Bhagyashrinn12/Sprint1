package Dao;

import java.util.List;

import Entity.Bug;
import Entity.Report;

public interface ReportDao {
	//to get bug details to generate report
	 List<Bug> getBug(String status); 
}
