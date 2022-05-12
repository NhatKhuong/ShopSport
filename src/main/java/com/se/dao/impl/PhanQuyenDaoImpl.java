package com.se.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.PhanQuyenDao;
import com.se.entity.NguoiDung;
import com.se.entity.PhanQuyen;
import com.se.entity.SanPham;

@Repository
public class PhanQuyenDaoImpl implements PhanQuyenDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(PhanQuyen phanQuyen) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(phanQuyen);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String maNguoiDung) {
		Session session = sessionFactory.getCurrentSession();
		try {
			NguoiDung nguoiDung = session.find(NguoiDung.class, maNguoiDung);

			session.delete(nguoiDung);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void update(String maNguoiDung) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(maNguoiDung);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
