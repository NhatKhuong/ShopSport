package com.se.dao;

import java.util.List;

import com.se.entity.SanPhamTrongGioHang;

public interface SanPhamTrongGioHangDao {
	public void add(SanPhamTrongGioHang sanPhamTrongGioHang);
	public void delete(String id);
	public void update(SanPhamTrongGioHang sanPhamTrongGioHang);
	public List<SanPhamTrongGioHang> getDSSanPhamTrongGioHangTheoMaNguoiDung(String maNguoiDung);
	public SanPhamTrongGioHang getById(String id);
	
	
	
}
