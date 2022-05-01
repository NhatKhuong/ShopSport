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

	@Override
	public List<MonTheThao> getAllMTT() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "Select * from MonTheThao";
			List<MonTheThao> list = session.createNativeQuery(sql, MonTheThao.class).getResultList();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getMaMTTCuoi() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String maMTTCuoi;
		try {
			String sql = "select top 1 maMonTheThao from MonTheThao order by maMonTheThao desc";
			maMTTCuoi = (String) session.createNativeQuery(sql).getSingleResult();
			return maMTTCuoi;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveMTT(MonTheThao monTheThao) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {	
			session.save(monTheThao);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	@Override
	public MonTheThao timMonTheThaoBangTen(String tenMonTheThao) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from MonTheThao where tenMonTheThao LIKE N'"+tenMonTheThao+"'";
			MonTheThao monTheThao = session.createNativeQuery(sql, MonTheThao.class).getSingleResult();
			return monTheThao;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}


}
