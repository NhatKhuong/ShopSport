package com.se.dao;

import java.util.List;

import com.se.entity.ChiTietDonHang;
import com.se.entity.DonHang;

public interface DonHangDao {
	public String getId();
	public boolean themHoaDon(DonHang donHang);
//	public ChiTietDonHang getChiTietDonHangTheoTenKichThuocVaMaSanPham(String maSanPham, String tenKichThuoc);
}
