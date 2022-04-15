package com.se.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.CustomerDao;
import com.se.entity.Customer;
import com.se.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	@Override
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}

}
