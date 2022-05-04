package com.se.service;

import java.util.List;

import com.se.entity.ChiTietDonHang;
import com.se.entity.DonHang;

public interface DonHangService {
	public boolean themHoaDon(DonHang donHang);

	public List<DonHang> layDanhSachDonHang(int page, int limit, String maTrangThai);

	public int layTongDonHangTheoTrangThai(String maTrangThai);

	public List<DonHang> getDanhSachDonHang();

	public List<DonHang> getDanhSachDonHangTheoTrangThai(String maTrangThai, String maNguoiDung, String tenNguoiDung);

	public double tinhTongTien(String maHoaDon);

	public void update(DonHang donHang);

	public DonHang getDonHangById(String maDonHang);

}
