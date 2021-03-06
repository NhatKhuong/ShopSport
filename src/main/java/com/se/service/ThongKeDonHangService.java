package com.se.service;

import java.util.List;

import com.se.entity.SanPham;

public interface ThongKeDonHangService {
	public int soDonHangTrongKhoangNgay(String ngayBatDau, String ngayKetThuc);
	public int soDonHangThanhCong(String ngayBatDau,String ngayKetThuc);
	public double soTienThuNhap(String ngayBatDau, String ngayKetThuc);
	public int getCountAll();
	public int CountAllSP();
	public int CountSPHetHang();
	public int CountDonHangChoXacNhan(String ngayBatDau,String ngayKetThuc);
	public int CountDonHangHuy(String ngayBatDau,String ngayKetThuc);
	public int CountNguoiDungBiChan();
	public List<SanPham> listSanPhamBanChay(String ngayBatDau, String ngayKetThuc);
	public List<?> listSanPhamHetHang(int page, int instance);
	public List<?> listThongKe(String nam) ;
	public List<?> listHoaDonBan(String ngayBatDau, String ngayKetThuc,int page, int instance);
	//thêm
	public List<String> getNamThongKe();
}
