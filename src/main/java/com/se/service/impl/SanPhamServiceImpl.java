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
	public String getMaSanPhamCuoiCung() {
		// TODO Auto-generated method stub
		return sanPhamDao.getMaSanPhamCuoiCung();
	}

}
