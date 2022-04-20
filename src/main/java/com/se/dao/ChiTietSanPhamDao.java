package com.se.dao;

import com.se.entity.ChiTietSanPham;

public interface ChiTietSanPhamDao {
	public ChiTietSanPham getChiTietSanPhamByMaSanPhamMaKichThuoc(String maSanPham,String maKichThuoc);
}
