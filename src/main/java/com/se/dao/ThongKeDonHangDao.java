package com.se.dao;

import java.util.List;

import com.se.entity.SanPham;

public interface ThongKeDonHangDao {
	public int soDonHangTrongKhoangNgay(String ngayBatDau,String ngayKetThuc);
	public int soDonHangThanhCong(String ngayBatDau,String ngayKetThuc);
	public double soTienThuNhap(String ngayBatDau,String ngayKetThuc);
	public int getCountAll();
	public int CountAllSP();
	public int CountSPHetHang();
	public int CountDonHangChoXacNhan(String ngayBatDau,String ngayKetThuc);
	public int CountDonHangHuy(String ngayBatDau,String ngayKetThuc);
	public int CountNguoiDungBiChan();
	public List<SanPham> listSanPhamBanChay(String ngayBatDau, String ngayKetThuc);
	public List<?> listHoaDonBan(String ngayBatDau,String ngayKetThuc,int page, int instance);
	public List<?> listSanPhamHetHang(int page, int instance);
	public List<?> listThongKe(String nam);
	//thêm 
	public List<String> getNamThongKe();
	
}
