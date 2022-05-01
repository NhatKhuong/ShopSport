package com.se.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.DanhGiaDao;
import com.se.entity.DanhGia;
import com.se.service.DanhGiaDaoService;

@Service
public class DanhGiaDaoServiceImpl implements DanhGiaDaoService {

	@Autowired
	private DanhGiaDao danhGiaDao;
	
	@Override
	@Transactional
	public boolean themDanhGia(DanhGia danhGia) {
		// TODO Auto-generated method stub
		return danhGiaDao.themDanhGia(danhGia);
	}

	@Override
	@Transactional
	public boolean suaDanhGia(DanhGia danhGia) {
		// TODO Auto-generated method stub
		return danhGiaDao.suaDanhGia(danhGia);
	}

	@Override
	@Transactional
	public boolean xoaDanhGia(String maNguoiDung, String maSanPham) {
		// TODO Auto-generated method stub
		return danhGiaDao.xoaDanhGia(maNguoiDung, maSanPham);
	}

	@Override
	@Transactional
	public List<DanhGia>  layDanhSachDanhGiaTheoMaSanPham(int page, int limit, String maSanPham){
	
		return danhGiaDao.layDanhSachDanhGiaTheoMaSanPham(page, limit, maSanPham);
	}
	@Override
	@Transactional
	public int soLuongDanhGiaTheoMaSanPham(String maSanPham) {
		
		return danhGiaDao.soLuongDanhGiaTheoMaSanPham(maSanPham);
	}

}
