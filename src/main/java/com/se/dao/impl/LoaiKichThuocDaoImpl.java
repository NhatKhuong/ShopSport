package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.LoaiKichThuocDao;
import com.se.entity.LoaiKichThuoc;
import com.se.entity.SanPham;

@Repository
public class LoaiKichThuocDaoImpl implements LoaiKichThuocDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<LoaiKichThuoc> listLoaiKichThuoc() {
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "select * from LoaiKichThuoc";
			List<LoaiKichThuoc> list = session.createNativeQuery(sql, LoaiKichThuoc.class).getResultList();
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public LoaiKichThuoc getKichThuocTheoTen(String tenLoai) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "select * from LoaiKichThuoc\r\n"
					+ "where tenLoaiKichThuoc =  N'"+tenLoai+"'";
			LoaiKichThuoc loaiKichThuoc = session.createNativeQuery(sql, LoaiKichThuoc.class).getSingleResult();
			return loaiKichThuoc;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
