package com.se.dao.impl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
			session.saveOrUpdate(danhGia);
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
	public int soLuongDanhGiaTheoMaSanPham( String maSanPham) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
 
		try {
			String sql = "select count(*) from DanhGia where maSanPham = :maSanPham ";
			
			Query query =  session.createNativeQuery(sql);
			query.setParameter("maSanPham", maSanPham);
//			System.err.println(query.getFirstResult());
			return (int) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<DanhGia> layDanhSachDanhGiaTheoMaSanPham(int page, int limit, String maSanPham) {
//		System.err.println(maSanPham);
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		int numStart = (page-1)*limit;
		try {
			
			String sql = "select * from DanhGia where maSanPham = :maSanPham order by thoiGian desc offset "+numStart+" rows  fetch next "+limit+" rows only";
			Query<DanhGia> query =  session.createNativeQuery(sql, DanhGia.class);
			query.setParameter("maSanPham", maSanPham);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ArrayList<DanhGia>();
	}

	@Override
	public DanhGia layDanhGiaTheoMaSanPhamVaMaNguoiDung( String maSanPham, String maNguoiDung) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from DanhGia where maSanPham = :maSanPham  and maNguoiDung = :maNguoiDung";
			Query<DanhGia> query =  session.createNativeQuery(sql, DanhGia.class);
			query.setParameter("maSanPham", maSanPham);
			query.setParameter("maNguoiDung", maNguoiDung);
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
		return null;
	}

}
