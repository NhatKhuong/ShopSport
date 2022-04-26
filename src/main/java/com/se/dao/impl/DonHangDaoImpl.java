package com.se.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.DonHangDao;
import com.se.entity.DonHang;
import com.se.util.RenerateId;

@Repository
public class DonHangDaoImpl implements DonHangDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql ="select max(maDonHang) from donHang ";
			String id = (String) session.createNativeQuery(sql).getSingleResult();
			return "DH"+ RenerateId.fomatAANumber(id.substring(2));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public boolean themHoaDon(DonHang donHang) {
		// TODO Auto-generated method stub
		String id = getId();
		System.out.println("id : "+id);
		donHang.setMaDonHang(id);
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(donHang);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return false;
	}

}
