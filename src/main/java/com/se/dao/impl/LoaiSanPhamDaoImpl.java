package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.LoaiSanPhamDao;
import com.se.entity.LoaiSanPham;

@Repository
public class LoaiSanPhamDaoImpl implements LoaiSanPhamDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<LoaiSanPham> getDanhSachTenLoaiSanPham() {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			String sql = "select * from LoaiSanPham";
			List<LoaiSanPham> list = session.createNativeQuery(sql, LoaiSanPham.class).getResultList();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
