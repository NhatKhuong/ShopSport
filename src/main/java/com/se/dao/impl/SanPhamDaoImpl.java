package com.se.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.SanPhamDao;
import com.se.entity.ChiTietSanPham;
import com.se.entity.SanPham;

@Repository
public class SanPhamDaoImpl implements SanPhamDao {

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
		int numStart = (numPage - 1) * limit;
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "select SanPham.maSanPham, SanPham.chietKhau, sanPham.trangThai,SanPham.giaTien , SanPham.mieuTa, SanPham.tenSanPham,  SanPham.maLoaiSanPham, SanPham.maMonTheThao, SanPham.maNhanHieu  from SanPham join LoaiSanPham on SanPham.maLoaiSanPham = LoaiSanPham.maLoaiSanPham\r\n"
					+ "						join MonTheThao on SanPham.maMonTheThao = MonTheThao.maMonTheThao \r\n"
					+ "						join NhanHieu on SanPham.maNhanHieu = NhanHieu.maNhanHieu\r\n"
					+ "						join ChiTietSanPham on SanPham.maSanPham = ChiTietSanPham.maSanPham\r\n"
					+ "						where LoaiSanPham.tenLoaiSanPham like N'%" + tenLoai
					+ "%' and NhanHieu.tenNhanHieu like N'%" + tenThuongHieu
					+ "%' and MonTheThao.tenMonTheThao like N'%" + tenMon + "%' and (SanPham.giaTien >=" + fromPrice
					+ " and SanPham.giaTien<=" + toPrice
					+ ") 	group by SanPham.maSanPham,sanPham.trangThai ,SanPham.chietKhau, SanPham.giaTien , SanPham.mieuTa, SanPham.tenSanPham,  SanPham.maLoaiSanPham, SanPham.maMonTheThao, SanPham.maNhanHieu  order by SanPham.maSanPham offset "
					+ numPage + " rows  fetch next " + limit + " rows only";
			List<SanPham> list = session.createNativeQuery(sql, SanPham.class).getResultList();
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getMaSanPhamCuoiCung() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String maSanPhamCuoi;
		try {
			String sql = "select top 1 maSanPham from SanPham order by maSanPham desc";
			maSanPhamCuoi = (String) session.createNativeQuery(sql).getSingleResult();
			return maSanPhamCuoi;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SanPham> getSanPhamFilter(String strLoaiSanPham, String strMonTheThao, String strNhanHieu,
			double price_to,
			double price_from, int pageIndex, int limit) {
		int numStart = (pageIndex - 1) * limit;
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "select SanPham.maSanPham, SanPham.chietKhau, sanPham.trangThai,SanPham.giaTien , SanPham.mieuTa, SanPham.tenSanPham,  SanPham.maLoaiSanPham, SanPham.maMonTheThao, SanPham.maNhanHieu  from SanPham join LoaiSanPham on SanPham.maLoaiSanPham = LoaiSanPham.maLoaiSanPham\r\n"
					+ "						join MonTheThao on SanPham.maMonTheThao = MonTheThao.maMonTheThao \r\n"
					+ "						join NhanHieu on SanPham.maNhanHieu = NhanHieu.maNhanHieu\r\n"
					+ "						join ChiTietSanPham on SanPham.maSanPham = ChiTietSanPham.maSanPham\r\n"
					+ "						where "
					+ strLoaiSanPham + "and" + strMonTheThao + "and" + strNhanHieu + "and (SanPham.giaTien >="
					+ price_from + " and SanPham.giaTien<=" + price_to + ") "
					+ "group by SanPham.maSanPham,sanPham.trangThai ,SanPham.chietKhau, SanPham.giaTien , SanPham.mieuTa, SanPham.tenSanPham,  SanPham.maLoaiSanPham, SanPham.maMonTheThao, SanPham.maNhanHieu  "
					+ "order by SanPham.maSanPham offset " + numStart + " rows  fetch next " + limit + " rows only";
			List<SanPham> list = session.createNativeQuery(sql, SanPham.class).getResultList();
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getNumResult(String strLoaiSanPham, String strMonTheThao, String strNhanHieu, double price_to,
			double price_from) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select  count( distinct SanPham.maSanPham)\r\n"
					+ "						from SanPham join LoaiSanPham on SanPham.maLoaiSanPham = LoaiSanPham.maLoaiSanPham\r\n"
					+ "						join NhanHieu on SanPham.maNhanHieu = NhanHieu.maNhanHieu\r\n"
					+ "						join MonTheThao on SanPham.maMonTheThao = MonTheThao.maMonTheThao \r\n"
					+ "						join ChiTietSanPham on SanPham.maSanPham = ChiTietSanPham.maSanPham\r\n"
					+ "						where "
					+ strLoaiSanPham + "and" + strMonTheThao + "and" + strNhanHieu + "and (SanPham.giaTien >="
					+ price_from + " and SanPham.giaTien<=" + price_to + ")";

			int num = Integer.parseInt(session.createNativeQuery(sql).uniqueResult().toString());
			return num;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public List<SanPham> getSanPhamByLoaiSanPham(String loaiSanPham) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select top 10 * from SanPham join LoaiSanPham on SanPham.maLoaiSanPham = LoaiSanPham.maLoaiSanPham where tenLoaiSanPham like N'"
					+ loaiSanPham + "' order by SanPham.maSanPham desc";
			List<SanPham> listResult = session.createNativeQuery(sql, SanPham.class).getResultList();
			return listResult;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SanPham> getAllTop20() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select top 20 * from SanPham";
			List<SanPham> listResult = session.createNativeQuery(sql, SanPham.class).getResultList();
			return listResult;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
