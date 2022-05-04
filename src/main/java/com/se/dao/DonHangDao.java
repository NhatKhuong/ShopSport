package com.se.dao;

import java.util.List;

import com.se.entity.ChiTietDonHang;
import com.se.entity.DonHang;

public interface DonHangDao {
	public String getId();
	public boolean themHoaDon(DonHang donHang);
	public List<DonHang> getDanhSachDonHang();
	public List<DonHang> getDanhSachDonHangTheoTrangThai(String maTrangThai, String maNguoiDung, String tenNguoiDung);
	public double tinhTongTien(String maHoaDon);
	public void update(DonHang donHang);
	public DonHang getDonHangById(String maDonHang);
//	public ChiTietDonHang getChiTietDonHangTheoTenKichThuocVaMaSanPham(String maSanPham, String tenKichThuoc);
}
