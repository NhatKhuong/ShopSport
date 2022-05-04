package com.se.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.DonHangDao;
import com.se.entity.ChiTietDonHang;
import com.se.entity.DanhGia;
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
	public List<DonHang> layDanhSachDonHang(int page, int limit, String maTrangThai) {
		Session session = sessionFactory.getCurrentSession();
		int numStart = (page-1)*limit;
		if(maTrangThai == null) maTrangThai ="";
		try {
			String sql = "select * from DonHang where maTrangThaiDonHang like '%"+maTrangThai+"%' order by ngayTao desc offset "+numStart+" rows  fetch next "+limit+" rows only";
			Query<DonHang> query =  session.createNativeQuery(sql, DonHang.class);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ArrayList<DonHang>();
	}

	@Override
	public int layTongDonHangTheoTrangThai(String maTrangThai) {
		Session session = sessionFactory.getCurrentSession();
		try {
			if(maTrangThai == null) maTrangThai = "";
			String sql = "select count(*) from donHang where maTrangThaiDonHang like :maTrangThai ";
			Query query =  session.createNativeQuery(sql);
			query.setParameter("maTrangThai", "%" + maTrangThai + "%" );
//			System.err.println(query.getFirstResult());
			return (int) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
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
