package com.se.service;

import java.util.List;

import com.se.entity.ChiTietSanPham;

public interface ChiTietSanPhamService {
	public ChiTietSanPham getChiTietSanPhamByMaSanPhamMaKichThuoc(String maSanPham,String maKichThuoc);
	public List<ChiTietSanPham> getChiTietSanPhamTheoMa(String ma);
	public boolean giamSoLuongTonChiTietSanPhamTheoMa(String maChiTietSanPham, int soLuong);
}
