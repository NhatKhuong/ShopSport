package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.NguoiDungDao;
import com.se.entity.NguoiDung;

@Repository
public class NguoiDungDaoImpl implements NguoiDungDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(NguoiDung nguoiDung) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(nguoiDung);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void update(NguoiDung nguoiDung) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(nguoiDung);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public NguoiDung getById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {

			NguoiDung nguoiDung = session.get(NguoiDung.class, id);
			return nguoiDung;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public NguoiDung getByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "select * from NguoiDung where email = '" + email + "'";
			NguoiDung nguoiDung = session.createNativeQuery(sql, NguoiDung.class).getSingleResult();
			return nguoiDung;
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<NguoiDung> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from NguoiDung";
			List<NguoiDung> list = session.createNativeQuery(sql, NguoiDung.class).getResultList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<NguoiDung> getByFilter(String hoten, String diaChi) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "select * from NguoiDung join DiaChi on NguoiDung.maDiaChi=DiaChi.maDiaChi where NguoiDung.hoTen like N'%"
					+ hoten + "%' and DiaChi.tinhThanhPho like N'%" + diaChi + "%'";
			List<NguoiDung> list = session.createNativeQuery(sql, NguoiDung.class).getResultList();
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deletePerson(String theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		try {

			NguoiDung tempPerson = currentSession.get(NguoiDung.class, theId);
			if (tempPerson.isTrangThai())
				tempPerson.setTrangThai(false);
			else
				tempPerson.setTrangThai(true);
			currentSession.update(tempPerson);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public List<NguoiDung> getByName_Status(String hoTen, int trangThai) {
		// TODO Auto-generated method stub
		String sql = "";
		if (trangThai == 2)
			sql += "select * from NguoiDung where NguoiDung.hoTen like N'%" + hoTen + "%' ";
		else
			sql += "select * from NguoiDung where trangThai=" + trangThai + "and hoTen like N'%" + hoTen + "%'";
		Session session = sessionFactory.getCurrentSession();
		try {
			List<NguoiDung> list = session.createNativeQuery(sql, NguoiDung.class).getResultList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean capNhatNguoiDung(String maNguoiDung, String hoTen, String diaChiChiTiet, int gioiTinh, int trangThai,
			String matKhau) {
		Session session = sessionFactory.getCurrentSession();
		try {
			NguoiDung nguoiDung = session.find(NguoiDung.class, maNguoiDung);
			nguoiDung.setHoTen(hoTen);
			if (trangThai == 1)
				nguoiDung.setTrangThai(true);
			else
				nguoiDung.setTrangThai(false);
			nguoiDung.setDiaChiChiTiet(diaChiChiTiet);
			nguoiDung.setMatKhau(matKhau);
			if (gioiTinh == 1)
				nguoiDung.setGioiTinh(true);
			else
				nguoiDung.setGioiTinh(false);
			session.update(nguoiDung);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getMaNguoiDungCuoiCung() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String maNguoiDungCuoi;
		try {
			String sql = "select top 1 maNguoiDung from NguoiDung order by maNguoiDung desc";
			maNguoiDungCuoi = (String) session.createNativeQuery(sql).getSingleResult();
			return maNguoiDungCuoi;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
