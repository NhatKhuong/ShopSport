package com.se.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.SanPhamDao;
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
			if (sanPham.isTrangThai())
				sanPham.setTrangThai(false);
			else
				sanPham.setTrangThai(true);
			session.update(sanPham);
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
			double price_to, double price_from, int pageIndex, int limit) {
		int numStart = (pageIndex - 1) * limit;
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "select SanPham.maSanPham, SanPham.chietKhau, sanPham.trangThai,SanPham.giaTien , SanPham.mieuTa, SanPham.tenSanPham,  SanPham.maLoaiSanPham, SanPham.maMonTheThao, SanPham.maNhanHieu  from SanPham join LoaiSanPham on SanPham.maLoaiSanPham = LoaiSanPham.maLoaiSanPham\r\n"
					+ "						join MonTheThao on SanPham.maMonTheThao = MonTheThao.maMonTheThao \r\n"
					+ "						join NhanHieu on SanPham.maNhanHieu = NhanHieu.maNhanHieu\r\n"
					+ "						join ChiTietSanPham on SanPham.maSanPham = ChiTietSanPham.maSanPham\r\n"
					+ "						where " + "("+strLoaiSanPham+")" + "and" + "("+strMonTheThao+")" + "and" + "("+strNhanHieu+")"
					+ "and (SanPham.giaTien >=" + price_from + " and SanPham.giaTien<=" + price_to + ") "
					+ "group by SanPham.maSanPham,sanPham.trangThai ,SanPham.chietKhau, SanPham.giaTien , SanPham.mieuTa, SanPham.tenSanPham,  SanPham.maLoaiSanPham, SanPham.maMonTheThao, SanPham.maNhanHieu  "
					+ "order by SanPham.maSanPham offset " + numStart + " rows  fetch next " + limit + " rows only";
			List<SanPham> list = session.createNativeQuery(sql, SanPham.class).getResultList();
			System.out.println(sql);
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
					+ "						where " + "("+strLoaiSanPham+")" + "and" + "("+strMonTheThao+")" + "and" + "("+strNhanHieu+")"
					+ "and (SanPham.giaTien >=" + price_from + " and SanPham.giaTien<=" + price_to + ")";

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

	@Override
	public List<SanPham> getByName_Status(String tenSanPham, int trangThai, double giaTien, String loaiSanPham) {
		String sql = "";
		if (trangThai == 2) {
			if (loaiSanPham.equals("Tất cả")) {
				sql += "select * from SanPham where tenSanPham like N'%" + tenSanPham + "%'" + " and giaTien>="
						+ giaTien;
			} else {
				sql += "select * from SanPham sp join LoaiSanPham lsp on lsp.maLoaiSanPham=sp.maLoaiSanPham where tenSanPham like N'%"
						+ tenSanPham + "%' " + "and  lsp.tenLoaiSanPham like N'%" + loaiSanPham + "%' "
						+ "and giaTien>=" + giaTien;
			}
		} else {
			if (loaiSanPham.equals("Tất cả")) {
				sql += "select * from SanPham sp join LoaiSanPham lsp on lsp.maLoaiSanPham=sp.maLoaiSanPham where trangThai="
						+ trangThai + "and  tenSanPham like N'%" + tenSanPham + "%' " + "and giaTien>=" + giaTien;
			} else {
				sql += "select * from SanPham sp join LoaiSanPham lsp on lsp.maLoaiSanPham=sp.maLoaiSanPham where trangThai="
						+ trangThai + "and  tenSanPham like N'%" + tenSanPham + "%' "
						+ "and  lsp.tenLoaiSanPham like N'%" + loaiSanPham + "%' " + "and giaTien>=" + giaTien;
			}
		}
		Session session = sessionFactory.getCurrentSession();
		try {
			List<SanPham> list = session.createNativeQuery(sql, SanPham.class).getResultList();
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getSoLuongSanPhamTheoMa(String ma) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		int soLuong;
		try {
			String sql = "select sum(soLuongTon) from ChiTietSanPham ct join SanPham sp on sp.maSanPham = ct.maSanPham\r\n"
					+ "where sp.maSanPham ='" + ma + "'";

			soLuong = (Integer) session.createNativeQuery(sql).uniqueResult();

			return soLuong;
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<?> getDanhSachSanPham_SoLuong() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "SELECT        SanPham.maSanPham, SanPham.tenSanPham, SUM(ChiTietSanPham.soLuongTon) AS [soLuong], SanPham.giaTien, LoaiSanPham.tenLoaiSanPham, SanPham.trangThai\r\n"
					+ "FROM            ChiTietSanPham INNER JOIN\r\n"
					+ "                         SanPham ON ChiTietSanPham.maSanPham = SanPham.maSanPham INNER JOIN\r\n"
					+ "                         LoaiSanPham ON SanPham.maLoaiSanPham = LoaiSanPham.maLoaiSanPham\r\n"
					+ "GROUP BY SanPham.maSanPham, SanPham.tenSanPham, ChiTietSanPham.soLuongTon, SanPham.giaTien, LoaiSanPham.tenLoaiSanPham, SanPham.trangThai\r\n";
			List<?> list = session.createNativeQuery(sql).getResultList();

			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@Override
	public boolean capNhatSanPham(String maSanPham, String tenSanPham, double giaSanPham, int trangThai) {
		Session session = sessionFactory.getCurrentSession();
		try {
			SanPham sanPham = session.find(SanPham.class, maSanPham);
			sanPham.setTenSanPham(tenSanPham);
			sanPham.setGiaTien(giaSanPham);
			if(trangThai==1)
				sanPham.setTrangThai(true);
			if(trangThai==0)
				sanPham.setTrangThai(false);
			session.update(sanPham);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public double getMaxPrice(String strLoaiSanPham, String strMonTheThao, String strNhanHieu) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			String sql = "select  top 1 giaTien\r\n"
					+ "						from SanPham join LoaiSanPham on SanPham.maLoaiSanPham = LoaiSanPham.maLoaiSanPham\r\n"
					+ "						join NhanHieu on SanPham.maNhanHieu = NhanHieu.maNhanHieu\r\n"
					+ "						join MonTheThao on SanPham.maMonTheThao = MonTheThao.maMonTheThao \r\n"
					+ "						join ChiTietSanPham on SanPham.maSanPham = ChiTietSanPham.maSanPham\r\n"
					+ "						where " + "("+strLoaiSanPham+")" + "and" + "("+strMonTheThao+")" + "and" + "("+strNhanHieu+")"
					+ "order by giaTien desc";
			
		double maxPrice = Double.parseDouble(session.createNativeQuery(sql).uniqueResult().toString());
		return maxPrice;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<SanPham> getDanhSachSanPhamTimKiem(String condition) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String product_name = condition.replaceAll(" ","%");
			String sql = "select * from SanPham where tenSanPham like N'%"+product_name+"%'";
			List<SanPham> list= session.createNativeQuery(sql, SanPham.class).getResultList();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<SanPham> getSanPhamBanChay() {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			String sql = "select top 10 * from SanPham";
			List<SanPham> list = session.createNativeQuery(sql, SanPham.class).getResultList();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
