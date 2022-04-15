package com.se.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.CustomerDao;
import com.se.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Customer.class, id);
	}

}
