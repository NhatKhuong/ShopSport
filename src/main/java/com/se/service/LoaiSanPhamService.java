package com.se.service;

import java.util.List;

import com.se.entity.LoaiSanPham;

public interface LoaiSanPhamService {
	public List<LoaiSanPham> getAllLoaiSanPham();
	public String getMaLoaiSanPhamCuoiCung();
	public void saveLoaiSanPham(LoaiSanPham loaiSanPham);
	public LoaiSanPham timLoaiSanPhambangTen(String tenLoaiSanPham);
}
