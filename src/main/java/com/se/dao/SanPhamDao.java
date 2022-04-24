package com.se.dao;

import java.util.List;

import com.se.entity.SanPham;

public interface SanPhamDao {
	public void save(SanPham sanPham);
	public void delete(String maSanPham);
	public void update(SanPham sanPham);
	public SanPham getById(String id);
	public List<SanPham> getAll();
	public List<SanPham> getByFilter(String tenLoai, String tenMon, String tenThuongHieu, double fromPrice, double toPrice, int numPage, int limit);

}