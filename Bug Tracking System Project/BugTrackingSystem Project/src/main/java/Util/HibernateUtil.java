package Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Bug;
import Entity.Developer;
import Entity.Project;
import Entity.Report;
import Entity.Tester;

public class HibernateUtil {
	//object creation of SessionFactory to build the session
	private final static SessionFactory sessionFactory=buildSessionFactory();
	
	//method to build the session factory
	private static SessionFactory buildSessionFactory()
	{

		try {
			//returning configure object by configuring hibernate config file and by adding the all entity classes to build the the session factory
			return new Configuration().configure("Hibernate.cfg.xml").addAnnotatedClass(Project.class).addAnnotatedClass(Developer.class)
					.addAnnotatedClass(Tester.class).addAnnotatedClass(Bug.class)
					.addAnnotatedClass(Report.class).buildSessionFactory();

		}catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession()
	{
		return getSessionFactory().openSession(); //session opened
	}

}
