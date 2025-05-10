package DaoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Dao.ProjectDao;
import Entity.Project;
import Util.HibernateUtil;

public class ProjectDaoImpl implements ProjectDao {
	Scanner sc=new Scanner(System.in);//Scanner object creation

	//to add project details
	@Override
	public Project addProject(Project project) {
		// TODO Auto-generated method stub
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(project); //storing project details in the database
			session.getTransaction().commit();
			return project;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
		
	}

	//to display all project details
	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()){
			//writing hql query to retrieve project details
			Query<Project> query=session.createQuery("FROM Project");
			
			//retrieving all project details from the database
			List<Project> projectList=query.list();
			return projectList;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	//to delete project details
	@Override
	public String deleteProject(int projectID) {
		// TODO Auto-generated method stub
		String message=null;
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()){
			Project project=session.get(Project.class, projectID);
			session.beginTransaction();
			System.out.println("Are you sure want to delete?");
			String status=sc.next();
			if(status.equalsIgnoreCase("yes")) {
				session.delete(project); //deleting project details from the database
				session.getTransaction().commit();
				session.evict(project);
				message="Object is deleted";
			}
			else {
				message="User wants to retain this object!";
			}
			}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return message;
		
	}

}
