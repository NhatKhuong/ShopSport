package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.LoaiSanPhamDao;
import com.se.entity.LoaiSanPham;

@Repository
public class LoaiSanPhamDaoImpl implements LoaiSanPhamDao {

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


	@Override
	public List<LoaiSanPham> getAllLoaiSanPham() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from LoaiSanPham";
			List<LoaiSanPham> list = session.createNativeQuery(sql, LoaiSanPham.class).getResultList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMaLoaiSanPhamCuoiCung() {
		Session session = sessionFactory.getCurrentSession();
		String maLoaiSanPhamCuoi;
		try {
			String sql = "select top 1 maLoaiSanPham from LoaiSanPham order by maLoaiSanPham desc";
			maLoaiSanPhamCuoi = (String) session.createNativeQuery(sql).getSingleResult();
			return maLoaiSanPhamCuoi;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveLoaiSanPham(LoaiSanPham loaiSanPham) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(loaiSanPham);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public LoaiSanPham timLoaiSanPhambangTen(String tenLoaiSanPham) {
		System.out.println("Loai san pham:"+tenLoaiSanPham);
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from LoaiSanPham where tenLoaiSanPham like N'" + tenLoaiSanPham + "'";
			LoaiSanPham loaiSanPham = session.createNativeQuery(sql, LoaiSanPham.class).getSingleResult();
			return loaiSanPham;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

}
