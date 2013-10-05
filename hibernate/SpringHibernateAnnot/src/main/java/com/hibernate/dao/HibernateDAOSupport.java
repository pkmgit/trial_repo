package com.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateDAOSupport {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		return HibernateDAOSupport.sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		HibernateDAOSupport.sessionFactory = sessionFactory;
	}

	public HibernateDAOSupport() {
		super();
	}

	protected HibernateTemplate getHibernateTemplate() {
		return new org.springframework.orm.hibernate3.HibernateTemplate(getSessionFactory());
	}
	
	
}