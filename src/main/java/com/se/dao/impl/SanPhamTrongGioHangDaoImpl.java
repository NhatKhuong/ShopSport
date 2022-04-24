package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.SanPhamTrongGioHangDao;
import com.se.entity.SanPhamTrongGioHang;

@Repository
public class SanPhamTrongGioHangDaoImpl implements SanPhamTrongGioHangDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(SanPhamTrongGioHangDao sanPhamTrongGioHang) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(sanPhamTrongGioHang);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String maChiTietSan) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(SanPhamTrongGioHangDao sanPhamTrongGioHang) {

	}

	@Override
	public List<SanPhamTrongGioHang> getDSSanPhamTrongGioHangTheoMaNguoiDung(String maNguoiDung) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from SanPhamTrongGioHang where maNguoiDung = '" + maNguoiDung + "'";
			List<SanPhamTrongGioHang> list = session.createNativeQuery(sql, SanPhamTrongGioHang.class).getResultList();
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
