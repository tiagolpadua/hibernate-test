package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Exemplo {

	public static void main(String[] args) {
		SessionFactory mFactory = null;
		Configuration cfg = new Configuration();
		cfg.addClass(org.example.Empregado.class);

		try {
			mFactory = cfg.configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Erro ao criar session factory." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Session session = mFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Empregado empregado1 = new Empregado("Joao", 10);
			Empregado empregado2 = new Empregado("Maria", 30);
			System.out.println((Integer) session.save(empregado1));
			System.out.println((Integer) session.save(empregado2));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
