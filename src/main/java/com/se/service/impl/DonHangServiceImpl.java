package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.DonHangDao;
import com.se.entity.DonHang;
import com.se.service.DonHangService;

@Service
public class DonHangServiceImpl implements DonHangService {

	@Autowired 
	 private DonHangDao donHangDao;
	
	@Override
	@Transactional
	public boolean themHoaDon(DonHang donHang) {
		// TODO Auto-generated method stub
		return donHangDao.themHoaDon(donHang);
	}

	@Override
	@Transactional
	public List<DonHang> getDanhSachDonHang() {
		return donHangDao.getDanhSachDonHang();
	}



	@Override
	@Transactional
	public double tinhTongTien(String maHoaDon) {
		return donHangDao.tinhTongTien(maHoaDon);
	}

	@Override
	@Transactional
	public void update(DonHang donHang) {
		donHangDao.update(donHang);
	}

	@Override
	@Transactional
	public DonHang getDonHangById(String maDonHang) {
		// TODO Auto-generated method stub
		return donHangDao.getDonHangById(maDonHang);
	}

	@Override
	@Transactional
	public List<DonHang> getDanhSachDonHangTheoTrangThai(String maTrangThai, String maNguoiDung, String tenNguoiDung) {
		// TODO Auto-generated method stub
		return donHangDao.getDanhSachDonHangTheoTrangThai(maTrangThai, maNguoiDung, tenNguoiDung);
	}
}
