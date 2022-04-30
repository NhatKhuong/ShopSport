package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.SanPhamDao;
import com.se.entity.ChiTietSanPham;
import com.se.entity.SanPham;
import com.se.service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService{
	@Autowired
	private SanPhamDao sanPhamDao; 

	@Override
	@Transactional
	public void save(SanPham sanPham) {
		sanPhamDao.save(sanPham);
		
	}

	@Override
	@Transactional
	public void delete(String maSanPham) {
		// TODO Auto-generated method stub
		sanPhamDao.delete(maSanPham);
		
	}

	@Override
	@Transactional
	public void update(SanPham sanPham) {
		// TODO Auto-generated method stub
		sanPhamDao.update(sanPham);
		
	}

	@Override
	@Transactional
	public SanPham getById(String id) {
		// TODO Auto-generated method stub
		return sanPhamDao.getById(id);
	}

	@Override
	@Transactional
	public List<SanPham> getAll() {
		// TODO Auto-generated method stub
		return sanPhamDao.getAll();
	}

	@Override
	@Transactional
	public List<SanPham> getByFilter(String tenLoai, String tenMon, String tenThuongHieu, double fromPrice,
			double toPrice, int numPage, int limit) {
		// TODO Auto-generated method stub
		return sanPhamDao.getByFilter(tenLoai, tenMon, tenThuongHieu, fromPrice, toPrice, numPage, limit);
	}

	@Override
	@Transactional
	public List<SanPham> getSanPhamFilter(String strLoaiSanPham, String strMonTheThao, String strNhanHieu,
			double price_to, double price_from, int pageIndex, int limit) {
		return sanPhamDao.getSanPhamFilter(strLoaiSanPham, strMonTheThao, strNhanHieu, price_to, price_from, pageIndex, limit);
	}

	@Override
	@Transactional
	public int getNumResult(String strLoaiSanPham, String strMonTheThao, String strNhanHieu, double price_to,
			double price_from) {
		return sanPhamDao.getNumResult(strLoaiSanPham, strMonTheThao, strNhanHieu, price_to, price_from);
	}

	@Override
	@Transactional
	public List<SanPham> getSanPhamByLoaiSanPham(String loaiSanPham) {
		return sanPhamDao.getSanPhamByLoaiSanPham(loaiSanPham);
	}

	@Override
	@Transactional
	public List<SanPham> getAllTop20() {
		return sanPhamDao.getAllTop20();
	}

}
