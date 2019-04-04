package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Example {

	public static void main(String[] args) {
		SessionFactory mFactory = null;
		Configuration cfg=new Configuration(); 
		cfg.addClass(org.example.Employee.class);
		
		try {
			mFactory = cfg.configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Couldn't create session factory." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Session session = mFactory.openSession();
		Transaction tx = null;
		Long employeeID = null;
		try {
			tx = session.beginTransaction();
			Employee employee = new Employee("foo");
			employeeID = (Long) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("employeeID: " + employeeID);

	}

}
