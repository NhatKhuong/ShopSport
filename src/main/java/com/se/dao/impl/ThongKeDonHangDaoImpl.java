package com.se.dao.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.dao.ThongKeDonHangDao;
import com.se.entity.SanPham;

@Repository
public class ThongKeDonHangDaoImpl implements ThongKeDonHangDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int soDonHangTrongKhoangNgay(String ngayBatDau, String ngayKetThuc) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select COUNT(*) AS [Số hóa đơn] from DonHang WHERE ngayTao BETWEEN CAST('" + ngayBatDau
					+ "' AS DATE) AND CAST('" + ngayKetThuc + "' AS DATE)";
			String kq = session.createNativeQuery(sql).uniqueResult().toString();
			int soDonHang = Integer.parseInt(kq);
			return soDonHang;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int soDonHangThanhCong(String ngayBatDau, String ngayKetThuc) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "SELECT        COUNT(*) FROM DonHang INNER JOIN TrangThaiDonHang ON DonHang.maTrangThaiDonHang = TrangThaiDonHang.maTrangThaiDonHang"
					+ "			  WHERE (DonHang.ngayTao BETWEEN CAST('" + ngayBatDau + "' AS DATE) AND CAST('"
					+ ngayKetThuc + "' AS DATE)) AND (DonHang.maTrangThaiDonHang LIKE N'TTDH00004')";
			String kq = session.createNativeQuery(sql).uniqueResult().toString();
			int soDonHang = Integer.parseInt(kq);
			return soDonHang;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public double soTienThuNhap(String ngayBatDau, String ngayKetThuc) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "SELECT        SUM(giaMua * soLuongMua) FROM ChiTietDonHang INNER JOIN DonHang ON ChiTietDonHang.maDonHang = DonHang.maDonHang\r\n"
					+ "						 WHERE ngayTao BETWEEN CAST('" + ngayBatDau + "' AS DATE) AND CAST('"
					+ ngayKetThuc + "' AS DATE)";

			double tienthunhap = Double.parseDouble(session.createNativeQuery(sql).uniqueResult().toString());
			return tienthunhap;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int getCountAll() {
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "SELECT COUNT(*) FROM NguoiDung";
			String so = session.createNativeQuery(sql).uniqueResult().toString();
			int count = Integer.parseInt(so);
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int CountAllSP() {
		Session session = sessionFactory.getCurrentSession();
		String maSanPhamCuoi;
		try {
			String sql = "SELECT COUNT(*) FROM SanPham";
			String soLuong = session.createNativeQuery(sql).uniqueResult().toString();
			int count = Integer.parseInt(soLuong);
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int CountSPHetHang() {
		Session session = sessionFactory.getCurrentSession();
		try {

			String sql = "SELECT        COUNT(*)\r\n" + "FROM            SanPham INNER JOIN\r\n"
					+ "                         ChiTietSanPham ON SanPham.maSanPham = ChiTietSanPham.maSanPham\r\n"
					+ "						 WHERE soLuongTon = 0";
			String so = session.createNativeQuery(sql).uniqueResult().toString();
			int count = Integer.parseInt(so);
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int CountNguoiDungBiChan() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "SELECT COUNT(*) AS [Tổng người bị chặn] FROM NguoiDung\r\n" + "WHERE trangThai = 0";
			String kq = session.createNativeQuery(sql).uniqueResult().toString();
			int soDonHang = Integer.parseInt(kq);
			return soDonHang;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int CountDonHangChoXacNhan(String ngayBatDau, String ngayKetThuc) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "SELECT        COUNT(*) FROM DonHang INNER JOIN TrangThaiDonHang ON DonHang.maTrangThaiDonHang = TrangThaiDonHang.maTrangThaiDonHang"
					+ "			  WHERE (DonHang.ngayTao BETWEEN CAST('" + ngayBatDau + "' AS DATE) AND CAST('"
					+ ngayKetThuc + "' AS DATE)) AND (DonHang.maTrangThaiDonHang LIKE N'TTDH00001')";
			String kq = session.createNativeQuery(sql).uniqueResult().toString();
			int soDonHang = Integer.parseInt(kq);
			return soDonHang;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int CountDonHangHuy(String ngayBatDau, String ngayKetThuc) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "SELECT        COUNT(*) FROM DonHang INNER JOIN TrangThaiDonHang ON DonHang.maTrangThaiDonHang = TrangThaiDonHang.maTrangThaiDonHang"
					+ "			  WHERE (DonHang.ngayTao BETWEEN CAST('" + ngayBatDau + "' AS DATE) AND CAST('"
					+ ngayKetThuc + "' AS DATE)) AND (DonHang.maTrangThaiDonHang LIKE N'TTDH00005')";
			String kq = session.createNativeQuery(sql).uniqueResult().toString();
			int soDonHang = Integer.parseInt(kq);
			return soDonHang;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<SanPham> listSanPhamBanChay(String ngayBatDau, String ngayKetThuc) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "SELECT TOP 5       SanPham.*\r\n" + "FROM            SanPham INNER JOIN\r\n"
					+ "                         ChiTietSanPham ON SanPham.maSanPham = ChiTietSanPham.maSanPham INNER JOIN\r\n"
					+ "                         ChiTietDonHang ON ChiTietSanPham.maChiTietSanPham = ChiTietDonHang.maChiTietSanPham INNER JOIN\r\n"
					+ "                         DonHang ON ChiTietDonHang.maDonHang = DonHang.maDonHang\r\n"
					+ "				WHERE ngayTao BETWEEN CAST('" + ngayBatDau + "' AS DATE) AND CAST('" + ngayKetThuc
					+ "' AS DATE)\r\n"
					+ "				GROUP BY SanPham.maSanPham,SanPham.chietKhau,SanPham.giaTien,SanPham.mieuTa,SanPham.tenSanPham,SanPham.maLoaiSanPham,SanPham.maMonTheThao,SanPham.maNhanHieu,SanPham.trangThai\r\n"
					+ "				ORDER BY COUNT(*) DESC";
			List<SanPham> list = session.createNativeQuery(sql, SanPham.class).getResultList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<?> listHoaDonBan(String ngayBatDau, String ngayKetThuc) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "SELECT       DonHang.maDonHang, NguoiDung.hoTen,DonHang.ngayTao , SUM(ChiTietDonHang.soLuongMua) AS [Số lượng sản phẩm mua], SUM(ChiTietDonHang.giaMua * ChiTietDonHang.soLuongMua) AS [Tổng tiền]\r\n"
					+ "FROM            DonHang INNER JOIN\r\n"
					+ "                         ChiTietDonHang ON DonHang.maDonHang = ChiTietDonHang.maDonHang INNER JOIN\r\n"
					+ "                         ChiTietSanPham ON ChiTietDonHang.maChiTietSanPham = ChiTietSanPham.maChiTietSanPham INNER JOIN\r\n"
					+ "                         NguoiDung ON DonHang.maNguoiDung = NguoiDung.maNguoiDung\r\n"
					+ "WHERE        (DonHang.ngayTao BETWEEN CAST('" + ngayBatDau + "' AS DATE) AND CAST('"
					+ ngayKetThuc + "' AS DATE))\r\n" + "GROUP BY DonHang.maDonHang, NguoiDung.hoTen, ngayTao\r\n" + "";
			List<?> list = session.createNativeQuery(sql).getResultList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> listSanPhamHetHang() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "SELECT        SanPham.maSanPham, SanPham.tenSanPham, KichThuoc.tenKichThuoc, ChiTietSanPham.soLuongTon, SanPham.giaTien,tenLoaiSanPham\r\n"
					+ "FROM            SanPham INNER JOIN\r\n"
					+ "                         ChiTietSanPham ON SanPham.maSanPham = ChiTietSanPham.maSanPham INNER JOIN\r\n"
					+ "                         KichThuoc ON ChiTietSanPham.maKichThuoc = KichThuoc.maKichThuoc INNER JOIN\r\n"
					+ "                         LoaiSanPham ON SanPham.maLoaiSanPham = LoaiSanPham.maLoaiSanPham\r\n"
					+ "WHERE        (ChiTietSanPham.soLuongTon = 0)";

			List<?> listSP = session.createNativeQuery(sql).getResultList();
			return listSP;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<?> listThongKe() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "SELECT       MONTH(ngayTao)AS [Tháng],SUM(giaMua*soLuongMua)AS[Tổng doanh thu]\r\n"
					+ "FROM            DonHang INNER JOIN\r\n"
					+ "                         ChiTietDonHang ON DonHang.maDonHang = ChiTietDonHang.maDonHang\r\n"
					+ "WHERE ChiTietDonHang.maDonHang = DonHang.maDonHang AND YEAR(ngayTao) = YEAR(GETDATE())\r\n"
					+ "GROUP BY  MONTH(ngayTao)";
			List<?> listThongKe = session.createNativeQuery(sql).getResultList();
			return listThongKe;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
