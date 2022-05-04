package com.se.dao;

import java.util.List;

import com.se.entity.ChiTietSanPham;

public interface ChiTietSanPhamDao {
	public ChiTietSanPham getChiTietSanPhamByMaSanPhamMaKichThuoc(String maSanPham,String maKichThuoc);
	public List<ChiTietSanPham> getDanhSachChiTietSanPhamTheoMa(String ma) ;
}
