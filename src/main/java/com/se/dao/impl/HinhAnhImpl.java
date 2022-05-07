package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.HinhAnhDao;
import com.se.entity.DanhGia;
import com.se.entity.HinhAnhSanPham;
import com.se.entity.NguoiDung;
import com.se.entity.SanPham;
import com.se.util.RenerateId;

@Repository
public class HinhAnhImpl implements HinhAnhDao{

	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public boolean themHinhAnhSanPham(HinhAnhSanPham hinhAnhSanPham) {
		hinhAnhSanPham.setMaHinhAnh(getId());
		Session session = sessionFactory.getCurrentSession();
		try {	
			System.out.println(hinhAnhSanPham);
			session.saveOrUpdate(hinhAnhSanPham);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean xoaHinhAnhSanPham(String hinhAnh) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
				Query q = session.createQuery("delete HinhAnhSanPham where hinhAnh = :hinhAnh");
				q.setParameter("hinhAnh", hinhAnh);
				q.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select max(maHinhAnh) from hinhAnhSanPham";
			String id = (String) session.createNativeQuery(sql).getSingleResult();
			if (id == null) {
				id = "HAAA00001";
			}
			return "HA" + RenerateId.fomatAANumber(id.substring(2));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return null;
	}
	

}
