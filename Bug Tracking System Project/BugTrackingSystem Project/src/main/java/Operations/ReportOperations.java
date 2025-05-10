package Operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.anudip.BugTrackingSystem1.App;

import Entity.Bug;
import Entity.Developer;
import Entity.Report;
import ServiceImpl.ReportServiceImpl;
import Util.HibernateUtil;

public class ReportOperations {
	//object creation of ReportServiceImpl
	static ReportServiceImpl reportService=new ReportServiceImpl();
	
	//Scanner object creation
	static Scanner sc=new Scanner(System.in);

	//to display the report operations
	public static void reportOperations() {
		while(true) {
			System.out.println("Press 1. Get report for specific bug  \nPress 2. To getback to the main menu");
			System.out.println("Enter choice: ");
			int input=sc.nextInt();
			switch(input) {
			case 1:
				sc.nextLine();
				try(Session session=HibernateUtil.getSession()) {
					System.out.println("Enter bug status: ");
					String status=sc.nextLine();
					List<Bug> bugs=reportService.getBug(status);		
					if(bugs!=null) {
						for(Bug bug:bugs) {

							Report report=new Report(bug);
							session.save(report);
							System.out.print("Report ID: "+report.getReportID()+" | ");
							System.out.print("Bug ID: "+report.getBug().getBugID()+" | ");
							System.out.print("Project ID: "+report.getBug().getProject()+" | ");
							System.out.print("Status: "+report.getBug().getStatus()+" | ");
							if(report.getBug().getStatus().equals("in progress")) {
								System.out.print("Completion Percentage: "+report.getBug().getCompletionPercent()+" | ");
							}
							System.out.print("Deadline: "+report.getBug().getDeadline()+" | ");
							System.out.println();

						}
						
					}
				}

				catch(Exception e) {
					System.out.println(e);

				}

				break;

			case 2:App.mainOps();
			break;
			default:
				System.out.println("Invalid Input");
			}
		}
	}

}
