package com.se.dao;

import java.util.List;

import com.se.entity.DiaChi;

public interface DiaChiDao {
	public List<DiaChi> getDanhSachDiaChi();
	public List<String> getDanhSachTinhThanhPho();
	public List<String> getDanhSachQuanHuyenTheoTinh(String thanhPho);
	public List<String> getDanhSachPhuongXaTheoQuanHuyenVaTinh(String quanHuyen , String tinhThanhPho);
	public DiaChi getDiaChi(String PhuongXa ,String quanHuyen , String tinhThanhPho);
}
                                                                           
