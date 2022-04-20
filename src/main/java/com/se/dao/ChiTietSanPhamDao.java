package com.se.dao;

import com.se.entity.ChiTietSanPham;

public interface ChiTietSanPhamDao {
	public ChiTietSanPham getChiTietSanPhamByMaSanPham_tenKichThuoc(String maSanPham,String maKichThuoc);
}
