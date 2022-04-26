package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.DiaChiDao;
import com.se.entity.DiaChi;
import com.se.service.DiaChiService;

@Service
public class DiaChiServiceImpl implements DiaChiService{

	@Autowired
	private DiaChiDao diaChiDao;
	
	@Override
	@Transactional
	public List<DiaChi> getDanhSachDiaChi() {
		// TODO Auto-generated method stub
		return diaChiDao.getDanhSachDiaChi();
	}

	@Override
	@Transactional
	public List<String> getDanhSachTinhThanhPho() {
		// TODO Auto-generated method stub
		return diaChiDao.getDanhSachTinhThanhPho();
	}

	@Override
	@Transactional
	public List<String> getDanhSachQuanHuyenTheoTinh(String thanhPho) {
		// TODO Auto-generated method stub
		return diaChiDao.getDanhSachQuanHuyenTheoTinh(thanhPho);
	}

	@Override
	@Transactional
	public List<String> getDanhSachPhuongXaTheoQuanHuyenVaTinh(String quanHuyen, String tinhThanhPho) {
		// TODO Auto-generated method stub
		return diaChiDao.getDanhSachPhuongXaTheoQuanHuyenVaTinh(quanHuyen, tinhThanhPho);
	}

	@Override
	@Transactional
	public DiaChi getDiaChi(String PhuongXa, String quanHuyen, String tinhThanhPho) {
		// TODO Auto-generated method stub
		return diaChiDao.getDiaChi(PhuongXa, quanHuyen, tinhThanhPho);
	}

}
