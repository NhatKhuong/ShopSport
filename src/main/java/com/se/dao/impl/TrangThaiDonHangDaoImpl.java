package com.se.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.TrangThaiDonHangDao;
import com.se.entity.TrangThaiDonHang;
@Repository
public class TrangThaiDonHangDaoImpl implements TrangThaiDonHangDao {
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<TrangThaiDonHang> layDanhSachTrangThaiDonHang() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.createNativeQuery("select * from trangThaiDonHang",TrangThaiDonHang.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<TrangThaiDonHang>();
	}

}
