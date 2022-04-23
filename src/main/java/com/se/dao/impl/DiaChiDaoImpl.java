package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.DiaChiDao;

@Repository
public class DiaChiDaoImpl implements DiaChiDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<String> getDanhSachTinhThanhPho() {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			String sql = "select distinct tinhThanhPho from DiaChi";
			List<String> list = session.createNativeQuery(sql).getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
		
	}

}
