package com.se.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.se.dao.DiaChiDao;
import com.se.entity.ChiTietSanPham;
import com.se.entity.DiaChi;

public class DiaChiDaoImpl implements DiaChiDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<DiaChi> getDanhSachDiaChi() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from DiaChi";
			 List<DiaChi>  danhSachDiaChi= session.createNativeQuery(sql, DiaChi.class).getResultList();
			return danhSachDiaChi;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> getDanhSachTinhThanhPho() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select distinct tinhThanhPho from DiaChi";
			 List<String>  danhSachTinh= session.createNativeQuery(sql, String.class).getResultList();
			return danhSachTinh;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> getDanhSachQuanHuyenTheoTinh(String thanhPho) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		 List<String>  danhSachTinh = null ;
		try {
			String sql = "select quanHuyen  from DiaChi where tinhThanhPho = :tinhThanhPho";
			Query query = session.createQuery(sql);
			   query.setParameter("tinhThanhPho",thanhPho);
			   danhSachTinh= query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachTinh;
	}

	@Override
	public List<String> getDanhSachPhuongXaTheoQuanHuyenVaTinh(String quanHuyen, String tinhThanhPho) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		 List<String>  danhSachquanHuyen= null ;
		try {
			String sql = "select PhuongXa  from DiaChi where tinhThanhPho = :tinhThanhPho and quanHuyen = :quanHuyen";
			Query query = session.createQuery(sql);
			   query.setParameter("tinhThanhPho",tinhThanhPho);
			   query.setParameter("quanHuyen",quanHuyen);
			   danhSachquanHuyen= query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachquanHuyen;
	}

}
