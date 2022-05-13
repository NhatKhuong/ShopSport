package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.ThongKeDonHangDao;
import com.se.entity.SanPham;
import com.se.service.ThongKeDonHangService;

@Service
public class ThongKeDonHangServiceImpl implements ThongKeDonHangService {

	@Autowired
	ThongKeDonHangDao donHangDao;

	@Override
	@Transactional
	public int soDonHangTrongKhoangNgay(String ngayBatDau, String ngayKetThuc) {
		// TODO Auto-generated method stub
		return donHangDao.soDonHangTrongKhoangNgay(ngayBatDau, ngayKetThuc);
	}

	@Override
	@Transactional
	public int soDonHangThanhCong(String ngayBatDau, String ngayKetThuc) {
		// TODO Auto-generated method stub
		return donHangDao.soDonHangThanhCong(ngayBatDau, ngayKetThuc);
	}

	@Override
	@Transactional
	public double soTienThuNhap(String ngayBatDau, String ngayKetThuc) {
		// TODO Auto-generated method stub
		return donHangDao.soTienThuNhap(ngayBatDau, ngayKetThuc);
	}

	@Override
	@Transactional
	public int getCountAll() {
		// TODO Auto-generated method stub
		return donHangDao.getCountAll();
	}

	@Override
	@Transactional
	public int CountAllSP() {
		// TODO Auto-generated method stub
		return donHangDao.CountAllSP();
	}

	@Override
	@Transactional
	public int CountSPHetHang() {
		// TODO Auto-generated method stub
		return donHangDao.CountSPHetHang();
	}

	@Override
	@Transactional
	public int CountDonHangChoXacNhan(String ngayBatDau, String ngayKetThuc) {
		// TODO Auto-generated method stub
		return donHangDao.CountDonHangChoXacNhan(ngayBatDau, ngayKetThuc);
	}

	@Override
	@Transactional
	public int CountDonHangHuy(String ngayBatDau, String ngayKetThuc) {
		// TODO Auto-generated method stub
		return donHangDao.CountDonHangHuy(ngayBatDau, ngayKetThuc);
	
	}

	@Override
	@Transactional
	public int CountNguoiDungBiChan() {
		// TODO Auto-generated method stub
		return donHangDao.CountNguoiDungBiChan();
	}

	@Override
	@Transactional
	public List<SanPham> listSanPhamBanChay(String ngayBatDau, String ngayKetThuc) {
		// TODO Auto-generated method stub
		return donHangDao.listSanPhamBanChay(ngayBatDau, ngayKetThuc);
	}

	@Override
	@Transactional
	public List<?> listHoaDonBan(String ngayBatDau, String ngayKetThuc,int page, int instance)  {
		// TODO Auto-generated method stub
		return donHangDao.listHoaDonBan(ngayBatDau, ngayKetThuc,page,instance);
	}

	@Override
	@Transactional
	public List<?> listSanPhamHetHang(int page, int instance)  {
		// TODO Auto-generated method stub
		return donHangDao.listSanPhamHetHang(page,instance);
	}

	@Override
	@Transactional
	public List<?> listThongKe(String nam) {
		// TODO Auto-generated method stub
		return donHangDao.listThongKe(nam);
	}

	@Override
	@Transactional
	public List<String> getNamThongKe() {
		// TODO Auto-generated method stub
		return donHangDao.getNamThongKe();
	}
}
