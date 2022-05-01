package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.DanhGiaDao;
import com.se.entity.DanhGia;
import com.se.entity.NguoiDung;
import com.se.entity.SanPham;

@Repository
public class DanhGiaDaoImpl implements DanhGiaDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean themDanhGia(DanhGia danhGia) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {	
			System.out.println(danhGia);
			session.save(danhGia);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean suaDanhGia(DanhGia danhGia) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(danhGia);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean xoaDanhGia(String maNguoiDung, String maSanPham) {
		Session session = sessionFactory.getCurrentSession();
		try {
				session.delete(new DanhGia(new SanPham( maSanPham),new NguoiDung(maNguoiDung)));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<DanhGia> layDanhSachDanhGia(int page, int limit) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<DanhGia> danhSachDanhGia = null;
		int numStart = (page-1)*limit;
		try {
			
			String sql = "select * from DanhGia order by DanhGia.thoiGian offset "+numStart+" rows  fetch next "+limit+" rows only";
			danhSachDanhGia = session.createNativeQuery(sql, DanhGia.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return danhSachDanhGia;
	}

}
