package com.se.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.DonHangDao;
import com.se.entity.ChiTietDonHang;
import com.se.entity.DonHang;
import com.se.util.RenerateId;

@Repository
public class DonHangDaoImpl implements DonHangDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql ="select max(maDonHang) from donHang ";
			String id = (String) session.createNativeQuery(sql).getSingleResult();
			if(id == null) {
				id= "DHAA00001";
			}
			return "DH"+ RenerateId.fomatAANumber(id.substring(2));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public boolean themHoaDon(DonHang donHang) {
		// TODO Auto-generated method stub
		String id = getId();
		donHang.setMaDonHang(id);
		Session session = sessionFactory.getCurrentSession();
		try {
			session.persist(donHang);
			int length = donHang.getDanhSachChiTietDonHang().size();
			for (int i = 0; i < length; i++) {
				donHang.getDanhSachChiTietDonHang().get(i).setDonHang(new DonHang(donHang.getMaDonHang()));
				session.save(donHang.getDanhSachChiTietDonHang().get(i));
			}
	
		
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public List<DonHang> getDanhSachDonHang() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from DonHang";
			List<DonHang> list = session.createNativeQuery(sql,DonHang.class).getResultList();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DonHang> getDanhSachDonHangTheoTrangThai(String maTrangThai, String maNguoiDung, String tenNguoiDung) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from DonHang join NguoiDung on DonHang.maNguoiDung = NguoiDung.maNguoiDung where maTrangThaiDonHang like '%"+maTrangThai+"%' and NguoiDung.maNguoiDung like '%"+maNguoiDung+"%' and NguoiDung.hoTen like N'%"+tenNguoiDung+"%'";
			List<DonHang> list = session.createNativeQuery(sql,DonHang.class).getResultList();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public double tinhTongTien(String maHoaDon) {
		Session session = sessionFactory.getCurrentSession();
		try {			
			DonHang donHang = session.get(DonHang.class, maHoaDon);
			return donHang.tongTienDonHang();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void update(DonHang donHang) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			session.update(donHang);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public DonHang getDonHangById(String maDonHang) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			DonHang donHang = session.get(DonHang.class, maDonHang);
			return donHang;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
