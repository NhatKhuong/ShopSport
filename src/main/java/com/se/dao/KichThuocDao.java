package com.se.dao;

import java.util.List;

import com.se.entity.KichThuoc;

public interface KichThuocDao {
	public List<String> getDsKichThuocTheoMaSanPham(String maSp);
	public KichThuoc getKichThuocTheoTenKichThuoc(String tenKichThuoc);
	public List<KichThuoc> getKichThuocTheoLoaiKichThuoc(String maLoaiKichThuoc);
}
