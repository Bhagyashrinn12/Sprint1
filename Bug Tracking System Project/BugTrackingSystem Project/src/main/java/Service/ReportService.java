package Service;

import java.util.List;

import Entity.Bug;
import Entity.Report;

public interface ReportService {
	//to get bug details to generate report
	 List<Bug> getBug(String status);
	 	
}
