package com.se.service;

import java.util.List;

import com.se.dao.SanPhamTrongGioHangDao;
import com.se.entity.SanPhamTrongGioHang;

public interface SanPhamTrongGioHangService {
	
	public void add(SanPhamTrongGioHang sanPhamTrongGioHang);
	public void delete(String id);
	public void update(SanPhamTrongGioHang sanPhamTrongGioHang);
	public List<SanPhamTrongGioHang> getDSSanPhamTrongGioHangTheoMaNguoiDung(String maNguoiDung);
	public SanPhamTrongGioHang getById(String id);

}
