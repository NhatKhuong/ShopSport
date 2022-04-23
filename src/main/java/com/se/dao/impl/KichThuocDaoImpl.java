package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.KichThuocDao;
import com.se.entity.KichThuoc;

@Repository
public class KichThuocDaoImpl implements KichThuocDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<String> getDsKichThuocTheoMaSanPham(String maSp) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			String sql = "select DISTINCT tenKichThuoc from ChiTietSanPham join KichThuoc on ChiTietSanPham.maKichThuoc = KichThuoc.maKichThuoc where maSanPham = '"+maSp+"'";
			List<String> list = session.createNativeQuery(sql).getResultList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public KichThuoc getKichThuocTheoTenKichThuoc(String tenKichThuoc) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			String sql = "select * from KichThuoc where tenKichThuoc = '"+tenKichThuoc+"'";
			KichThuoc kichThuoc = session.createNativeQuery(sql,KichThuoc.class).getSingleResult();
			return kichThuoc;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
