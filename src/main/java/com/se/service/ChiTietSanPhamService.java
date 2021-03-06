package com.se.service;

import java.util.List;

import com.se.entity.ChiTietSanPham;

public interface ChiTietSanPhamService {
	public ChiTietSanPham getChiTietSanPhamByMaSanPhamMaKichThuoc(String maSanPham,String maKichThuoc);
	public List<ChiTietSanPham> getChiTietSanPhamTheoMa(String ma);
	void update(ChiTietSanPham chiTietSanPham);
	void add(ChiTietSanPham chiTietSanPham);
	public String getMaChiTietSanPhamCuoiCung();
	public boolean giamSoLuongTonChiTietSanPhamTheoMa(String maChiTietSanPham, int soLuong);
	
	public ChiTietSanPham getChiTietTheoMa(String maChiTiet);
	public void updateChiTietSanPham(ChiTietSanPham chiTietSanPham);
}
