package com.se.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbtractEntityDaoImpl<T>{
	private Class<T> entityClass;
	
	@Autowired
	private SessionFactory sessionFactory; 

	public AbtractEntityDaoImpl(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
	}
	
	public void them(T entity) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	
	
	

}
