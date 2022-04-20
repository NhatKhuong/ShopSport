package com.se.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.ChiTietSanPhamDao;
import com.se.entity.ChiTietSanPham;

@Repository
public class ChiTietSanPhamDaoImpl implements ChiTietSanPhamDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ChiTietSanPham getChiTietSanPhamByMaSanPham_maKichThuoc(String maSanPham, String maKichThuoc) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from ChiTietSanPham join SanPham on ChiTietSanPham.maSanPham = SanPham.maSanPham where maKichThuoc = '"+maKichThuoc+"' and SanPham.maSanPham = '"+maSanPham+"'";
			ChiTietSanPham chiTietSanPham = session.createNativeQuery(sql, ChiTietSanPham.class).getSingleResult();
			return chiTietSanPham;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
