package com.se.dao;

import java.util.List;

import com.se.entity.ChiTietSanPham;

public interface ChiTietSanPhamDao {
	public ChiTietSanPham getChiTietSanPhamByMaSanPhamMaKichThuoc(String maSanPham,String maKichThuoc);
	public List<ChiTietSanPham> getDanhSachChiTietSanPhamTheoMa(String ma) ;
	public void update(ChiTietSanPham chiTietSanPham);
	public void add(ChiTietSanPham chiTietSanPham);
	public String getMaChiTietSanPhamCuoiCung();
	public boolean giamSoLuongTonChiTietSanPhamTheoMa(String maChiTietSanPham, int soLuong);
	
}
