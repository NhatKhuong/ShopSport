package com.se.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.se.dao.NhanHieuDao;
import com.se.entity.NhanHieu;

@Repository
public class NhanHieuDaoImpl implements NhanHieuDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<NhanHieu> getAllNhanHieu() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from NhanHieu";
			List<NhanHieu> list = session.createNativeQuery(sql, NhanHieu.class).getResultList();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getMaCuoiNhanHieu() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String maSanPhamCuoi;
		try {
			String sql = "select top 1 maNhanHieu from NhanHieu order by maNhanHieu desc";
			maSanPhamCuoi = (String) session.createNativeQuery(sql).getSingleResult();
			return maSanPhamCuoi;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveNhanHieu(NhanHieu nhanHieu) {
		// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession();
				try {	
					session.save(nhanHieu);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
	}

	@Override
	public NhanHieu timNhanHieuBangTen(String tenNhanHieu) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select * from NhanHieu where tenNhanHieu LIKE N'"+tenNhanHieu+"'";
			NhanHieu nhanHieu = session.createNativeQuery(sql, NhanHieu.class).getSingleResult();
			return nhanHieu;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
