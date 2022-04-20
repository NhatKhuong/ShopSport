package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.SanPhamDao;
import com.se.entity.SanPham;

@Repository
public class SanPhamDaoImpl implements SanPhamDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		try {	
			session.save(sanPham);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String masSanPham) {
		Session session = sessionFactory.getCurrentSession();
		try {
			SanPham sanPham = session.find(SanPham.class, masSanPham);
			session.delete(sanPham);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(SanPham sanPham) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(sanPham);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public SanPham getById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			SanPham sanPham = session.find(SanPham.class, id);
			return sanPham;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SanPham> getAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			String sql = "select * from SanPham";
			List<SanPham> list = session.createNativeQuery(sql, SanPham.class).getResultList();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SanPham> getByFilter(String tenLoai, String tenMon, String tenThuongHieu, double fromPrice,
			double toPrice, int numPage, int limit) {
		int numStart = (numPage-1)*limit;
		Session session = sessionFactory.getCurrentSession();
		try {
			
			String sql = "select SanPham.maSanPham, SanPham.chietKhau, SanPham.giaTien , SanPham.mieuTa, SanPham.tenSanPham,  SanPham.maLoaiSanPham, SanPham.maMonTheThao, SanPham.maNhanHieu  from SanPham join LoaiSanPham on SanPham.maLoaiSanPham = LoaiSanPham.maLoaiSanPham\r\n"
					+ "						join MonTheThao on SanPham.maMonTheThao = MonTheThao.maMonTheThao \r\n"
					+ "						join NhanHieu on SanPham.maNhanHieu = NhanHieu.maNhanHieu\r\n"
					+ "						join ChiTietSanPham on SanPham.maSanPham = ChiTietSanPham.maSanPham\r\n"
					+ "						where LoaiSanPham.tenLoaiSanPham like N'%"+tenLoai+"%' and NhanHieu.tenNhanHieu like N'%"+tenThuongHieu+"%' and MonTheThao.tenMonTheThao like N'%"+tenMon+"%' and (SanPham.giaTien >="+fromPrice+" and SanPham.giaTien<="+toPrice+") 	group by SanPham.maSanPham, SanPham.chietKhau, SanPham.giaTien , SanPham.mieuTa, SanPham.tenSanPham,  SanPham.maLoaiSanPham, SanPham.maMonTheThao, SanPham.maNhanHieu  order by SanPham.maSanPham offset "+numPage+" rows  fetch next "+limit+" rows only";
			List<SanPham> list = session.createNativeQuery(sql, SanPham.class).getResultList();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
