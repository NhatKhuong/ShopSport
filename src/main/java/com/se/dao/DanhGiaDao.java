package com.se.dao;

import java.util.List;

import com.se.entity.DanhGia;

public interface DanhGiaDao {
	public boolean themDanhGia(DanhGia danhGia);
	public boolean suaDanhGia(DanhGia danhGia);
	public boolean xoaDanhGia(String maNguoiDung, String maSanPham);
	public  List<DanhGia>  layDanhSachDanhGiaTheoMaSanPham(int page, int limit, String maSanPham);
	public int soLuongDanhGiaTheoMaSanPham( String maSanPham);
}
