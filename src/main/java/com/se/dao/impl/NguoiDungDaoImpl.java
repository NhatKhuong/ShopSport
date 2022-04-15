package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.NguoiDungDao;
import com.se.entity.NguoiDung;

@Repository
public class NguoiDungDaoImpl implements NguoiDungDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(NguoiDung nguoiDung) {
		Session session = sessionFactory.getCurrentSession();
		try {	
			session.save(nguoiDung);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(NguoiDung nguoiDung) {
		Session session = sessionFactory.getCurrentSession();
		try {	
			session.update(nguoiDung);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public NguoiDung getById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			NguoiDung nguoiDung = session.get(NguoiDung.class, id);
			return nguoiDung;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public NguoiDung getByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			String sql = "select * from NguoiDung where email = '"+email+"'";
			NguoiDung nguoiDung = session.createNativeQuery(sql, NguoiDung.class).getSingleResult();
			return nguoiDung;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<NguoiDung> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from NguoiDung";
			List<NguoiDung> list = session.createNativeQuery(sql, NguoiDung.class).getResultList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
