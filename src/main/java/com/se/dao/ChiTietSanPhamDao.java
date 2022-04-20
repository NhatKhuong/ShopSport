package com.se.dao;

import com.se.entity.ChiTietSanPham;

public interface ChiTietSanPhamDao {
	public ChiTietSanPham getChiTietSanPhamByMaSanPham_maKichThuoc(String maSanPham,String maKichThuoc);
}
