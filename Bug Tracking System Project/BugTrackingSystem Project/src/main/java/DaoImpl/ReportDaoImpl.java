package DaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Dao.ReportDao;
import Entity.Bug;
import Entity.Developer;
import Entity.Project;
import Entity.Report;
import Entity.Tester;
import Util.HibernateUtil;

public class ReportDaoImpl implements ReportDao {

    //to get bug details to generate report
	@Override
	public List<Bug> getBug(String status) {
		// TODO Auto-generated method stub
		//session object creation to start the session
		try(Session session=HibernateUtil.getSession()) {
             //writing hql query to retrieve all bug details of specific status
			 List<Bug> bugs = session.createQuery("FROM Bug WHERE status = :status", Bug.class)
                     .setParameter("status", status)
                     .getResultList();
			
			return bugs;
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

	


