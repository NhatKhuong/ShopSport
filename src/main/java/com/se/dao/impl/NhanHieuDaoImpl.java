package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.NhanHieuDao;
import com.se.entity.NhanHieu;

@Repository
public class NhanHieuDaoImpl implements NhanHieuDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<NhanHieu> getDanhSachThuongHieu() {
		Session session = sessionFactory.getCurrentSession();
		try {			
			String sql = "select * from NhanHieu";
			List<NhanHieu> list = session.createNativeQuery(sql,NhanHieu.class).getResultList();
			return list;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
