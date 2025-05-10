package DaoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Dao.DeveloperDao;
import Entity.Developer;
import Entity.Project;
import Util.HibernateUtil;

public class DeveloperDaoImpl implements DeveloperDao{
	Scanner sc=new Scanner(System.in);//Scanner object creation

	//to add developer details
	@Override
	public Developer addDeveloper(Developer developer) {
		// TODO Auto-generated method stub
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			//storing developer details in the database
			session.save(developer);
			session.getTransaction().commit();
			return developer;
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

	//to display all developer details
	@Override
	public List<Developer> getAllDevelopers() {
		// TODO Auto-generated method stub
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()){
			//writing hql query to retrieve developer details
			Query<Developer> query=session.createQuery("FROM Developer");
			List<Developer> developerList=query.list();//retrieving bug details from the database
			return developerList;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	//to get developer details by developer id
	@Override
	public Developer getDeveloper(int devID) {
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()) {
			//retrieving developer details of specific developer id
			Developer developer=session.get(Developer.class, devID);
			return developer;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}


	//to delete developer details
	@Override
	public String deleteDeveloper(int devID) {
		// TODO Auto-generated method stub
		String message=null;
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()){
			Developer developer=session.get(Developer.class, devID);
			session.beginTransaction();
			System.out.println("Are you sure want to delete?");
			String status=sc.next();
			if(status.equalsIgnoreCase("yes")) {
				session.delete(developer); //deleting developer details from the database
				session.getTransaction().commit();
				session.evict(developer);
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
			System.out.println("User not available");
		}
		return message;
	}

	//to update developer details
	@Override
	public Developer updateDeveloper(int devID,Developer updatedDeveloper) {
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()) {
			//retrieving developer details of specific developer id
			Developer developer=session.get(Developer.class, devID);
			session.beginTransaction();
			//updating developer details by using getter and setter methods in the database
			developer.setFirstName(updatedDeveloper.getFirstName());
			developer.setLastName(updatedDeveloper.getLastName());
			developer.setEmail(updatedDeveloper.getEmail());
			developer.setContactNo(updatedDeveloper.getContactNo());			
			developer.setProject(updatedDeveloper.getProject());
			
			session.saveOrUpdate(developer); //updating developer details in database
			session.getTransaction().commit();
			return developer;

		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	//to get project details by project id
	@Override
	public Project getProject(int projectID) {
		// TODO Auto-generated method stub
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()) {
            //retrieving project details of specific project id
			Project project=session.get(Project.class, projectID);
			return project;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}	

}
