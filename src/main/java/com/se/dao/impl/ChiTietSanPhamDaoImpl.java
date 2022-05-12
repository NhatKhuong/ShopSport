package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.ChiTietSanPhamDao;
import com.se.entity.ChiTietSanPham;
import com.se.entity.SanPham;

@Repository
public class ChiTietSanPhamDaoImpl implements ChiTietSanPhamDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ChiTietSanPham getChiTietSanPhamByMaSanPhamMaKichThuoc(String maSanPham, String maKichThuoc) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from ChiTietSanPham join SanPham on ChiTietSanPham.maSanPham = SanPham.maSanPham where maKichThuoc = '"
					+ maKichThuoc + "' and SanPham.maSanPham = '" + maSanPham + "'";
			ChiTietSanPham chiTietSanPham = session.createNativeQuery(sql, ChiTietSanPham.class).getSingleResult();
			return chiTietSanPham;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ChiTietSanPham> getDanhSachChiTietSanPhamTheoMa(String ma) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from ChiTietSanPham where maSanPham='" + ma + "' ";
			List<ChiTietSanPham> listSanPham = session.createNativeQuery(sql, ChiTietSanPham.class).getResultList();
			return listSanPham;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(ChiTietSanPham chiTietSanPham) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(chiTietSanPham);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void add(ChiTietSanPham chiTietSanPham) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(chiTietSanPham);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public boolean giamSoLuongTonChiTietSanPhamTheoMa(String maChiTietSanPham, int soLuong) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "update ChiTietSanPham set soLuongTon = soLuongTon - 1  where maChiTietSanPham = :maChiTietSanPham ";
			Query query = session.createNativeQuery(sql);
			query.setParameter("maChiTietSanPham", maChiTietSanPham);
			if (query.executeUpdate() != 0)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getMaChiTietSanPhamCuoiCung() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String maNguoiDungCuoi;
		try {
			String sql = "select top 1 maChiTietSanPham from ChiTietSanPham order by maChiTietSanPham desc";
			String maChiTietSanPhamCuoi = (String) session.createNativeQuery(sql).getSingleResult();
			return maChiTietSanPhamCuoi;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
