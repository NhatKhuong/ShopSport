package com.se.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.se.entity.ChiTietDonHang;
import com.se.entity.DonHang;
import com.se.entity.TrangThaiDonHang;

@Repository
public interface DonHangDao {
	public String getId();

	public boolean themHoaDon(DonHang donHang);

	public List<DonHang> getDanhSachDonHang();

	public List<DonHang> getDanhSachDonHangTheoTrangThai(String maTrangThai, String maNguoiDung, String tenNguoiDung);

	public double tinhTongTien(String maHoaDon);

	public void update(DonHang donHang);

	public DonHang getDonHangById(String maDonHang);

	// public ChiTietDonHang getChiTietDonHangTheoTenKichThuocVaMaSanPham(String
	// maSanPham, String tenKichThuoc);
	public List<DonHang> layDanhSachDonHang(int page, int limit, String maTrangThai);

	public int layTongDonHangTheoTrangThai(String maTrangThai);
	


}
