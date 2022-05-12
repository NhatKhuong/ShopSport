package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.ChiTietSanPhamDao;
import com.se.entity.ChiTietSanPham;
import com.se.service.ChiTietSanPhamService;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
	@Autowired
	private ChiTietSanPhamDao chiTietSanPhamDao;

	@Override
	@Transactional
	public ChiTietSanPham getChiTietSanPhamByMaSanPhamMaKichThuoc(String maSanPham, String maKichThuoc) {
		// TODO Auto-generated method stub
		return chiTietSanPhamDao.getChiTietSanPhamByMaSanPhamMaKichThuoc(maSanPham, maKichThuoc);
	}

	@Override
	@Transactional
	public List<ChiTietSanPham> getChiTietSanPhamTheoMa(String ma) {

		return chiTietSanPhamDao.getDanhSachChiTietSanPhamTheoMa(ma);
	}

	@Override
	@Transactional
	public void update(ChiTietSanPham chiTietSanPham) {
		chiTietSanPhamDao.update(chiTietSanPham);
	}

	@Override
	@Transactional
	public void add(ChiTietSanPham chiTietSanPham) {
		chiTietSanPhamDao.add(chiTietSanPham);
	}

	@Override
	@Transactional
	public String getMaChiTietSanPhamCuoiCung() {
		// TODO Auto-generated method stub
		return chiTietSanPhamDao.getMaChiTietSanPhamCuoiCung();
	}
}
