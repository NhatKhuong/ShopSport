package com.se.service;

import java.util.List;

import com.se.entity.DanhGia;

public interface DanhGiaDaoService {
	public boolean themDanhGia(DanhGia danhGia);
	public boolean suaDanhGia(DanhGia danhGia);
	public boolean xoaDanhGia(String maNguoiDung, String maSanPham);
	public  List<DanhGia>  layDanhSachDanhGiaTheoMaSanPham(int page, int limit, String maSanPham);
	public  DanhGia  layDanhGiaTheoMaSanPhamVaMaNguoiDung( String maSanPham, String maNguoiDung);
	public int soLuongDanhGiaTheoMaSanPham( String maSanPham);
}
