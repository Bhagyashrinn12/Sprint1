package DaoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Dao.BugDao;
import Entity.Bug;
import Entity.Developer;
import Entity.Project;
import Entity.Tester;
import Util.HibernateUtil;

public class BugDaoImpl implements BugDao {
	Scanner sc=new Scanner(System.in);//Scanner object creation

	//to add bug details
	@Override
	public Bug addBug(Bug bug) {
		// TODO Auto-generated method stub
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(bug);  //storing bug details in the database
			session.getTransaction().commit();
			return bug;
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

	//to get all bug details
	@Override
	public List<Bug> getAllBugs() {
		// TODO Auto-generated method stub
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()){
			Query<Bug> query=session.createQuery("FROM Bug");  //writing hql query to retrieve bug details
			List<Bug> bugList=query.list();  //retrieving bug details from the database
			return bugList;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	//to get bug details by bug id
	@Override
	public Bug getBug(int bugID) {
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()) {

			Bug bug=session.get(Bug.class, bugID); //retrieving bug details of specific bug id
			return bug;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}


	//to delete bug details
	@Override
	public String deleteBug(int bugID) {
		// TODO Auto-generated method stub
		String message=null;
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()){
			Bug bug=session.get(Bug.class, bugID);
			session.beginTransaction();
			System.out.println("Are you sure want to delete?");
			String status=sc.next();
			if(status.equalsIgnoreCase("yes")) {
				session.delete(bug);  //deleting bug details from the database
				session.getTransaction().commit();
				session.evict(bug);
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

	//to update bug details
	@Override
	public Bug updateBug(int bugID,Bug updatedBug) {
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()) {
			Bug bug=session.get(Bug.class, bugID);
			session.beginTransaction();
            //updating the bug details by using getter and setter methods
			bug.setTitle(updatedBug.getTitle());
			bug.setDescription(updatedBug.getDescription());
			bug.setStatus(updatedBug.getStatus());
			bug.setCompletionPercent(updatedBug.getCompletionPercent());
			bug.setDeadline(updatedBug.getDeadline());
			bug.setDeveloper(updatedBug.getDeveloper());
			bug.setTester(updatedBug.getTester());
			bug.setProject(updatedBug.getProject());
	
			session.saveOrUpdate(bug); //updating bug details in the database
			session.getTransaction().commit();
			return bug;

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

	//to get developer details by developer id
	@Override
	public Developer getDevepoer(int devID) {
		// TODO Auto-generated method stub
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

	//to get tester details by tester id
	@Override
	public Tester getTester(int testID) {
		// TODO Auto-generated method stub
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()) {
			//retrieving tester details of specific tester id
			Tester tester=session.get(Tester.class,testID);
			return tester;
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
