package com.se.service;

import java.util.List;

import com.se.entity.ChiTietDonHang;
import com.se.entity.DonHang;

public interface DonHangService {
	public boolean themHoaDon(DonHang donHang);
	public List<DonHang> layDanhSachDonHang(int page, int limit, String maTrangThai);
	public int layTongDonHangTheoTrangThai(String maTrangThai);
	public DonHang getDonHangById(String maDonHang);
}
