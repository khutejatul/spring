package com.nagarro.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilities {

	private static SessionFactory sessionFactory;

	public static Session getSessionInstance() {
		try {
			if (sessionFactory == null) {
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory.openSession();
	}

}
