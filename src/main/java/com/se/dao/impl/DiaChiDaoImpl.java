package com.se.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.DiaChiDao;
import com.se.entity.ChiTietSanPham;
import com.se.entity.DiaChi;

@Repository
public class DiaChiDaoImpl implements DiaChiDao {

	@Autowired
	private SessionFactory sessionFactory ;
	
	@Override
	public List<DiaChi> getDanhSachDiaChi() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from diaChi  ";
			List<DiaChi> danhSachDiaChi= session.createNativeQuery(sql, DiaChi.class).getResultList();
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
			 Query query = session.createQuery(sql);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> getDanhSachQuanHuyenTheoTinh(String thanhPho) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select distinct quanHuyen from  Diachi where tinhThanhPho = :tinhThanhPho";
			 Query query = session.createNativeQuery(sql);
			 query.setParameter("tinhThanhPho",thanhPho);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> getDanhSachPhuongXaTheoQuanHuyenVaTinh(String quanHuyen, String tinhThanhPho) {
		// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession();
				try {
					String sql = "select phuongXa from  Diachi where tinhThanhPho = :tinhThanhPho and quanHuyen = :quanHuyen";
					 Query query = session.createNativeQuery(sql);
					 query.setParameter("tinhThanhPho",tinhThanhPho);
					 query.setParameter("quanHuyen",quanHuyen);
					return query.getResultList();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
	}
	
}
