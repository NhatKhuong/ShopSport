package com.se.dao;

import java.util.List;

import com.se.entity.ChiTietSanPham;
import com.se.entity.SanPham;

public interface SanPhamDao {
	public void save(SanPham sanPham);
	public void delete(String maSanPham);
	public void update(SanPham sanPham);
	public SanPham getById(String id);
	public List<SanPham> getAll();
	public List<SanPham> getAllTop20();
	public List<SanPham> getSanPhamByLoaiSanPham(String loaiSanPham);
	public List<SanPham> getSanPhamFilter(String strLoaiSanPham,String strMonTheThao,String nhanHieu, double price_to, double price_from, int pageIndex, int limit);
	public List<SanPham> getByFilter(String tenLoai, String tenMon, String tenThuongHieu, double fromPrice, double toPrice, int numPage, int limit);
	public int getNumResult(String strLoaiSanPham,String strMonTheThao,String strNhanHieu, double price_to, double price_from);


}
