package com.se.service;

import java.util.List;

import com.se.dao.SanPhamTrongGioHangDao;
import com.se.entity.SanPhamTrongGioHang;

public interface SanPhamTrongGioHangService {
	
	public void add(SanPhamTrongGioHangDao sanPhamTrongGioHang);
	public void delete(String maChiTietSan);
	public void update(SanPhamTrongGioHangDao sanPhamTrongGioHang);
	public List<SanPhamTrongGioHang> getDSSanPhamTrongGioHangTheoMaNguoiDung(String maNguoiDung);

}
