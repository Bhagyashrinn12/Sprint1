package DaoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Dao.TesterDao;
import Entity.Developer;
import Entity.Project;
import Entity.Tester;
import Util.HibernateUtil;

public class TesterDaoImpl implements TesterDao {
	
	Scanner sc=new Scanner(System.in);//Scanner object creation

	//to add tester details
	@Override
	public Tester addTester(Tester tester) {
		// TODO Auto-generated method stub
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(tester);//storing tester details in the database
			session.getTransaction().commit();
			return tester;
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

	//to display all tester details
	@Override
	public List<Tester> getAllTesters() {
		// TODO Auto-generated method stub
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()){
			//writing hql query to retrieve tester details
			Query<Tester> query=session.createQuery("FROM Tester");
			
			//storing tester details from the database into the list
			List<Tester> testerList=query.list();
			return testerList;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	//to get tester details by tester id
	@Override
	public Tester getTester(int testID) {
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()) {
            //retrieving tester details of specific tester id
			Tester tester=session.get(Tester.class, testID);
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

    //to delete tester details
	@Override
	public String deleteTester(int testID) {
		// TODO Auto-generated method stub
		String message=null;
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()){
			//retrieving tester details of specific tester id
			Tester tester=session.get(Tester.class, testID);
			session.beginTransaction();
			System.out.println("Are you sure want to delete?");
			String status=sc.next();
			if(status.equalsIgnoreCase("yes")) {
				session.delete(tester);  //deleting tester details from the database
				session.getTransaction().commit();
				session.evict(tester);
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

	//to update tester details
	@Override
	public Tester updateTester(int testID,Tester updatedTester) {
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()) {
			Tester tester=session.get(Tester.class, testID);
			session.beginTransaction();
			//updating tester details by using getter and setter methods
			tester.setFirstName(updatedTester.getFirstName());
			tester.setLastName(updatedTester.getLastName());
			tester.setEmail(updatedTester.getEmail());
			tester.setContactNo(updatedTester.getContactNo());
			tester.setProject(updatedTester.getProject());
			
			//updating tester details in the database
			session.saveOrUpdate(tester);
			session.getTransaction().commit();
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
