package com.se.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.ChiTietSanPhamDao;
import com.se.entity.ChiTietSanPham;
import com.se.service.ChiTietSanPhamService;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService{
	@Autowired
	private ChiTietSanPhamDao chiTietSanPhamDao;

	@Override
	@Transactional
	public ChiTietSanPham getChiTietSanPhamByMaSanPham_tenKichThuoc(String maSanPham, String maKichThuoc) {
		// TODO Auto-generated method stub
		return chiTietSanPhamDao.getChiTietSanPhamByMaSanPham_tenKichThuoc(maSanPham, maKichThuoc);
	}

}
