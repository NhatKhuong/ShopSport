package com.se.service;

import java.util.List;

import com.se.entity.SanPham;

public interface SanPhamService {
	public void save(SanPham sanPham);

	public void delete(String maSanPham);

	public void update(SanPham sanPham);

	public SanPham getById(String id);

	public List<SanPham> getAll();

	public List<SanPham> getByFilter(String tenLoai, String tenMon, String tenThuongHieu, double fromPrice,
			double toPrice, int numPage, int limit);

	public String getMaSanPhamCuoiCung();

	public List<SanPham> getSanPhamFilter(String strLoaiSanPham, String strMonTheThao, String strNhanHieu,
			double price_to,
			double price_from, int pageIndex, int limit);

	public int getNumResult(String strLoaiSanPham, String strMonTheThao, String strNhanHieu, double price_to,
			double price_from);

	public List<SanPham> getSanPhamByLoaiSanPham(String loaiSanPham);

	public List<SanPham> getAllTop20();
	
	public List<SanPham> getByName_Status(String tenSanPham, int trangThai, double giaTien,String loaiSanPham);

	public int getSoLuongSanPhamTheoMa(String ma) ;
	
	public List<?> getDanhSachSanPham_SoLuong() ;
	boolean capNhatSanPham(String maSanPham, String tenSanPham, double giaSanPham, int trangThai);
	
	public double getMaxPrice(String strLoaiSanPham, String strMonTheThao, String strNhanHieu);
	
	public List<SanPham> getDanhSachSanPhamTimKiem(String condition);
	
	public List<SanPham> getSanPhamBanChay();
	
}
