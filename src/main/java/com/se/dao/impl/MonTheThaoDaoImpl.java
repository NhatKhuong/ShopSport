package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.MonTheThaoDao;
import com.se.entity.MonTheThao;

@Repository
public class MonTheThaoDaoImpl implements MonTheThaoDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MonTheThao> getDanhSachTenMonTheThao() {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			String sql = "select * from MonTheThao";
			List<MonTheThao> list = session.createNativeQuery(sql,MonTheThao.class).getResultList();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
