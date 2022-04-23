package com.se.dao;

import java.util.List;

import com.se.entity.SanPhamTrongGioHang;

public interface SanPhamTrongGioHangDao {
	public void add(SanPhamTrongGioHangDao sanPhamTrongGioHang);
	public void delete(String maChiTietSan);
	public void update(SanPhamTrongGioHangDao sanPhamTrongGioHang);
	public List<SanPhamTrongGioHang> getDSSanPhamTrongGioHangTheoMaNguoiDung(String maNguoiDung);
	
	
	
}
